/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.jcs.rules;

import com.oracle.ptsdemo.paasinstaller.JCSService;

/**
 *
 * @author lgomes
 */
public interface JCSProvisioningRule {
    void validate(JCSService jcsService) throws IllegalStateException;
}
