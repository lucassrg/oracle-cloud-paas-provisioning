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
public enum ComputeShape {
    OCTHREE("OC3","1", "2", "7.5"), OCFOUR("OC4", "2", "4", "15"), 
    OCFIVE("OC5", "4", "8", "30"), OCSIX("OC6","8", "16", "60"),
    OCSEVEN("OC7", "16", "32", "120"), OCONEM("OC1M", "1", "2", "15"),
    OCTWOM("OC2M", "2", "4", "30"), OCTHREEM("OC3M", "4", "8", "60"), 
    OCFOURM("OC4M", "8", "16", "120"), OCFIVEM("OC5M", "16", "32", "240");
    
    
    private final String shape;
    private final String ocpu;
    private final String vcpu;
    private final String memoryGB;
    
    private ComputeShape(String shape, String ocpu, String vcpu, String memoryGB) {
        this.shape = shape;
        this.ocpu = ocpu;
        this.vcpu = vcpu;
        this.memoryGB = memoryGB;
    }
    
    
    public String getShape() {
        return shape;
    }

    public String getOcpu() {
        return ocpu;
    }

    public String getVcpu() {
        return vcpu;
    }

    public String getMemoryGB() {
        return memoryGB;
    }
  
    
    
}
