package com.gwchina.child.mdm.core.lw;

import android.content.ContentValues;

public class ClientDataParse extends SystemInfo
{
	public static ContentValues testGetFunction(int module)
	{
		ContentValues cv = new ContentValues();
		cv.put(SystemInfo.ModuleKey, Integer.valueOf(module));
		return cv;
	}

	public static ContentValues testPutValues(int module, int state)
	{
		ContentValues cv = new ContentValues();
		cv.put(SystemInfo.ModuleKey, Integer.valueOf(module));
		cv.put(SystemInfo.StateKey, Integer.valueOf(state));
		return cv;
	}

	public static ContentValues testPackage(int module, String packageName)
	{
		ContentValues cv = new ContentValues();
		cv.put(SystemInfo.ModuleKey, Integer.valueOf(module));
		cv.put("packageName", packageName);
		return cv;
	}

	public static ContentValues testPackage(int module, String packageName, int state)
	{
		ContentValues cv = new ContentValues();
		cv.put(SystemInfo.ModuleKey, Integer.valueOf(module));
		cv.put("packageName", packageName);
		cv.put(SystemInfo.StateKey, Integer.valueOf(state));
		return cv;
	}

	public static ContentValues testScreenCap(int module, String fileDir, String fileName)
	{
		ContentValues cv = new ContentValues();
		cv.put(SystemInfo.ModuleKey, Integer.valueOf(module));
		cv.put(SystemInfo.fileDirKey, fileDir);
		cv.put(SystemInfo.fileNameKey, fileName);
		return cv;
	}

	public static ContentValues testComponentName(int module, String packageName, String className) {
		ContentValues cv = new ContentValues();
		cv.put(SystemInfo.ModuleKey, Integer.valueOf(module));
		cv.put(SystemInfo.PackageName, packageName);
		cv.put(SystemInfo.className, className);
		return cv;
	}

	public static ContentValues testPermission(int module, String packageName, String permissionName, boolean granted)
	{
		ContentValues cv = new ContentValues();
		cv.put(SystemInfo.ModuleKey, Integer.valueOf(module));
		cv.put(SystemInfo.PackageName, packageName);
		cv.put(SystemInfo.permissionName, permissionName);
		cv.put(SystemInfo.granted, Boolean.valueOf(granted));
		return cv;
	}

	public static ContentValues testSettings(int module, String NameSpace, String Settingskey, String values) {
		ContentValues cv = new ContentValues();
		cv.put(SystemInfo.ModuleKey, Integer.valueOf(module));
		cv.put(SystemInfo.NameSpace, NameSpace);
		cv.put(SystemInfo.Settingskey, Settingskey);
		cv.put(SystemInfo.values, values);
		return cv;
	}
}
