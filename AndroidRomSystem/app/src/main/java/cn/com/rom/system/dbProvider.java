package cn.com.rom.system;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class dbProvider extends ContentProvider {
    private static final String TAG = "rom_system";

    private static final String DATABASE_NAME = "rom.db";
    private static final int DATABASE_VERSION = 1;
    private static final String sstrTABLE_PACKAGE_INSTALL_CONFIG = "package_config";

    private static final int PACKAGE_CONFIG = 7788;
    private static final int PACKAGE_CONFIG_ITEM = (PACKAGE_CONFIG + 1);
    private static final int PACKAGE_CONFIG_TYPE = (PACKAGE_CONFIG + 2);

    private static final UriMatcher sUriMatcher;
    public static final String AUTHORITY = "cn.com.rom.system.provider";

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(AUTHORITY, "package_config", PACKAGE_CONFIG);
        sUriMatcher.addURI(AUTHORITY, "package_config/*", PACKAGE_CONFIG_ITEM);
        sUriMatcher.addURI(AUTHORITY, "package_type/#", PACKAGE_CONFIG_TYPE);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "dbProvider.DatabaseHelper.onCreate");

            //flag  0 白名单 1 黑名单
            String CREATE_TABLE1 =
                    "CREATE TABLE " + sstrTABLE_PACKAGE_INSTALL_CONFIG +
                            "(package_name STRING NOT NULL, flag INTEGER DEFAULT 0, PRIMARY KEY(package_name) ON CONFLICT REPLACE)";

            try {
                Log.d(TAG, "dbProvider.DatabaseHelper.onCreate.CREATE_TABLE1 : " + CREATE_TABLE1);

                db.execSQL(CREATE_TABLE1);
            } catch (SQLException e) {
                Log.e(TAG, "dbProvider.DatabaseHelper.onCreate : " + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    private DatabaseHelper mOpenHelper;

    @Override
    public boolean onCreate() {
        Log.e(TAG, "dbProvider.onCreate");

        mOpenHelper = new DatabaseHelper(getContext());

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();

        switch (sUriMatcher.match(uri)) {
            case PACKAGE_CONFIG: {
                String strSelect = "select package_name, flag from " + sstrTABLE_PACKAGE_INSTALL_CONFIG;

                Log.d(TAG, "dbProvider.query.strSelect : " + strSelect);
                Cursor cur = db.rawQuery(strSelect, null);
                cur.setNotificationUri(getContext().getContentResolver(), uri);

                return cur;
            }
            case PACKAGE_CONFIG_ITEM: {
                final String strPackageName = uri.getPathSegments().get(1);
                String strSelect = "select package_name, flag from " + sstrTABLE_PACKAGE_INSTALL_CONFIG + " where package_name = '" + strPackageName + "'";

                Log.d(TAG, "dbProvider.query.strSelect : " + strSelect);
                Cursor cur = db.rawQuery(strSelect, null);
                cur.setNotificationUri(getContext().getContentResolver(), uri);

                return cur;
            }

            case PACKAGE_CONFIG_TYPE: {
                final String strFlag = uri.getPathSegments().get(1);
                String strSelect = "select package_name, flag from " + sstrTABLE_PACKAGE_INSTALL_CONFIG + " where flag = '" + strFlag + "'";

                Log.d(TAG, "dbProvider.query.strSelect : " + strSelect);
                Cursor cur = db.rawQuery(strSelect, null);
                cur.setNotificationUri(getContext().getContentResolver(), uri);

                return cur;
            }
        }

        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues cv) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        switch (sUriMatcher.match(uri)) {
            case PACKAGE_CONFIG_ITEM: {
                final String strPackageName = uri.getPathSegments().get(1);
                final String strFlag = cv.getAsString("flag");

                String strInsert = "insert into " + sstrTABLE_PACKAGE_INSTALL_CONFIG + "(package_name, flag) values('" + strPackageName + "', '" + strFlag + "')";
                Log.d(TAG, "dbProvider.insert.strInsert : " + strInsert);
                try {
                    db.execSQL(strInsert);
                } catch (SQLException e) {
                    Log.e(TAG, "dbProvider.insert : " + e);
                    return null;
                }
            }
            break;
        }

        return uri;
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        switch (sUriMatcher.match(uri)) {
            case PACKAGE_CONFIG_TYPE: {
                final String strFlag = uri.getPathSegments().get(1);
                final String strDelete = "delete from " + sstrTABLE_PACKAGE_INSTALL_CONFIG + " where flag = '" + strFlag + "'";
                Log.d(TAG, "dbProvider.delete.strDelete : " + strDelete);

                try {
                    db.execSQL(strDelete);
                } catch (SQLException e) {
                    Log.e(TAG, "dbProvider.delete : " + e);
                    return 1;
                }
            }
            break;
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }
}