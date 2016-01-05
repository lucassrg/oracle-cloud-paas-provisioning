/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller;

import com.oracle.ptsdemo.paasinstaller.jcs.WLSSettings;
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
public class JCSServiceTest {
    
    public JCSServiceTest() {
    }
    
    private StorageContainer createStorageContainer() {
        
        StorageContainer.Builder builder = new StorageContainer.Builder();
        builder.withIdentityDomain("identityDomain");
        
        return builder.build();
        
    }
    
    private WLSSettings createWLSSettings() {
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
        
        return builder.build();
    }
    

    @Test
    public void testMinimumValidJCSService() {
        System.out.println("testMinimumValidJCSService");
    }
    
    
   
}
