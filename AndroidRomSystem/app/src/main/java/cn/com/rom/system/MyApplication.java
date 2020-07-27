package cn.com.rom.system;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.util.Log;

import cn.com.rom.system.receiver.dpmReceiver;

public class MyApplication extends Application {
    private static final String TAG = "rom_system";

    @Override
    public void onCreate() {
        super.onCreate();

        ComponentName who = new ComponentName(getApplicationContext(), dpmReceiver.class);
        DevicePolicyManager mDPM = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

        if (!mDPM.isAdminActive(who)) {
            Log.d(TAG, "isAdminActive false!");
            return;
        }

        if (!mDPM.isDeviceOwnerApp(getPackageName())) {
            Log.d(TAG, "isDeviceOwnerApp false!");
            return;
        }
    }
}
