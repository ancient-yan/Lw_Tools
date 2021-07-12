// GwDeviceApplicationManager.aidl
package com.gwchina.child.mdm;

// Declare any non-default types here with import statements

interface GwDeviceApplicationManager {

    void addPersistentApp(in List<String> packageNames);

    void removePersistentApp(in List<String> packageNames);

    List<String> getPersistentApp();

    void addDisallowedRunningApp(in List<String> packageNames);

    void removeDisallowedRunningApp(in List<String> packageNames);

    List<String> getDisallowedRunningApp();

    void killApplicationProcess(String packageName);

    boolean addInstallPackageBlackList(in List<String> packageNames);

    List<String> getInstallPackageBlackList();

    boolean removeInstallPackageBlackList(in List<String> packageNames) ;

    boolean addIgnoreFrequentRelaunchAppList(in List<String> apps);

    boolean removeIgnoreFrequentRelaunchAppList(in List<String> apps);

    List<String> getIgnoreFrequentRelaunchAppList();

    void setApplicationEnabled(String packageName, boolean enable);

    void setApplicationEnabled2(String packageName, boolean enable, int userId);

    void killApplicationProcessForUser(String packageName, int userId);

    void enableAccessibilityService(String packageName, String className, boolean enable);

    void addSingleApp( String packageName);

    boolean clearSingleApp(String packageName);

    String getSingleApp();

    void setComponentEnabled(in ComponentName componentName, boolean enable);

    void cleanBackgroundProcess();
}
