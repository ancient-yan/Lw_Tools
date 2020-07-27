package cn.com.rom.system.service;

import android.app.IromMDM;
import android.app.Service;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserManager;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import cn.com.rom.system.receiver.dpmReceiver;

public class romMDMService extends Service {
    private static final String TAG = "rom_system";
    private Binder mBinder = null;

    @Override
    public void onCreate() {
        Log.d(TAG, "romMDMService.onCreate");
        mBinder = new MyBinder();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "romMDMService.onBind");
        return mBinder;
    }

    private class MyBinder extends IromMDM.Stub {
        private MyBinder() {
        }

        public boolean setFunction(ContentValues cv, List<String> listIn, List<String> listOut) throws RemoteException {
            String strCmd = cv.getAsString("strCmd");
            ComponentName who = new ComponentName(getApplicationContext(), dpmReceiver.class);
            DevicePolicyManager mDPM = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

            switch (strCmd) {
                case "setSuspendApp": {
                    boolean bFlag = cv.getAsBoolean("bFlag");

                    listIn.remove(getPackageName());
                    String[] strsRet = mDPM.setPackagesSuspended(who, listIn.toArray(new String[listIn.size()]), bFlag);
                    if (null == strsRet) return false;

                    listOut = Arrays.asList(strsRet);
                    return true;
                }

                case "setHideApp": {
                    boolean bFlag = cv.getAsBoolean("bFlag");

                    listIn.remove(getPackageName());
                    for (String strPackageName : listIn) {
                        mDPM.setApplicationHidden(who, strPackageName, bFlag);
                    }
                    return true;
                }

                case "setUninstallApp": {
                    boolean bFlag = cv.getAsBoolean("bFlag");

                    listIn.remove(getPackageName());
                    for (String strPackageName : listIn) {
                        mDPM.setUninstallBlocked(who, strPackageName, bFlag);
                    }
                    return true;
                }

                case "setAdb": {
                    boolean bFlag = cv.getAsBoolean("bFlag");

                    mDPM.setGlobalSetting(who, "adb_enabled", bFlag ? "1" : "0");

                    return true;
                }

                case "disableStatusBar": {
                    boolean bFlag = cv.getAsBoolean("bFlag");

                    boolean bRet = mDPM.setStatusBarDisabled(who, bFlag);

                    return bRet;
                }

                case "reboot": {
                    mDPM.reboot(who);
                    return true;
                }

                case "disableSetTime": {
                    boolean bFlag = cv.getAsBoolean("bFlag");

                    mDPM.setAutoTimeRequired(who, bFlag);
                    return true;
                }

                case "lockScreen": {
                    mDPM.lockNow();
                    return true;
                }

                case "disableCamera": {
                    boolean bFlag = cv.getAsBoolean("bFlag");

                    mDPM.setCameraDisabled(who, bFlag);
                    return true;
                }

                case "clearOwer": {
                    mDPM.clearDeviceOwnerApp(getPackageName());
                    return true;
                }

                case "clearProfile": {
                    mDPM.clearProfileOwner(who);
                    return true;
                }

                case "setActivity": {
                    String str_action = cv.getAsString("action");
                    String str_category = cv.getAsString("category");

                    String str_pkg = cv.getAsString("pkg");
                    String str_cls = cv.getAsString("cls");

                    IntentFilter filter = new IntentFilter(str_action);
                    filter.addCategory(str_category);
                    ComponentName activity = new ComponentName(str_pkg, str_cls);
                    mDPM.addPersistentPreferredActivity(who, filter, activity);
                    return true;
                }

                case "clearActivity": {
                    String str_pkg = cv.getAsString("pkg");
                    mDPM.clearPackagePersistentPreferredActivities(who, str_pkg);
                    return true;
                }

                case "setPermissionPolicy": {
                    String str_policy = cv.getAsString("policy");
                    int n_policy = mDPM.PERMISSION_POLICY_PROMPT;
                    switch (str_policy) {
                        case "grant":
                            n_policy = mDPM.PERMISSION_POLICY_AUTO_GRANT;
                            break;

                        case "deny":
                            n_policy = mDPM.PERMISSION_POLICY_AUTO_DENY;
                            break;

                        case "prompt":
                            n_policy = mDPM.PERMISSION_POLICY_PROMPT;
                            break;
                    }
                    mDPM.setPermissionPolicy(who, n_policy);
                    return true;
                }

                case "setAppPermission": {
                    String str_packageName = cv.getAsString("packageName");
                    String str_permission = cv.getAsString("permission");
                    String str_grantState = cv.getAsString("grantState");

                    int n_grantState = mDPM.PERMISSION_GRANT_STATE_DEFAULT;
                    switch (str_grantState) {
                        case "grant":
                            n_grantState = mDPM.PERMISSION_GRANT_STATE_GRANTED;
                            break;

                        case "deny":
                            n_grantState = mDPM.PERMISSION_GRANT_STATE_DENIED;
                            break;

                        case "default":
                            n_grantState = mDPM.PERMISSION_GRANT_STATE_DEFAULT;
                            break;
                    }

                    mDPM.setPermissionGrantState(who, str_packageName, str_permission, n_grantState);
                    return true;
                }

                case "setSettings": {
                    String str_namespace = cv.getAsString("namespace");
                    String str_key = cv.getAsString("key");
                    String str_values = cv.getAsString("values");

                    Log.d(TAG,"setSettings : " + str_namespace + " : " + str_key + " : " + str_values);

                    switch (str_namespace) {
                        case "system":
                            mDPM.setSystemSetting(who, str_key, str_values);
                            break;

                        case "global":
                            mDPM.setGlobalSetting(who, str_key, str_values);
                            break;

                        case "secure":
                            mDPM.setSecureSetting(who, str_key, str_values);
                            break;
                    }

                    return true;
                }

                case "setLockApp": {
                    String str_packageName = cv.getAsString("packageName");
                    mDPM.setLockTaskPackages(who, new String[]{str_packageName});
                    return true;
                }

                case "clearLockApp": {
                    mDPM.setLockTaskPackages(who, new String[]{});
                    return true;
                }

                case "disableFactoryReset": {
                    boolean bFlag = cv.getAsBoolean("bFlag");
                    if (bFlag) mDPM.addUserRestriction(who, UserManager.DISALLOW_FACTORY_RESET);
                    else mDPM.clearUserRestriction(who, UserManager.DISALLOW_FACTORY_RESET);
                    return true;
                }

                case "disableNetworkReset": {
                    boolean bFlag = cv.getAsBoolean("bFlag");
                    if (bFlag) mDPM.addUserRestriction(who, UserManager.DISALLOW_NETWORK_RESET);
                    else mDPM.clearUserRestriction(who, UserManager.DISALLOW_NETWORK_RESET);
                    return true;
                }

                case "setScreenInfo": {
                    mDPM.setDeviceOwnerLockScreenInfo(who, cv.getAsString("screenInfo"));
                    return true;
                }

                case "": {
                    return true;
                }
            }

            return false;
        }

        public ContentValues getFunction(ContentValues cv, List<String> listIn, List<String> listOut) throws RemoteException {
            String strCmd = cv.getAsString("strCmd");
            ComponentName who = new ComponentName(getApplicationContext(), dpmReceiver.class);
            DevicePolicyManager mDPM = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

            ContentValues cv_ret = new ContentValues();

            switch (strCmd) {
                case "getSetTime": {
                    cv_ret.put("bFlag", mDPM.getAutoTimeRequired());
                }
                return cv_ret;

                case "getAppPermission": {
                    String str_packageName = cv.getAsString("packageName");
                    String str_permission = cv.getAsString("permission");

                    int grantState = mDPM.getPermissionGrantState(who, str_packageName, str_permission);
                    switch (grantState) {
                        case DevicePolicyManager.PERMISSION_GRANT_STATE_GRANTED:
                            cv_ret.put("grantState", "grant");
                            break;

                        case DevicePolicyManager.PERMISSION_GRANT_STATE_DENIED:
                            cv_ret.put("grantState", "deny");
                            break;

                        case DevicePolicyManager.PERMISSION_GRANT_STATE_DEFAULT:
                            cv_ret.put("grantState", "default");
                            break;
                    }
                }
                return cv_ret;

                case "getScreenInfo": {
                    String strLockScreenInfo = mDPM.getDeviceOwnerLockScreenInfo().toString();
                    cv_ret.put("screenInfo", strLockScreenInfo);
                }
                return cv_ret;

                case "": {
                }
                return cv_ret;
            }

            return cv_ret;
        }
    }
}
