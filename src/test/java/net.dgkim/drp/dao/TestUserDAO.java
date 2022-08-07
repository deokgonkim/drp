package net.dgkim.drp.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.dgkim.drp.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:app-config.xml", "classpath:db-config.xml" })
public class TestUserDAO {

    final static String LDAP_USER_BASE = System.getenv("LDAP_USER_BASE");

    @Test
    public void testGetAllUsers() {
        List<User> users = null;
        
        try {
            users = dao.getAllUsers();
        } catch (NamingException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        
        assertNotNull(users);
        
        assertTrue(users.size() > 0);
        
        assertTrue( users.get(0).getDn().indexOf(LDAP_USER_BASE) > 1 );
    }
    
    @Autowired
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }
    
    private UserDAO dao = null;
}
