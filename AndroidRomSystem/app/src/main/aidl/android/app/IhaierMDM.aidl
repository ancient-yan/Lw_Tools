package android.app;

interface IhaierMDM
{
    void setAdbDisabled(boolean disabled);

    void addInstallPackageWhiteList(in List<String> packageNames);
    List<String> getInstallPackageWhiteList();

    void installPackage(String packagePath);
    void uninstallPackage(String packageName, boolean keepData);

    boolean SetAppSuspend(in List<String> strPackageNames, boolean bSuspend);

    void setCameraDisabled(boolean bDisable);

    void setStatusBarExpandPanelDisabled(boolean disabled);
    void setHomeButtonDisabled(boolean disabled);
    void setBackButtonDisabled(boolean disabled);
    void setTaskButtonDisabled(boolean disabled);
    void setPowerButtonDisabled(boolean disabled);
    void setVolumeButtonDisabled(boolean disabled);

    void setBluetoothDisabled(boolean bDisable);
    void setSdcardDisabled(boolean bDisable);
    ComponentName getTopActivity();
    void setActiveAdmin(in ComponentName componentName, boolean refreshing);
    void killApplicationProcess(String packageName);
    void captureScreen(String dir, String filename);
}