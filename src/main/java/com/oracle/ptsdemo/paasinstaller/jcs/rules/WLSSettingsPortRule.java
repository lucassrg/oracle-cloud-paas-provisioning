/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.jcs.rules;

import com.oracle.ptsdemo.paasinstaller.jcs.WLSSettings;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author lgomes
 */
public class WLSSettingsPortRule implements WLSSettingsProvisioningRule {

    @Override
    public void validate(WLSSettings wlsSettings) throws IllegalStateException {
        
        Map<String,String> addedPort = new TreeMap<>();
        
        addedPort.put("contentPort", wlsSettings.getContentPort());
        addedPort.put("secureAdminPort", wlsSettings.getSecureAdminPort());
        addedPort.put("securedContentPort", wlsSettings.getSecuredContentPort());
        addedPort.put("nodeManagerPort", wlsSettings.getNodeManagerPort());
        
        Set<String> uniquePortValue = new HashSet<>(addedPort.values());
        
        if (addedPort.size() != uniquePortValue.size()) {
            throw new IllegalStateException("Duplicated ports were found on WLS Settings: "+addedPort.toString());
        }
       
    }
    
}
