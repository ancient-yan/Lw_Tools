package com.appwoo.txtw.theme.deepblack;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.provider.Settings;
import android.os.SystemProperties;

@SuppressLint("SdCardPath")
public class MainActivity extends Activity {
	
	private EditText m_editText_Input;
	private Button m_button_Run;
	private final static String TAG = "my_log";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		m_editText_Input = (EditText)findViewById(R.id.editText_Input);
		m_button_Run = (Button)findViewById(R.id.button_Run);
		
		m_button_Run.setOnClickListener(new OnClickListener() {			
			@Override
		    public void onClick(View arg0) {
				OnClick_run();				
		    }
		   });
	}
	
	
	private void OnClick_run()
	{
		if(null == m_editText_Input) return;
		
		String strCmd = m_editText_Input.getText().toString();		
		m_editText_Input.setText("");
		
		if(null == strCmd) return;
		
		Log.e(TAG, " strCmd : " + strCmd);
		
		String[] Vars = strCmd.split(" ");
		
		List lVars = new ArrayList(); 
		
		for(int i =0; i < Vars.length ; i++)
		{
			String strTmp = Vars[i].trim();
			if(!strTmp.isEmpty() )
			{
				lVars.add(strTmp);
				Log.e(TAG, "Vars : [" +  Vars[i] + "]");
			}
		}
		
		if(lVars.size() < 1) return;
		strCmd = (String)lVars.get(0);
		
		Log.e(TAG, " strCmd : " + strCmd);
		
		if(strCmd.equals("1") )
		{
			SystemProperties.set("persist.sys.usbdebugdisablelw", "1");
			Settings.Global.putInt(getContentResolver(), Settings.Global.ADB_ENABLED, 1);			
		}
		else if(strCmd.equals("2") )
		{			
			Settings.Global.putInt(getContentResolver(), Settings.Global.ADB_ENABLED, 0);
			SystemProperties.set("persist.sys.usbdebugdisablelw", "0");
		}
		else if(strCmd.equals("3") )
		{			
			Settings.Global.putInt(getContentResolver(), Settings.Global.PACKAGE_VERIFIER_ENABLE, 0);
		}
		else if(strCmd.equals("4") )
		{			
			if(lVars.size() < 2) return;
			
			String strVar = (String)lVars.get(1);
			
			Log.e(TAG, " strVar : " + strVar);
			
			Uri uri = Uri.parse("content://com.txtw.provider.scan.question");
			ContentValues values = new ContentValues();
			values.put("mark", strVar);
			
			getContentResolver().update(uri, values, " item = 1 ", null);
		}
		else if(strCmd.equals("100") )
		{
			Intent intent = new Intent(Intent.ACTION_MASTER_CLEAR);
			intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);
			intent.putExtra(Intent.EXTRA_REASON, "Lw_Tools_diff");
			sendBroadcast(intent);
		}
		else if(strCmd.equals("1001") )
		{
			PackageManager packageManager = getPackageManager();
	        
	        Intent intent = new Intent(Intent.ACTION_MAIN);  
	        intent.addCategory(Intent.CATEGORY_HOME);  
	        
	        List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(intent,  
	                PackageManager.MATCH_DEFAULT_ONLY);
	        
	        for(ResolveInfo ri : resolveInfo)
	        {  
	            Log.e(TAG, "ri.activityInfo.packageName : " + ri.activityInfo.packageName);  
	        }
		}
		else if(strCmd.equals("1002") )
		{	
			String filename = "screenshot.png";			
			String mSavedPath = "/sdcard/" + filename;

			Log.e(TAG, mSavedPath);
			
			try {
				Runtime.getRuntime().exec("screencap -p " + mSavedPath);     
			}
			catch (Exception e) {  
				e.printStackTrace();
			}

			Log.e(TAG, "screencap -p " + mSavedPath);
		}
		else if(strCmd.equals("1003") )
		{
			final ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
			@SuppressWarnings("deprecation")
			final List<ActivityManager.RecentTaskInfo> recentTasks =
					am.getRecentTasks(20, ActivityManager.RECENT_IGNORE_UNAVAILABLE);
			
			for(ActivityManager.RecentTaskInfo rt:recentTasks ) 
			{
				Log.e(TAG, " : " + rt.persistentId);
				if (am != null) am.removeTask(rt.persistentId);  
			}
		}
		else if(strCmd.equals("1004") )
		{
			PackageManager packageManager = getPackageManager();
	        ComponentName componentName = new ComponentName("com.android.settings", "com.android.settings.Settings");
	        int res = packageManager.getComponentEnabledSetting(componentName);
	        if (res == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT
	                || res == PackageManager.COMPONENT_ENABLED_STATE_ENABLED) {
	            // 隐藏应用图标
	            packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
	                    PackageManager.DONT_KILL_APP);
	        } else {
	            // 显示应用图标
	            packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
	                    PackageManager.DONT_KILL_APP);
	        }
		}
		else if(strCmd.equals("1005") )
		{
			PackageManager packageManager = getPackageManager();
	        ComponentName componentName = new ComponentName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
	        int res = packageManager.getComponentEnabledSetting(componentName);
	        if (res == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT
	                || res == PackageManager.COMPONENT_ENABLED_STATE_ENABLED) {
	            // 隐藏应用图标
	            packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
	                    PackageManager.DONT_KILL_APP);
	        } else {
	            // 显示应用图标
	            packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
	                    PackageManager.DONT_KILL_APP);
	        }
		}
		else if(strCmd.equals("1006") )
		{
			
			int Uid  = getUserId();
			Log.e(TAG, "Uid : " + Uid);
			
			
			File dir = new File("/data/");
			if(dir.exists() ) 
			{
				Log.e(TAG, "exists : " + dir + "   ok");
			}
			else
			{
				Log.e(TAG, "exists : " + dir + "   fail");
			}
			
			if(dir.isDirectory() )
			{
				Log.e(TAG, "isDirectory : " + dir + "   true");
			}
			else
			{
				Log.e(TAG, "isDirectory : " + dir + "   false");
			}
			
			FileUtils.setPermissions("/data/", 0777, 0, 0);
			
			
			File file = new File("/data/yan/a.txt");
			if(file.exists() ) 
			{
				Log.e(TAG, "exists : " + file + "   ok");
			}
			else
			{
				Log.e(TAG, "exists : " + file + "   fail");
			}
			
			if(file.isFile() )
			{
				Log.e(TAG, "isFile : " + file + "   true");
			}
			else
			{
				Log.e(TAG, "isFile : " + file + "   false");
			}
			
			 if (file.delete() )
			 {
				 Log.e(TAG, "del file : " + file + "   ok");
			 }
			 else
			 {
				 Log.e(TAG, "del file : " + file + "   fail");
			 }
		}
		else if(strCmd.equals("1007") )
		{
			String cm = "ps init";
			
			Log.e(TAG, "cm : " + cm);
			
	        String memoryUsage = null;

	        int ch;
	        try {
	            Process p = Runtime.getRuntime().exec(cm);
	            InputStream in = p.getInputStream();
	            StringBuffer sb = new StringBuffer(512);
	            while ((ch = in.read()) != -1) {
	                sb.append((char) ch);
	            }
	            memoryUsage = sb.toString();
	        } catch (IOException e) {
	            Log.v(TAG, e.toString());
	        }
	        String[] poList = memoryUsage.split("\r|\n|\r\n");
	        String memusage = poList[1].concat("\n");
	        
	        Log.e(TAG, "memusage : " + memusage);
		}
		else if(strCmd.equals("1008") )
		{
			{
				//String cm = "reboot";
				//String cm = "mount";
				String cm = "chmod 0777 /data/";
				
				Log.e(TAG, "cm : " + cm);
				
		        String msg = null;
	
		        int ch;
		        try {
		            Process p = Runtime.getRuntime().exec(cm);
		            InputStream in = p.getInputStream();
		            StringBuffer sb = new StringBuffer(1024);
		            
		            while ((ch = in.read()) != -1) {
		                sb.append((char) ch);
		            }
		            msg = sb.toString();
		        } catch (IOException e) {
		            Log.v(TAG, e.toString());
		        }
		        
		        Log.e(TAG, "msg : [" + msg + "]");
			}
		}
	}
}
