package net.dgkim.drp.dao;

import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public abstract class DirectoryDAO {
    
    public LdapContext getContext() throws NamingException {
        LdapContext ctx = null;
        
        ctx = new InitialLdapContext(getEnvironment(), null);
        
        return ctx;
    }
    
    public abstract Hashtable<String, String> getEnvironment();
}
