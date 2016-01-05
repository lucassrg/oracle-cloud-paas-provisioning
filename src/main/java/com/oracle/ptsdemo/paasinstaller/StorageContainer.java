/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller;

/**
 *
 * @author lgomes
 */
public class StorageContainer {


    public static class Builder {
        private String contentType = "application/vnd.com.oracle.oracloud.provisioning.Service+json";
        private String identityDomain;
        private String containerName;
        private Credential cloudStorageCredential;
        
        public Builder withIdentityDomain(String identityDomain) {
            this.identityDomain = identityDomain;
            return this;
        }
        
        public Builder withCloudStorageCredential(Credential cloudStorageCredential) {
            this.cloudStorageCredential = cloudStorageCredential;
            return this;
        }
        
        public Builder withContainerName(String containerName) {
            this.containerName = containerName;
            return this;
        }
        
        public Builder withContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }
        
        
        public StorageContainer build() {
            if (identityDomain == null) {
                 throw new IllegalStateException("Cannot create StorageContainer object. Missing identityDomain");
            }
            
            if (containerName == null) {
                 throw new IllegalStateException("Cannot create StorageContainer object. Missing containerName");
            }
            
            if (cloudStorageCredential == null) {
                 throw new IllegalStateException("Cannot create StorageContainer object. Missing credentials");
            } 
            else if (cloudStorageCredential.getUsername() == null) {
                 throw new IllegalStateException("Cannot create StorageContainer object. Missing cloudStorageUser");
            }
            else if (cloudStorageCredential.getPassword()== null) {
                 throw new IllegalStateException("Cannot create StorageContainer object. Missing cloudStoragePwd");
            }
            
            
            return new StorageContainer(identityDomain, containerName, contentType, cloudStorageCredential);
            
        }

    }
    
    private final String identityDomain;
    private final String containerName;
    private final String contenType;
    private final Credential cloudStorageCredential;
    
    
    private StorageContainer(String identityDomain, String containerName, String contentType, Credential cloudStorageCredential) {
     this.identityDomain = identityDomain;
     this.containerName = containerName;
     this.contenType = contentType;
     this.cloudStorageCredential = cloudStorageCredential;
    }    
    

    public String getIdentityDomain() {
        return identityDomain;
    }

    public String getContainerName() {
        return containerName;
    }

    public String getContenType() {
        return contenType;
    }

    public Credential getCredential() {
        return cloudStorageCredential;
    }
    
    
}
