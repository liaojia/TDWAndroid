package com.tdw.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tdw.R;

public class RegisterActivity  extends BaseActivity {
	private Button backBtn;
	private Button nextBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		backBtn = (Button) this.findViewById(R.id.backButton);
		backBtn.setOnClickListener(listener);
		nextBtn = (Button) this.findViewById(R.id.next_btn);
		backBtn.setOnClickListener(listener);
	}
	
	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.backButton:
				finish();
				break;
			case R.id.next_btn:
				
				break;
			default:
				break;
			}
			
		}
	};
}
