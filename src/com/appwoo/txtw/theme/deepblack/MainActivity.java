package com.appwoo.txtw.theme.deepblack;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
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
	}
}
