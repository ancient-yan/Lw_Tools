package com.appwoo.txtw.theme.deepblack;

import android.app.Activity;
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
	}
}
