package cn.com.rom.system;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "rom_system";
    private static final int requestCodeAminActive = 2211;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!MyApplication.mDPM.isAdminActive(MyApplication.who)) {
            Log.i(TAG, "isAdminActive false!");

            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, MyApplication.who);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "");
            startActivityForResult(intent, requestCodeAminActive);
        } else finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == requestCodeAminActive) {
            if (resultCode == Activity.RESULT_OK) {
                Log.i(TAG, "ACTION_ADD_DEVICE_ADMIN done.");
            } else {
                Log.i(TAG, "ACTION_ADD_DEVICE_ADMIN failed.");
            }
            finish();
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
