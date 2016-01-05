/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller;

/**
 *
 * @author lgomes
 */
public interface OraclePaaSService {
 
    void createService(String endpoint, String identiyDomain);
    
}
