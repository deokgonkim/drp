package net.dgkim.drp.control;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.dgkim.drp.model.IpAddress;
import net.dgkim.drp.model.JsonResponse;
import net.dgkim.drp.model.User;
import net.dgkim.drp.service.IpmService;
import net.dgkim.drp.service.UserService;

@Controller
public class DataController {
    
    @RequestMapping("/data/users.json")
    public @ResponseBody List<User> users() throws NamingException {
        List<User> list = null;
        
        list = userService.getAllUsers();
        
        return list;
    }
    
    @RequestMapping("/data/ipaddresses.json")
    public @ResponseBody List<IpAddress> ipaddresses() throws NamingException {
        List<IpAddress> ipAddressList = null;
        
        ipAddressList = ipmService.getAllIpAddresses();
        
        return ipAddressList;
    }
    
    @RequestMapping("/data/ipaddress/update.json")
    public @ResponseBody JsonResponse ipaddressUpdate(@RequestBody IpAddress[] ipAddresses) throws NamingException {
        JsonResponse result = null;
        
        for ( IpAddress ipaddress : ipAddresses ) {
            ipmService.updateIpAddress(ipaddress);
        }
        
        result = new JsonResponse();
        result.setSuccess(true);
        
        return result;
    }
    
    @ExceptionHandler({NamingException.class, SQLException.class})
    public ModelAndView handleException(Exception e) {
        ModelAndView mv = null;
        
        mv = new ModelAndView("jsonerror");
        mv.addObject("MESSAGE", e.getMessage());
        return mv;
    }
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @Autowired
    public void setIpmService(IpmService ipmService) {
        this.ipmService = ipmService;
    }
    
    private UserService userService = null;
    
    private IpmService ipmService = null;
}
