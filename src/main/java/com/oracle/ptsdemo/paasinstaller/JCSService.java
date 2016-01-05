/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller;

import com.oracle.ptsdemo.paasinstaller.jcs.WLSSettings;
import com.oracle.ptsdemo.paasinstaller.jcs.types.ServiceLevel;
import com.oracle.ptsdemo.paasinstaller.types.BillingFrequency;


/**
 * Instance of a JCS Service, v1.0 based upon Production-level (PaaS/JaaS).
 * @author lgomes
 */
public class JCSService {
    public static class Builder {
        //default values              
        private final ServiceLevel serviceLevel = ServiceLevel.PAAS; //App v1.0 focused on production-level service only .
        private final String implementationVersion = "1.0";
        private final boolean provisionOTD = false; //TODO initial version focused on pure WLS
        private boolean sampleAppDeploymentRequested = true;
        private BillingFrequency subscriptionType = BillingFrequency.Monthly;
        
        private String identityDomain;
        private String serviceName;
        private String description;
        
        private StorageContainer storageContainer;        
        private WLSSettings wlsSetting;
        
        
        public Builder withSampleAppDeployed(boolean sampleAppDeploymentRequested) {
            this.sampleAppDeploymentRequested = sampleAppDeploymentRequested;
            return this;
        }
        
        public Builder withSubscriptionType(BillingFrequency subscriptionType) {
            this.subscriptionType = subscriptionType;
            return this;
        }
        
        public Builder withIdentityDomain(String identityDomain) {
            this.identityDomain = identityDomain;
            return this;
        }
        
        public Builder withServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }
        
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }
        
        public Builder withStorageContainer(StorageContainer storageContainer) {
            this.storageContainer = storageContainer;
            return this;
        }
        
        public Builder withWLSSettings(WLSSettings wlsSettings) {
            this.wlsSetting = wlsSettings;
            return this;
        }
        
        
        public JCSService build() {
            
            
            if (identityDomain == null) {
                throw new IllegalStateException("Cannot Create JCSService. Missing identityDomain");
            }
            
            if (serviceName == null) {
                throw new IllegalStateException("Cannot Create JCSService. Missing serviceName");
            }
            /**
             * create rule to validate oracle cloud storage
             * An Oracle Storage Cloud Service container 
             *  is not required when provisioning an 
             * Oracle Java Cloud Service - Virtual Image instance.
            */
                   
            
            return new JCSService(serviceLevel, implementationVersion, provisionOTD,sampleAppDeploymentRequested, subscriptionType, identityDomain, serviceName, description, storageContainer, wlsSetting);
        }
    }
    
       
        private final ServiceLevel serviceLevel;
        private final String implementationVersion;
        private final boolean provisionOTD;
        private final boolean sampleAppDeploymentRequested;
        private final BillingFrequency subscriptionType;        
        private final String identityDomain;
        private final String serviceName;
        private final String description;      
        private final StorageContainer storageContainer;        
        private final WLSSettings wlsSetting;

    private JCSService(ServiceLevel serviceLevel, String implementationVersion, 
            boolean provisionOTD, boolean sampleAppDeploymentRequested, 
            BillingFrequency subscriptionType, String identityDomain, 
            String serviceName, String description, 
            StorageContainer storageContainer, WLSSettings wlsSetting) {
        
        this.serviceLevel = serviceLevel;
        this.implementationVersion = implementationVersion;
        this.provisionOTD = provisionOTD;
        this.sampleAppDeploymentRequested = sampleAppDeploymentRequested;
        this.subscriptionType = subscriptionType;
        this.identityDomain = identityDomain;
        this.serviceName = serviceName;
        this.description = description;
        this.storageContainer = storageContainer;
        this.wlsSetting = wlsSetting;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public String getImplementationVersion() {
        return implementationVersion;
    }

    public boolean isProvisionOTD() {
        return provisionOTD;
    }

    public boolean isSampleAppDeploymentRequested() {
        return sampleAppDeploymentRequested;
    }

    public BillingFrequency getSubscriptionType() {
        return subscriptionType;
    }

    public String getIdentityDomain() {
        return identityDomain;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDescription() {
        return description;
    }

    public StorageContainer getStorageContainer() {
        return storageContainer;
    }

    public WLSSettings getWlsSetting() {
        return wlsSetting;
    }


    
}
