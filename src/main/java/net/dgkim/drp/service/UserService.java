package net.dgkim.drp.service;

import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dgkim.drp.dao.UserDAO;
import net.dgkim.drp.model.User;

@Service
public class UserService {
    
    public List<User> getAllUsers() throws NamingException {
        List<User> list = null;
        
        list = userDao.getAllUsers();
        
        return list;
    }
    
    @Autowired
    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }
    
    private UserDAO userDao = null;
}
