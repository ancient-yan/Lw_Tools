package com.gwchina.child.mdm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.gwchina.child.mdm.core.glDeviceInterfaceImpl;

public class DeviceService extends Service {
    private final static String TAG = "my_mdm";
    private GwDeviceInterface.Stub mStub;

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, intent.toString());
        if (mStub == null) {
            newBinder();
        }
        Log.i(TAG, "onBind");
        return mStub;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind=" + intent.toString());
        mStub = null;
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        mStub = new glDeviceInterfaceImpl(this);
        Log.i(TAG, "DeviceService onCreate");
    }

    private void newBinder() {
        mStub = new glDeviceInterfaceImpl(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "DeviceService onDestroy");
        super.onDestroy();
    }
}
