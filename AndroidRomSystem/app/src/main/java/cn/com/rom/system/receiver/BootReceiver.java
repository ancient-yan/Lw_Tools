package cn.com.rom.system.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "rom_system";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "BootReceiver.onReceive");
    }
}
