/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ptsdemo.paasinstaller.jcs;

import com.oracle.ptsdemo.paasinstaller.jcs.rules.WLSSettingsPortRule;
import com.oracle.ptsdemo.paasinstaller.jcs.rules.WLSSettingsProvisioningRule;
import com.oracle.ptsdemo.paasinstaller.jcs.rules.WLSSettingsRequiredFieldsRule;
import com.oracle.ptsdemo.paasinstaller.jcs.types.JCSComponentType;
import com.oracle.ptsdemo.paasinstaller.jcs.types.WLSDomainMode;
import com.oracle.ptsdemo.paasinstaller.jcs.types.WLSEdition;
import com.oracle.ptsdemo.paasinstaller.jcs.types.WLSManagedServerCount;
import com.oracle.ptsdemo.paasinstaller.jcs.types.WLSVersion;
import com.oracle.ptsdemo.paasinstaller.types.ComputeShape;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lgomes
 */
public class WLSSettings {


    public static class Builder {
        
        //default values
        private final JCSComponentType type = JCSComponentType.weblogic;

        private String contentPort = "8001";
        private WLSDomainMode domainMode = WLSDomainMode.PRODUCTION;
        private String deploymentChannelPort = "9001";
        private WLSEdition edition = WLSEdition.EE;
        private WLSManagedServerCount managedServerCount = WLSManagedServerCount.ONE;
        private String nodeManagerPort = "5556";
        private String privilegedContentPort = "80"; //0 to disable
        private String privilegedSecuredContentPort = "443";
        private String secureAdminPort = "7002";
        private String securedContentPort = "8002";
        
        private String adminPort;
        private String adminPassword;
        private String adminUserName;
        private String backupVolumeSizing;
        private String clusterName;
        private String connectString;        
        private String dbaName;
        private String dbaPassword;
        private String dbServiceName;
        private String domainName;
        private String domainVolumeSize;
        private String nodeManagerPassword;
        private String nodeManagerUserName;
        private String pdbName;
        private String vmsPublicKey;
        private String vmsPublicKeyName;
        private ComputeShape shape;
        private WLSVersion version;
        
        
        public Builder withContentPort(String contentPort) {
            this.contentPort = contentPort;
            return this;
        }

        public Builder withDomainMode(WLSDomainMode domainMode) {
            this.domainMode = domainMode;
            return this;
        }

        public Builder withDeploymentChannelPort(String deploymentChannelPort) {
            this.deploymentChannelPort = deploymentChannelPort;
            return this;
        }

        public Builder withEdition(WLSEdition edition) {
            this.edition = edition;
            return this;
        }

        public Builder withManagedServerCount(WLSManagedServerCount managedServerCount) {
            this.managedServerCount = managedServerCount;
            return this;
        }

        public Builder withNodeManagerPort(String nodeManagerPort) {
            this.nodeManagerPort = nodeManagerPort;
            return this;
        }

        public Builder withPrivilegedContentPort(String privilegedContentPort) {
            this.privilegedContentPort = privilegedContentPort;
            return this;
        }

        public Builder withPrivilegedSecuredContentPort(String privilegedSecuredContentPort) {
            this.privilegedSecuredContentPort = privilegedSecuredContentPort;
            return this;
        }

        public Builder withSecureAdminPort(String secureAdminPort) {
            this.secureAdminPort = secureAdminPort;
            return this;
        }

        public Builder withSecuredContentPort(String securedContentPort) {
            this.securedContentPort = securedContentPort;
            return this;
        }

        public Builder withAdminPort(String adminPort) {
            this.adminPort = adminPort;
            return this;
        }

        public Builder withAdminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
            return this;
        }

        public Builder withAdminUserName(String adminUserName) {
            this.adminUserName = adminUserName;
            return this;
        }

        public Builder withBackupVolumeSizing(String backupVolumeSizing) {
            this.backupVolumeSizing = backupVolumeSizing;
            return this;
        }

        public Builder withClusterName(String clusterName) {
            this.clusterName = clusterName;
            return this;
        }

        public Builder withConnectString(String connectString) {
            this.connectString = connectString;
            return this;
        }

        public Builder withDbaName(String dbaName) {
            this.dbaName = dbaName;
            return this;
        }

        public Builder withDbaPassword(String dbaPassword) {
            this.dbaPassword = dbaPassword;
            return this;
        }

        public Builder withDbServiceName(String dbServiceName) {
            this.dbServiceName = dbServiceName;
            return this;
        }

        public Builder withDomainName(String domainName) {
            this.domainName = domainName;
            return this;
        }

        public Builder withDomainVolumeSize(String domainVolumeSize) {
            this.domainVolumeSize = domainVolumeSize;
            return this;
        }

        public Builder withNodeManagerPassword(String nodeManagerPassword) {
            this.nodeManagerPassword = nodeManagerPassword;
            return this;
        }

        public Builder withNodeManagerUserName(String nodeManagerUserName) {
            this.nodeManagerUserName = nodeManagerUserName;
            return this;
        }

        public Builder withPdbName(String pdbName) {
            this.pdbName = pdbName;
            return this;
        }

        public Builder withVmsPublicKey(String vmsPublicKey) {
            this.vmsPublicKey = vmsPublicKey;
            return this;
        }

        public Builder withVmsPublicKeyName(String vmsPublicKeyName) {
            this.vmsPublicKeyName = vmsPublicKeyName;
            return this;
        }
        
        public Builder withShape(ComputeShape shape) {
            this.shape = shape;
            return this;
        }
        
        public Builder withVersion(WLSVersion version) {
            this.version = version;
            return this;
        }
        
