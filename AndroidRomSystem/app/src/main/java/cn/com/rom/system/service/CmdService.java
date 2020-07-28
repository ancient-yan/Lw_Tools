package cn.com.rom.system.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CmdService extends Service {
    private static final String TAG = "rom_system";

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "CmdService.onStartCommand");

        int nCmd = intent.getIntExtra("cmd", -1);
        Log.d(TAG, "CmdService.onStartCommand.nCmd : " + nCmd);

        switch (nCmd) {
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
