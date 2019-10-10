package cn.com.rom.system;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.provider.Settings;

import cn.com.rom.system.receiver.dpmReceiver;
import cn.com.rom.system.util.romUtil;

public class MyApplication extends Application {
    public static final String PACKAGE_VERIFIER_DEFAULT_RESPONSE = "verifier_default_response";
    public static final String PACKAGE_VERIFIER_TIMEOUT = "verifier_timeout";

    private DevicePolicyManager mDPM = null;
    public static ComponentName who = null;

    @Override
    public void onCreate() {
        super.onCreate();

        Settings.Global.putInt(getContentResolver(), PACKAGE_VERIFIER_DEFAULT_RESPONSE, PackageManager.VERIFICATION_REJECT);
        Settings.Global.putString(getContentResolver(), PACKAGE_VERIFIER_TIMEOUT, "30000");

        mDPM = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        who = new ComponentName(getApplicationContext(), dpmReceiver.class);

        if (!mDPM.isAdminActive(who)) {
            romUtil.setActiveAdmin(this, who, true);
        }

        if (!mDPM.isProfileOwnerApp(getPackageName())) {
            romUtil.setProfileOwner(this, who);
        }
    }
}