        public WLSSettings build() throws IllegalStateException {
                        
            WLSSettings instance =  new WLSSettings(type, contentPort, domainMode, 
                    deploymentChannelPort, edition, managedServerCount, nodeManagerPort, 
                    privilegedContentPort, privilegedSecuredContentPort, secureAdminPort, 
                    securedContentPort, adminPort, adminPassword, adminUserName, 
                    backupVolumeSizing, clusterName, connectString, dbaName, 
                    dbaPassword, dbServiceName, domainName, domainVolumeSize, 
                    nodeManagerPassword, nodeManagerUserName, pdbName, shape, version,
                    vmsPublicKey, vmsPublicKeyName);
            
            //validate instance - strategy pattern
            List<WLSSettingsProvisioningRule> validators = new ArrayList<>();
            validators.add(new WLSSettingsRequiredFieldsRule());
            validators.add(new WLSSettingsPortRule());
            
            for (WLSSettingsProvisioningRule validator : validators) {
                validator.validate(instance);
            }
            return instance;
            
        }
        
        
    }

    
        private final JCSComponentType type;        
        private final String contentPort;
        private final WLSDomainMode domainMode;
        private final String deploymentChannelPort;
        private final WLSEdition edition;
        private final WLSManagedServerCount managedServerCount;
        private final String nodeManagerPort;
        private final String privilegedContentPort;
        private final String privilegedSecuredContentPort;
        private final String secureAdminPort;
        private final String securedContentPort;
        
        private final String adminPort;
        private final String adminPassword;
        private final String adminUserName;
        private final String backupVolumeSizing;
        private final String clusterName;
        private final String connectString;        
        private final String dbaName;
        private final String dbaPassword;
        private final String dbServiceName;
        private final String domainName;
        private final String domainVolumeSize;
        private final String nodeManagerPassword;
        private final String nodeManagerUserName;
        private final String pdbName;
        private final WLSVersion version;
        private final String vmsPublicKey;
        private final String vmsPublicKeyName;
        private final ComputeShape shape;
    
    private WLSSettings(JCSComponentType type, String contentPort, WLSDomainMode domainMode, String deploymentChannelPort, WLSEdition edition, WLSManagedServerCount managedServerCount, String nodeManagerPort, String privilegedContentPort, String privilegedSecuredContentPort, String secureAdminPort, String securedContentPort, String adminPort, String adminPassword, String adminUserName, String backupVolumeSizing, String clusterName, String connectString, String dbaName, String dbaPassword, String dbServiceName, String domainName, String domainVolumeSize, String nodeManagerPassword, String nodeManagerUserName, String pdbName, ComputeShape shape, WLSVersion version, String vmsPublicKey, String vmsPublicKeyName) {
        this.type = type;
        this.contentPort = contentPort;
        this.domainMode = domainMode;
        this.deploymentChannelPort = deploymentChannelPort;
        this.edition = edition;
        this.managedServerCount = managedServerCount;
        this.nodeManagerPort = nodeManagerPort;
        this.privilegedContentPort = privilegedContentPort;
        this.privilegedSecuredContentPort = privilegedSecuredContentPort;
        this.secureAdminPort = secureAdminPort;
        this.securedContentPort = securedContentPort;
        this.adminPort = adminPort;
        this.adminPassword = adminPassword;
        this.adminUserName = adminUserName;
        this.backupVolumeSizing = backupVolumeSizing;
        this.clusterName = clusterName;
        this.connectString = connectString;
        this.dbaName = dbaName;
        this.dbaPassword = dbaPassword;
        this.dbServiceName = dbServiceName;
        this.domainName = domainName;
        this.domainVolumeSize = domainVolumeSize;
        this.nodeManagerPassword = nodeManagerPassword;
        this.nodeManagerUserName = nodeManagerUserName;
        this.pdbName = pdbName;
        this.shape = shape;
        this.version = version;
        this.vmsPublicKey = vmsPublicKey;
        this.vmsPublicKeyName = vmsPublicKeyName;
    }
    
    
    public JCSComponentType getType() {
        return type;
    }

    public String getContentPort() {
        return contentPort;
    }

    public WLSDomainMode getDomainMode() {
        return domainMode;
    }

    public String getDeploymentChannelPort() {
        return deploymentChannelPort;
    }

    public WLSEdition getEdition() {
        return edition;
    }

    public WLSManagedServerCount getManagedServerCount() {
        return managedServerCount;
    }

    public String getNodeManagerPort() {
        return nodeManagerPort;
    }

    public String getPrivilegedContentPort() {
        return privilegedContentPort;
    }

    public String getPrivilegedSecuredContentPort() {
        return privilegedSecuredContentPort;
    }

    public String getSecureAdminPort() {
        return secureAdminPort;
    }

    public String getSecuredContentPort() {
        return securedContentPort;
    }

    public String getAdminPort() {
        return adminPort;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public String getBackupVolumeSizing() {
        return backupVolumeSizing;
    }

    public String getClusterName() {
        return clusterName;
    }

    public String getConnectString() {
        return connectString;
    }

    public String getDbaName() {
        return dbaName;
    }

    public String getDbaPassword() {
        return dbaPassword;
    }

    public String getDbServiceName() {
        return dbServiceName;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getDomainVolumeSize() {
        return domainVolumeSize;
    }

    public String getNodeManagerPassword() {
        return nodeManagerPassword;
    }

    public String getNodeManagerUserName() {
        return nodeManagerUserName;
    }

    public String getPdbName() {
        return pdbName;
    }

    public String getVmsPublicKey() {
        return vmsPublicKey;
    }

    public String getVmsPublicKeyName() {
        return vmsPublicKeyName;
    }

    public ComputeShape getShape() {
        return shape;
    }

    public WLSVersion getVersion() {
        return version;
    }
        
}
