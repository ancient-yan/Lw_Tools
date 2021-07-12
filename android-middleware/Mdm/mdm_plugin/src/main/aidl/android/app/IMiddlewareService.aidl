package android.app;

import android.content.ComponentName;
import android.content.ContentValues;

interface IMiddlewareService {
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    /**
    public static final int AIRPLANE = 1;
    public static final int AIRPLANE_ENABLE = 2;
    public static final int BLUETOOTH = 3;
    public static final int BLUETOOTH_ENABLE = 4;

    public static final int GPS = 5;
    public static final int GPS_ENABLE = 6;
    public static final int MOBILE_DATA = 7;
    public static final int MOBILE_DATA_ENABLE = 8;
    public static final int USB_DEBUG = 9;
    public static final int USB_DEBUG_ENABLE = 10;
    public static final int WIFI_ENABLE = 11;
    public static final int WIFI_Display = 12;
    public static final int HOTPORT_ENABLE = 13;
    public static final int HOME_KEY_ENABLE = 14;
    public static final int STATUS_BAR_ENABLE = 15;
    public static final int LW_MODE = 16;

    public static final int CAMERA_ENABLE = 18;
    public static final int RECORD_ENABLE = 19;
    public static final int CALL_RECORD_ENABLE = 20;
    public static final int APN_ENABLE = 21;
    public static final int VPN_ENABLE = 22;
    public static final int USB_SHARE_ENABLE = 23;
    public static final int PROJECT_ENABLE = 24;
    public static final int NFC_ENABLE = 25;
    public static final int RECOVERY_ENABLE = 26;
    public static final int RESET_FACTORY_ENABLE = 27;
    public static final int CLEAR_All_NOTIFY = 28;
    public static final int CLEAR_ONE_NOTIFY = 29;
    public static final int OPEN_NFC_STATE=30;
    public static final int SYS_UNLOCK=31;
    public static final int GET_STATUS_BAR_NOTIFY_LIST=32;
    public static final int RADIO_ENABLE=33;
    public static final int RADIO=34;
    public static final int BLUETOOTH_SHARE_ENABLE = 35;
    public static final int USB_SHARE = 36;
    public static final int LIGHT=37;
    public static final int DefaultSms=38;
    public static final int BLUETOOTH_SHARE = 39;
    public static final int RecoveryOpenClose=40;
    public static final int FlashRom=41;
    */

    int getFunctionState(in ContentValues cv);

    boolean setFunctionState(in ContentValues cv);

    boolean connectWifi(String ssid, int security, String password);

    boolean silentInstallPackage(String apkPath);

    boolean silentUninstallPackage(String packageName);

    boolean endCall();

   int deleteSms(long id);

    boolean forceStopPackage(String packageName);

    boolean setApplicationEnabled(String packageName, String className, boolean enable);

    boolean powerOff();

    boolean reboot();

    int getSubId(int slotId);

    ComponentName getTopActivity();

    void queryApn(in Uri uri, in String[] projection,
                         String selection, in String[] selectionArgs, String sortOrder);

    Uri insertApn(in Uri uri, in ContentValues values);

    int updateApn(in Uri uri, in ContentValues values, String where, in String[] whereArgs);

    int deleteApn(in Uri uri, String where, in String[] whereArgs);

    String connectVpn();

    boolean disconnectVpn(String key);

    boolean deleteApplicationCache(String packageName);

    boolean deleteApplicationData(String packageName);

    boolean recoverySystem(String path);

    boolean formatStorage();

    boolean resetFactory();

    boolean deleteFile(String path);

    boolean copyFile(String srcPath, String destPath);
    void getStatusBarNotificationList();
    void clearSysUnlockPassword();
    boolean setBootAnimationAndAudio(String bootAnimationPath,String bootAudioPath);

    ContentValues getFunctionData(in ContentValues cv1);

    boolean SysRunCmd(String strCmd, out List<String> listResult);
    boolean SysRunCmdWaitFor(String strCmd, out List<String> listResult);
    boolean setFunction(in ContentValues cv, in List<String> listIn, out List<String> listOut);
    boolean getFunction(in ContentValues cv, in List<String> listIn, out List<String> listOut);
}