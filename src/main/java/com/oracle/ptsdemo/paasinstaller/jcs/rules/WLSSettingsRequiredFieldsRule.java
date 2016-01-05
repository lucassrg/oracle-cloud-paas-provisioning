/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.jcs.rules;

import com.oracle.ptsdemo.paasinstaller.jcs.WLSSettings;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lgomes
 */
public class WLSSettingsRequiredFieldsRule implements WLSSettingsProvisioningRule {

    @Override
    public void validate(WLSSettings wlsSettings) throws IllegalStateException {
        List<String> invalidFields = new ArrayList<>();
        
        if (wlsSettings.getDbaName() == null) {
            invalidFields.add("dbaName");
        }
        
        if (wlsSettings.getDbaPassword() == null) {
            invalidFields.add("dbaPassword");
        }
        
        if (wlsSettings.getDbServiceName() == null) {
            invalidFields.add("dbServiceName");
        }

        if (wlsSettings.getShape() == null) {
            invalidFields.add("shape");
        }
        
        if (wlsSettings.getType() == null) {
            invalidFields.add("type");
        }
        
        if (wlsSettings.getVersion() == null) {
            invalidFields.add("version");
        }

        if (!invalidFields.isEmpty()) {
            throw new IllegalStateException("Missing WLSSettings required fields: "+invalidFields.toString());
        }
    }
    
}
