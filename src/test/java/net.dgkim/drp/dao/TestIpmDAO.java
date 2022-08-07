package net.dgkim.drp.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.dgkim.drp.model.IpAddress;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:app-config.xml", "classpath:db-config.xml" })
public class TestIpmDAO {

    @Test
    public void testGetContext() {
        LdapContext context = null;
        
        try {
            context = dao.getContext();
        } catch (NamingException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertNotNull(context);
    }
    
    @Test
    public void testGetAllIpAddresses() {
        List<IpAddress> list = null;
        
        try {
            list = dao.getAllIpAddresses();
        } catch (NamingException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        
        assertNotNull(list);
        
        assertTrue(list.size() > 0);
    }
    
    @Autowired
    public void setDao(IpmDAO dao) {
        this.dao = dao;
    }
    
    private IpmDAO dao = null;
}
