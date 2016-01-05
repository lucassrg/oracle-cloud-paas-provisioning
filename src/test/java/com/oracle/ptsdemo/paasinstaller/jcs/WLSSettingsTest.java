/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.jcs;

import com.oracle.ptsdemo.paasinstaller.jcs.types.JCSComponentType;
import com.oracle.ptsdemo.paasinstaller.jcs.types.WLSDomainMode;
import com.oracle.ptsdemo.paasinstaller.jcs.types.WLSEdition;
import com.oracle.ptsdemo.paasinstaller.jcs.types.WLSManagedServerCount;
import com.oracle.ptsdemo.paasinstaller.jcs.types.WLSVersion;
import com.oracle.ptsdemo.paasinstaller.types.ComputeShape;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lgomes
 */
public class WLSSettingsTest {
    
   
    @Test
    public void testMinimumValidWLSSetting() {
        System.out.println("testMinimumValidWLSSetting");
        
                //required fields
        String dbaName = "Lucas";
        String dbaPassword = "Test123";
        String dbServiceName = "DB1";
        ComputeShape shape = ComputeShape.OCFIVE;        
        WLSVersion version = WLSVersion.TWELVEC;
        
        //default values
        JCSComponentType type = JCSComponentType.weblogic;
        String contentPort = "8001";
        WLSDomainMode domainMode = WLSDomainMode.PRODUCTION;
        String deploymentChannelPort = "9001";
        WLSEdition edition = WLSEdition.EE;
        WLSManagedServerCount managedServerCount = WLSManagedServerCount.ONE;
        String nodeManagerPort = "5556";
        String privilegedContentPort = "80"; //0 to disable
        String privilegedSecuredContentPort = "443";
        String secureAdminPort = "7002";
        String securedContentPort = "8002";
        
        WLSSettings.Builder builder = new WLSSettings.Builder();
        
        builder.withDbaName(dbaName)
                .withDbaPassword(dbaPassword)
                .withDbServiceName(dbServiceName)
                .withShape(shape)
                .withVersion(version);
        
        WLSSettings settings = builder.build();
        
        //test required fields
        assertEquals(dbaName, settings.getDbaName());
        assertEquals(dbaPassword, settings.getDbaPassword());
        assertEquals(dbServiceName, settings.getDbServiceName());
        assertEquals(shape, settings.getShape());        
        assertEquals(version, settings.getVersion());
        
        //test default values
        assertEquals(type, settings.getType());
        assertEquals(contentPort, settings.getContentPort());
        assertEquals(domainMode, settings.getDomainMode());
        assertEquals(deploymentChannelPort, settings.getDeploymentChannelPort());
        assertEquals(edition, settings.getEdition());
        assertEquals(managedServerCount, settings.getManagedServerCount());
        assertEquals(nodeManagerPort, settings.getNodeManagerPort());
        assertEquals(privilegedContentPort, settings.getPrivilegedContentPort());
        assertEquals(privilegedSecuredContentPort, settings.getPrivilegedSecuredContentPort());
        assertEquals(secureAdminPort, settings.getSecureAdminPort());
        assertEquals(securedContentPort, settings.getSecuredContentPort());                                
    }
    
    @Test
    public void testFailureDueToMissingRequiredFields() {
        System.out.println("testFailureDueToMissingRequiredFields");
        
        WLSSettings.Builder builder = new WLSSettings.Builder();
                
        try {
        
            builder.build();
            fail("Expecting Exception");
        }
        catch(IllegalStateException ie) {
            assertTrue(ie.getMessage(), ie.getMessage().contains("Missing WLSSettings required fields: [dbaName, dbaPassword, dbServiceName, shape, version]"));
        }        
    }
    
        @Test
    public void testFailureDueToSamePortValue() {
        System.out.println("testFailureDueToSamePortValue");
        
        //required fields
        String dbaName = "Lucas";
        String dbaPassword = "Test123";
        String dbServiceName = "DB1";
        ComputeShape shape = ComputeShape.OCFIVE;        
        WLSVersion version = WLSVersion.TWELVEC;
        
        //default values
        String samePort = "1234";
        
        String adminPort = samePort;
        String contentPort = samePort;
        String securedAdminPort = samePort;
        String securedContentPort = samePort;
        String nodeManagerPort = samePort;
        
        //According to the documentation, no issue related to same port
        String deploymentChannelPort = samePort;                
        String privilegedSecuredContentPort = samePort;
        String privilegedContentPort = samePort;

        
        WLSSettings.Builder builder = new WLSSettings.Builder();
        
        //default values
        builder.withDbaName(dbaName)
                .withDbaPassword(dbaPassword)
                .withDbServiceName(dbServiceName)
                .withShape(shape)
                .withVersion(version);
        
        //set port values
        builder.withAdminPort(adminPort)
                .withContentPort(contentPort)
                .withDeploymentChannelPort(deploymentChannelPort)
                .withNodeManagerPort(nodeManagerPort)
                .withPrivilegedSecuredContentPort(privilegedSecuredContentPort)
                .withSecureAdminPort(securedAdminPort)
                .withSecuredContentPort(securedContentPort)
                .withPrivilegedContentPort(privilegedContentPort)
             ;
                
        try {
        
            builder.build();
            fail("Expecting Exception");
        }
        catch(IllegalStateException ie) {            
            assertTrue(ie.getMessage(), ie.getMessage().contains("Duplicated ports were found on WLS Settings: {contentPort="+samePort+", nodeManagerPort="+samePort+", secureAdminPort="+samePort+", securedContentPort="+samePort+"}"));
        }
        
    }

    
}
