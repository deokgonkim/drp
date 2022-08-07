package net.dgkim.drp.model;

public class User {
    
    public void setDn(String dn) {
        this.dn = dn;
    }
    
    public String getDn() {
        return dn;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    private String dn = null;
    private String displayName = null;
}
