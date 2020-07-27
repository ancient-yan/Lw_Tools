package cn.com.rom.system.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.com.rom.system.util.dbUtil;
import cn.com.rom.system.util.romUtil;

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
            case 1: {
                dbUtil.addInstallWhiteApp(this, "lw.deviceguard");
            }
            break;

            case 2: {
                boolean bRet = dbUtil.isInstallWhiteApp(this, "lw.deviceguard");
                Log.d(TAG, "bRet : " + bRet);
            }
            break;

            case 3: {
                dbUtil.getInstallWhiteApp(this);
            }
            break;

            case 4: {
                dbUtil.clearInstallWhiteApp(this);
            }
            break;

            case 5: {
                romUtil.install28(this, "/sdcard/a.apk");
            }
            break;

            case 6: {
                romUtil.deletePackage(this, "com.tools.payhelper", null, false);
            }
            break;

            case 11: {
                romUtil.setStatusBarDisabled28(this, true);
            }
            break;

            case 12: {
                romUtil.setStatusBarDisabled28(this, false);
            }
            break;
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
