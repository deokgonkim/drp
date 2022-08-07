package net.dgkim.drp.dao;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import net.dgkim.drp.model.User;

public class UserDAO extends DirectoryDAO {

    final static String LDAP_GROUP_BASE = System.getenv("LDAP_GROUP_BASE");
    final static String LDAP_MEMBER_GROUP = System.getenv("LDAP_MEMBER_GROUP");

    public List<User> getAllUsers() throws NamingException {
        List<User> list = null;
        
        LdapContext context = null;
        NamingEnumeration ne = null;
        User user = null;
        SearchResult sr = null;
        
        try {
            context = getContext();
            System.out.println(String.format("LDAP_GROUP_BASE %s", LDAP_GROUP_BASE));
            ne = context.search(LDAP_GROUP_BASE, LDAP_MEMBER_GROUP, new Object[] { null }, new SearchControls());
            
            while ( ne.hasMoreElements() ) {
                sr = (SearchResult)ne.nextElement();
                Attributes attrs = sr.getAttributes();

                String memberAttr = attrs.get("uniqueMember") != null ? "uniqueMember" : ( attrs.get("member") != null ? "member" : null );
                System.out.println(String.format("MemberAttr %s", memberAttr));
                if ( memberAttr != null ) {
                    
                    NamingEnumeration ne2 = attrs.get(memberAttr).getAll();
                    while ( ne2.hasMoreElements() ) {
                        String name = (String)ne2.nextElement();
                        String baseNamespace = context.getNameInNamespace();
                        String userNamespace = name.substring( name.indexOf(",") + 1 ).replaceAll("," + baseNamespace, "");
                        String uid = name.substring( name.indexOf("=") + 1, name.indexOf( userNamespace ) - 1 );
                        System.out.println(String.format("userNamespace %s uid %s", userNamespace, uid));
                        NamingEnumeration ne3 = context.search(userNamespace, "(uid={0})", new Object[] { uid }, new SearchControls());
                        while ( ne3.hasMoreElements() ) {
                            sr = (SearchResult)ne3.nextElement();
                            Attributes attrs2 = sr.getAttributes();
                            
                            if ( attrs.get("cn") != null ) {
                                user = new User();
                                user.setDn(sr.getNameInNamespace().toString());
                                if ( attrs2.get("displayName") != null && attrs2.get("displayName").get(0) != null ) {
                                    user.setDisplayName( attrs2.get("displayName").get(0).toString() );
                                }
                                if ( list == null ) list = new LinkedList<User>();
                                list.add( user );
                            }
                        }
                    }
                }
            }
        } finally {
            if ( context != null ) {
                context.close();
            }
        }
        
        System.out.println(String.format("Users %d", list.size()));
        System.out.println(list.get(0).toString());
        return list;
    }
    
    @Override
    public Hashtable<String, String> getEnvironment() {
        Hashtable<String, String> env = null;
        
        env = new Hashtable<String, String>();
        
        env.put("java.naming.factory.initial", namingFactory);
        env.put("java.naming.provider.url", providerUrl);
        
        return env;
    }
    
    public void setNamingFactory(String namingFactory) {
        this.namingFactory = namingFactory;
    }
    
    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }
    
    private String namingFactory = null;
    private String providerUrl = null;
}
