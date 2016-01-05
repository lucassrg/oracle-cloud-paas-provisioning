package com.oracle.ptsdemo.paasinstaller;

/**
 *
 * @author lgomes
 */
public final class Credential {
 
    private final String username;
    private final String password;
    
    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
