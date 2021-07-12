package android.app;

interface hwMDM
{
    void setUSBDataDisabled(boolean disabled);
    boolean isUSBDataDisabled();

    void setStatusBarExpandPanelDisabled(boolean disabled);
    boolean isStatusBarExpandPanelDisabled();

    void setSafeModeDisabled(boolean disabled);
    boolean isSafeModeDisabled();

    void setAdbDisabled(boolean disabled);
    boolean isAdbDisabled();

    void setUSBOtgDisabled(boolean disabled);
    boolean isUSBOtgDisabled();

    void setGPSDisabled(boolean disabled);
    boolean isGPSDisabled();

    void setTaskButtonDisabled(boolean disabled);
    boolean isTaskButtonDisabled();

    void setHomeButtonDisabled(boolean disabled);
    boolean isHomeButtonDisabled();

    void setBackButtonDisabled(boolean disabled);
    boolean isBackButtonDisabled();

    void shutdownDevice();
    void rebootDevice();

    void turnOnGPS(boolean on);
    boolean isGPSTurnOn();

    void setDefaultLauncher(String packageName, String className);
    void clearDefaultLauncher();

    Bitmap captureScreen();

    void setSysTime(long millis);

    void setSilentActiveAdmin(in ComponentName admin);

    void installPackage(String packagePath);
    void uninstallPackage(String packageName, boolean keepData);

    void addInstallPackageWhiteList(in List<String> packageNames);
    void removeInstallPackageWhiteList(in List<String> packageNames);
    List<String> getInstallPackageWhiteList();

    void addDisallowedUninstallPackages(in List<String> packageNames);
    void removeDisallowedUninstallPackages(in List<String> packageNames);
    List<String> getDisallowedUninstallPackageList();

    void addPersistentApp(in List<String> packageNames);
    void removePersistentApp(in List<String> packageNames);
    List<String> getPersistentApp();

    void addDisallowedRunningApp(in List<String> packageNames);
    void removeDisallowedRunningApp(in List<String> packageNames);
    List<String> getDisallowedRunningApp();

    void killApplicationProcess(String packageName);

    boolean addSingleApp(String packageName);
    boolean clearSingleApp(String packageName);
    String getSingleApp();

    void addNetworkAccessWhitelist(in List<String> addrList);
    void removeNetworkAccessWhitelist(in List<String> addrList);
    List<String> getNetworkAccessWhitelist();

    boolean addNetworkAccessBlackList(in List<String> addDomainList);
    boolean removeNetworkAccessBlackList(in List<String> removeDomainList);
    List<String> getNetworkAccessBlackList();

    boolean setAirplaneModeDisabled(boolean disabled);

    boolean setRestoreFactoryDisabled(boolean disabled);
    boolean isRestoreFactoryDisabled();

    boolean setTimeAndDateSetDisabled(boolean disabled);
    boolean isTimeAndDateSetDisabled();

    boolean setDevelopmentOptionDisabled(boolean disable);
    boolean isDevelopmentOptionDisabled();

    void setWifiDisabled(boolean disabled);
    boolean isWifiDisabled();

    void clearPackageData(String packageName);

    void addDisabledDeactivateMdmPackages(in List<String> packageNames);
    void removeDisabledDeactivateMdmPackages(in List<String> packageNames);
    List<String> getDisabledDeactivateMdmPackageList();

    int setMode(int code, String packageName, int mode);
    int getMode(int code, String packageName);
    boolean systemFixed(String pkgName);

    boolean setSearchIndexDisabled(boolean disabled);
    boolean isSearchIndexDisabled();

    boolean setEnterAppDetailDisabled(boolean disabled);
    boolean isEnterAppDetailDisabled();

    void disableInstallSource(in List<String> whitelist);
    void enableInstallPackage();
    boolean isInstallSourceDisabled();
    List<String> getInstallPackageSourceWhiteList();

    boolean setSystemUpdateDisabled(boolean disabled);
    boolean isSystemUpdateDisabled();

    boolean setPowerDisabled(boolean disabled);
    boolean isPowerDisabled();

    void setCustomSettingsMenu(in List<String> menusToDelete);

    boolean setSuperWhiteListForHwSystemManger(in List<String> list);
    boolean removeSuperWhiteListForHwSystemManger(in List<String> list);
    List<String> getSuperWhiteListForHwSystemManger();

    boolean SysRunCmd(String strCmd, out List<String> listResult);
    boolean SysRunCmdWaitFor(String strCmd, out List<String> listResult);
}