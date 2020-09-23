package cn.com.rom.system;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "rom_system";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!MyApplication.mDPM.isAdminActive(MyApplication.who)) {
            Log.i(TAG, "isAdminActive false!");

            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, MyApplication.who);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "");
            startActivity(intent);
        }

        finish();
    }
}
