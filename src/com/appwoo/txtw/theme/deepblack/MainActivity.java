package com.appwoo.txtw.theme.deepblack;

import java.util.List;

import android.app.Activity;
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

public class MainActivity extends Activity {
	
	private EditText m_editText_Input;
	private Button m_button_Run;
	private final static String TAG = "Lw_Tools";

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
		
		Log.e(TAG, " : " + strCmd);
		
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
	}
}
