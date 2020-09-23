package cn.com.rom.system;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.util.Log;

import cn.com.rom.system.receiver.dpmReceiver;

public class MyApplication extends Application {
    private static final String TAG = "rom_system";
    public static ComponentName who;
    public static DevicePolicyManager mDPM;

    @Override
    public void onCreate() {
        super.onCreate();

        who = new ComponentName(getApplicationContext(), dpmReceiver.class);
        mDPM = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

        if (!mDPM.isAdminActive(who)) {
            Log.i(TAG, "isAdminActive false!");
            return;
        }

        if (!mDPM.isDeviceOwnerApp(getPackageName())) {
            Log.i(TAG, "isDeviceOwnerApp false!");
            return;
        }
    }
}
