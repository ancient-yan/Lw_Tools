package com.gwchina.child.mdm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

public class FilterSoftBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "my_mdm";
    private static final String ACTION_VERIFICATION = "com.txtw.action.package_verification.result";
    private static final String NAME_ALLOW_INSTALL = "isAllowInstall";
    private static final String EXTRA_VERIFICATION_PACKAGE_NAME = "android.content.pm.extra.VERIFICATION_PACKAGE_NAME";
    private static final String EXTRA_APK_PATH = "apk_install_path";

    @Override
    public void onReceive(final Context context, final Intent intent) {
        String strAction = intent.getAction();
        Log.i(TAG, "FilterSoftBroadcastReceiver.onReceive : " + strAction);

        if ("com.txtw.package.verify.receiver".equals(strAction)) {
            final String packageName = intent.getStringExtra(EXTRA_VERIFICATION_PACKAGE_NAME);
            final String ApkPath = intent.getStringExtra(EXTRA_APK_PATH);
            final int nVerifiedId = intent.getIntExtra(PackageManager.EXTRA_VERIFICATION_ID, -1);

            Log.i(TAG, "FilterSoftBroadcastReceiver.packageName ：" + packageName + "; ApkPath : " + ApkPath);

            sendVerifyBroadcast(context, nVerifiedId, true);
        }
    }

    private void sendVerifyBroadcast(Context context, int verifiedId, boolean allow) {
        Intent intent = new Intent(ACTION_VERIFICATION);
        intent.putExtra(PackageManager.EXTRA_VERIFICATION_ID, verifiedId);
        intent.putExtra(NAME_ALLOW_INSTALL, allow);
        context.sendBroadcast(intent);

        Log.i(TAG, "广播回应告知是否允许安装 ：" + verifiedId + " allow : " + allow);
    }
}
