package cn.com.rom.system.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import cn.com.rom.system.util.SystemInfo;

public class PackageVerifyReceiver extends BroadcastReceiver {
    private static final String TAG = "rom_system";
    private static final String EXTRA_VERIFICATION_PACKAGE_NAME = "android.content.pm.extra.VERIFICATION_PACKAGE_NAME";

    public void onReceive(Context context, Intent intent) {
        final String strAction = intent.getAction();
        if (Intent.ACTION_PACKAGE_NEEDS_VERIFICATION.equals(strAction)) {
            Bundle m_bundleInfo = intent.getExtras();
            if (null == m_bundleInfo) return;

            for (String name : m_bundleInfo.keySet()) {
                Log.d(TAG, name + " : " + m_bundleInfo.get(name));
            }

            int verifiedId = intent.getIntExtra(PackageManager.EXTRA_VERIFICATION_ID, -1);
            String packageName = intent.getStringExtra(EXTRA_VERIFICATION_PACKAGE_NAME);
            String intentData = intent.getDataString();
            Log.d(TAG, "PackageVerifyReceiver packageName : " + packageName);
            Log.d(TAG, "PackageVerifyReceiver verifiedId : " + verifiedId);
            Log.d(TAG, "PackageVerifyReceiver intentData : " + intentData);

            int verificationCode = PackageManager.VERIFICATION_REJECT;

            if (packageName.equals(SystemInfo.CLIENT_DEBUG_PACKAGE_NAME) ||
                    packageName.equals(context.getPackageName())) {
                verificationCode = PackageManager.VERIFICATION_ALLOW;
            }

            PackageManager mPackageManager = context.getPackageManager();
            mPackageManager.verifyPendingInstall(verifiedId, verificationCode);

            Log.d(TAG, "PackageVerifyReceiver.verificationCode : " + verificationCode);
        }
    }
}
