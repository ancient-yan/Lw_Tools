// GwDevicePackageManager.aidl
package com.gwchina.child.mdm;

import com.gwchina.child.mdm.GwPackageInstallObserver;
import com.gwchina.child.mdm.GwPackageDeleteObserver;
// Declare any non-default types here with import statements

interface GwDevicePackageManager {
//     void installPackage( String packagePath);

     void installPackage( String packagePath,int flag, in GwPackageInstallObserver observer);

//     void uninstallPackage( String packageName, boolean keepData);

     void uninstallPackage( String packageName, int flag,in GwPackageDeleteObserver observer);

     void clearPackageData( String packageName);

     void enableInstallPackage();

     void disableInstallSource(in List<String> whitelist);

     boolean isInstallSourceDisabled();

     List<String> getInstallPackageSourceWhiteList();

     void addInstallPackageWhiteList(in List<String> packageNames);

     void removeInstallPackageWhiteList(in List<String> packageNames);

     List<String> getInstallPackageWhiteList();

     void addDisallowedUninstallPackages(in List<String> packageNames);

     void removeDisallowedUninstallPackages(in List<String> packageNames);

     List<String> getDisallowedUninstallPackageList();

     void addDisabledDeactivateMdmPackages(in List<String> packageNames);

     void removeDisabledDeactivateMdmPackages(in List<String> packageNames);

     List<String> getDisabledDeactivateMdmPackageList();

     String getTopActivity();

     int getApplicationEnabledSetting(String packageName);

     void setApplicationEnabledSetting(String packageName, int newState, int flags);

     int getComponentEnabledSetting(String packageName, String className);

     void setComponentEnabledSetting(String packageName, String className, int newState, int flags);

     void setSysAppList(in Map maps, in Bundle bundle);

     List getSysAppList(in List pkgNames);
}
