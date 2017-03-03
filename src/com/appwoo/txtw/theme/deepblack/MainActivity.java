package com.appwoo.txtw.theme.deepblack;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText m_editText_Input;
	private Button m_button_Run;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		m_editText_Input = (EditText)findViewById(R.id.editText_Input);
		m_button_Run = (Button)findViewById(R.id.button_Run);
		
		m_button_Run.setOnClickListener(new OnClickListener() {			
			@Override
		    public void onClick(View arg0) {
				m_editText_Input.setText("");    
		    }
		   });
	}
}
