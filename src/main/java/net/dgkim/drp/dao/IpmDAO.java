package net.dgkim.drp.dao;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import net.dgkim.drp.model.IpAddress;

public class IpmDAO extends DirectoryDAO {
    
    public List<IpAddress> getAllIpAddresses() throws NamingException {
        List<IpAddress> list = null;
        
        LdapContext context = null;
        NamingEnumeration ne = null;
        IpAddress ipAddress = null;
        SearchResult sr = null;
        
        context = getContext();
        ne = context.search("ou=Hosts", "(cn=*)", new Object[] { null }, new SearchControls());
        
        while ( ne.hasMoreElements() ) {
            sr = (SearchResult)ne.nextElement();
            Attributes attrs = sr.getAttributes();
            
            if ( attrs.get("cn") != null ) {
                ipAddress = new IpAddress();
                if ( attrs.get("cn") != null && attrs.get("cn").get(0) != null ) {
                    ipAddress.setId( attrs.get("cn").get(0).toString() );
                    ipAddress.setIpAddress( attrs.get("cn").get(0).toString() );
                }
                if ( attrs.get("macaddress") != null && attrs.get("macaddress").get(0) != null ) {
                    ipAddress.setMacAddress( attrs.get("macaddress").get(0).toString() );
                }
                if ( attrs.get("ou") != null && attrs.get("ou").get(0) != null ) {
                    ipAddress.setOrg( attrs.get("ou").get(0).toString() );
                }
                if ( attrs.get("manager") != null && attrs.get("manager").get(0) != null ) {
                    ipAddress.setManager( attrs.get("manager").get(0).toString() );
                }
                if ( attrs.get("owner") != null && attrs.get("owner").get(0) != null ) {
                    ipAddress.setOwner( attrs.get("owner").get(0).toString() );
                }
                if ( attrs.get("description") != null && attrs.get("description").get(0) != null ) {
                    ipAddress.setDescription( attrs.get("description").get(0).toString() );
                }
                if ( list == null ) list = new LinkedList<IpAddress>();
                list.add( ipAddress );
            }
        }
        
        context.close();
        return list;
    }
    
    public void updateIpAddress(IpAddress ipAddress) throws NamingException {
        LdapContext context = null;
        ModificationItem[] mods = null;
        
        String dn = null;
        
        Attribute macAddress = null;
        Attribute ou = null;
        Attribute manager = null;
        Attribute owner = null;
        Attribute description = null;
        
        dn = String.format("cn=%s, ou=Hosts", ipAddress.getId());
        
        context = getContext();
        
        mods = new ModificationItem[5];
        
        if ( ( ipAddress.getMacAddress() == null || ipAddress.getMacAddress().length() == 0 ) && getAttrOn("macAddress", ipAddress.getId()) != null ) {
            macAddress = new BasicAttribute("macAddress");
            mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, macAddress);
        } else {
            macAddress = new BasicAttribute("macAddress", ipAddress.getMacAddress());
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, macAddress);
        }
        if ( ( ipAddress.getOrg() == null || ipAddress.getOrg().length() == 0 ) && getAttrOn("ou", ipAddress.getId()) != null ) {
            ou = new BasicAttribute("ou");
            mods[1] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, ou);
        } else {
            ou = new BasicAttribute("ou", ipAddress.getOrg());
            mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, ou);
        }
        if ( ( ipAddress.getManager() == null || ipAddress.getManager().length() == 0 ) && getAttrOn("manager", ipAddress.getId()) != null ) {
            manager = new BasicAttribute("manager");
            mods[2] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, manager);
        } else {
            manager = new BasicAttribute("manager", ipAddress.getManager());
            mods[2] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, manager);
        }
        if ( ( ipAddress.getOwner() == null || ipAddress.getOwner().length() == 0 ) && getAttrOn("owner", ipAddress.getId()) != null ) {
            owner = new BasicAttribute("owner");
            mods[3] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, owner);
        } else {
            owner = new BasicAttribute("owner", ipAddress.getOwner());
            mods[3] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, owner);
        }
        if ( ( ipAddress.getDescription() == null || ipAddress.getDescription().length() == 0 ) && getAttrOn("description", ipAddress.getId()) != null ) {
            description = new BasicAttribute("description");
            mods[4] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, description);
        } else {
            description = new BasicAttribute("description", ipAddress.getDescription());
            mods[4] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, description);
        }
        context.modifyAttributes(dn, mods);
        context.close();
    }
    
    public String getAttrOn(String attrName, String ipAddress) throws NamingException  {
        String attrValue = null;
        
        LdapContext context = null;
        NamingEnumeration ne = null;
        SearchResult sr = null;
        
        context = getContext();
        ne = context.search("ou=hosts", "(cn={0})", new Object[] { ipAddress }, new SearchControls());
        
        while ( ne.hasMoreElements() ) {
            sr = (SearchResult)ne.nextElement();
            Attributes attrs = sr.getAttributes();
            
            if ( attrs.get(attrName) != null ) {
                attrValue = attrs.get(attrName).get(0) != null ? attrs.get(attrName).toString() : null;
            }
        }
        
        context.close();
        
        return attrValue;
    }
    
    @Override
    public Hashtable<String, String> getEnvironment() {
        Hashtable<String, String> env = null;
        
        env = new Hashtable<String, String>();
        
        env.put("java.naming.factory.initial", namingFactory);
        env.put("java.naming.provider.url", providerUrl);
        
        if ( binddn != null && binddn.length() > 1 ) {
            env.put("java.naming.security.authentication", "simple");
            env.put("java.naming.security.principal", binddn);
            env.put("java.naming.security.credentials", bindpw);
        }
        
        return env;
    }
    
    public void setNamingFactory(String namingFactory) {
        this.namingFactory = namingFactory;
    }
    
    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }
    
    public void setBinddn(String binddn) {
        this.binddn = binddn;
    }
    
    public void setBindpw(String bindpw) {
        this.bindpw = bindpw;
    }
    
    private String namingFactory = null;
    private String providerUrl = null;
    
    private String binddn = null;
    private String bindpw = null;
}
