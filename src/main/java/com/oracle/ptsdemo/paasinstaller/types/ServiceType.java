/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.types;

/**
 *
 * @author lgomes
 */
public enum ServiceType {
    JAAS("jaas");
    
    private final String serviceType;
    
    private ServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    public String getServiceType() {
        return this.serviceType;
    }
    
}
