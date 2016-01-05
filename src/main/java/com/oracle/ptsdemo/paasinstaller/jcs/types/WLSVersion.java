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
public enum WLSVersion {
    ELEVENG("10.3.6.0.12"), TWELVEC("12.1.3.0.5");

    private final String wlsReleaseVersion;
    
    private WLSVersion(String wlsReleaseVersion) {
        this.wlsReleaseVersion = wlsReleaseVersion;
    }
    
    public String getWLSReleaseVersion() {
        return this.wlsReleaseVersion;
    }



}
