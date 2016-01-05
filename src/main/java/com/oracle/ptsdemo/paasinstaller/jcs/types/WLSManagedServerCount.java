/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.jcs.types;

/**
 *
 * @author lgomes
 */
public enum WLSManagedServerCount {
    ONE("1"), TWO("2"), FOUR("4"), EIGHT("8");
    
    private final String wlsManagedServerCount;
    
    private WLSManagedServerCount(String wlsManagedServerCount) {
        this.wlsManagedServerCount = wlsManagedServerCount;
    }
    
    public String getWlsManagedServerCount() {
        return this.wlsManagedServerCount;
    }
}
