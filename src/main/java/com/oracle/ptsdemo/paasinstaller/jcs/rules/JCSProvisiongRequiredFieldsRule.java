/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.jcs.rules;

import com.oracle.ptsdemo.paasinstaller.JCSService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lgomes
 */
public class JCSProvisiongRequiredFieldsRule implements JCSProvisioningRule {

    /**
     *
     * @param jcsService
     */
    @Override
    public void validate(JCSService jcsService) throws IllegalStateException {
        List<String> invalidFields = new ArrayList<>();
        
        if (jcsService.getStorageContainer() == null) {
            invalidFields.add("cloudStorageContainerData(cloudStorageContainer, cloudStoragePwd, cloudStorageUser)");
        }
        
        //unique parameter is wls server
        if (jcsService.getWlsSetting() == null) {
            invalidFields.add("wlsSettings(parameters)");
        }
        
        if (jcsService.getServiceName() == null) {
            invalidFields.add("serviceName");
        }
        
        if (!invalidFields.isEmpty()) {
            throw new IllegalStateException("Missing JCSService required fields: "+invalidFields.toString());
        }
    }
    
}
