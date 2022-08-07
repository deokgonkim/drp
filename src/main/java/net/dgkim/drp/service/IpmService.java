package net.dgkim.drp.service;

import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dgkim.drp.dao.IpmDAO;
import net.dgkim.drp.model.IpAddress;

@Service
public class IpmService {
    
    public List<IpAddress> getAllIpAddresses() throws NamingException {
        List<IpAddress> list = null;
        
        list = ipmDao.getAllIpAddresses();
        
        return list;
    }
    
    public void updateIpAddress(IpAddress ipAddress) throws NamingException {
        ipmDao.updateIpAddress(ipAddress);
    }
    
    @Autowired
    public void setIpmDao(IpmDAO ipmDao) {
        this.ipmDao = ipmDao;
    }
    
    private IpmDAO ipmDao = null;
}
