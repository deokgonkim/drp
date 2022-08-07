package net.dgkim.drp.model;

public class IpAddress {
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    public String getIpAddress() {
        return ipAddress;
    }
    
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
    
    public String getMacAddress() {
        return macAddress;
    }
    
    public void setOrg(String org) {
        this.org = org;
    }
    
    public String getOrg() {
        return org;
    }
    
    public void setManager(String manager) {
        this.manager = manager;
    }
    
    public String getManager() {
        return manager;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    private String id = null;
    private String ipAddress = null;
    private String macAddress = null;
    private String org = null;
    private String manager = null;
    private String owner = null;
    private String description = null;
}
