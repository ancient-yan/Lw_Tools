package cn.com.rom.system.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.com.rom.system.dbProvider;

public class dbUtil {
    private static final String TAG = "rom_system";

    static public void addInstallWhiteApp(Context context, final String strPackageName) {
        Uri uri = Uri.parse("content://" + dbProvider.AUTHORITY + "/package_config/" + strPackageName);
        Log.d(TAG, "uri : " + uri);

        ContentValues values = new ContentValues();
        values.put("flag", 0);
        context.getContentResolver().insert(uri, values);
    }

    static public boolean isInstallWhiteApp(Context context, final String strPackageName) {
        Uri uri = Uri.parse("content://" + dbProvider.AUTHORITY + "/package_config/" + strPackageName);
        Log.d(TAG, "uri : " + uri);

        Cursor curRet = context.getContentResolver().query(uri, null, null, null, null);
        Log.d(TAG, "curRet : " + curRet);

        if (null == curRet) return false;

        if (0 == curRet.getCount()) {
            curRet.close();
            return false;
        }

        curRet.moveToFirst();

        int nFlag = curRet.getInt(curRet.getColumnIndex("flag"));
        Log.d(TAG, "nFlag : " + nFlag);

        curRet.close();
        return (0 == nFlag);
    }

    static public void clearInstallWhiteApp(Context context) {
        Uri uri = Uri.parse("content://" + dbProvider.AUTHORITY + "/package_type/" + "0");
        Log.d(TAG, "uri : " + uri);

        int nRet = context.getContentResolver().delete(uri, null, null);
        Log.d(TAG, "nRet : " + nRet);
    }

    static public List<String> getInstallWhiteApp(Context context) {
        List<String> list = new ArrayList<>();

        Uri uri = Uri.parse("content://" + dbProvider.AUTHORITY + "/package_type/" + "0");
        Log.d(TAG, "uri : " + uri);

        Cursor curRet = context.getContentResolver().query(uri, null, null, null, null);
        Log.d(TAG, "curRet : " + curRet);

        if (null == curRet) return list;

        if (0 == curRet.getCount()) {
            curRet.close();
            return list;
        }

        curRet.moveToFirst();

        do {
            String strPackageName = curRet.getString(curRet.getColumnIndex("package_name"));
            Log.d(TAG, "strPackageName : " + strPackageName);
            list.add(strPackageName);
        } while (curRet.moveToNext());

        curRet.close();
        return list;
    }
}
