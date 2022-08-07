package net.dgkim.drp.control;

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
public class TestDataController {
    
    @Test
    public void testGetAllUsers() {
        List<User> userList = null;
        
        try {
            userList = controller.users();
        } catch (NamingException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        
        assertNotNull(userList);
        
        assertTrue(userList.size() > 0);
        
        boolean found = false;
        
        for ( User user : userList ) {
            if ( user.getDisplayName() != null && user.getDisplayName().equals("김 덕곤") ) {
                found = true;
                assertEquals("uid=dgkim,ou=Users,dc=dgkim,dc=net", user.getDn());
            }
        }
        
        assertTrue(found);
    }
    
    @Autowired
    public void setController(DataController controller) {
        this.controller = controller;
    }
    
    private DataController controller = null;
}
