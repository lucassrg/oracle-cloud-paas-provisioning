/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.jcs.types;

/**
 * Software edition for WebLogic Server. Valid values include:
 * SE - Standard edition. See Oracle WebLogic Server Standard Edition.
 * EE - Enterprise Edition. This is the default for both service levels. See Oracle WebLogic Server Enterprise Edition.
 * SUITE - Suite edition. See Oracle WebLogic Suite.
 * When creating an instance that has Oracle Coherence enabled, you must set this value to SUITE.
 * @author lgomes
 */
public enum WLSEdition {
    SE, EE, SUITE
}
