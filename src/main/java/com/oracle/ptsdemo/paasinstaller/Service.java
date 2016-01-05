/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller;

import java.util.List;

/**
 *
 * @author lgomes
 */
public class Service {
    
    private Service() {
        
    }
    private String identityDomain;
    private List<String> sshPublicKeys; 
    
 
    private enum Status {
        create, delete, control, scale
    }
    
    private enum Shape {
        oc3, oc4, oc5, oc6, oc7, oc1m, oc2m, oc3m, oc4m, oc5m
    }
}
