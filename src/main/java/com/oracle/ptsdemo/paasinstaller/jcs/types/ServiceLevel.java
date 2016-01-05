/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.jcs.types;

/**
 *
 * Service level. Valid values include:
 * PAAS- Production-level service. Supports Oracle Java Cloud Service instance creation and monitoring, backup and restoration, patching, and scaling. This is the default. JCS-JaaS
 * BASIC- Development-level service. Supports Oracle Java Cloud Service instance creation and monitoring but does not support backup and restoration, patching, or scaling. JCS-VM
 * 
 * @author lgomes
 */
public enum ServiceLevel {
    PAAS, BASIC;
}
