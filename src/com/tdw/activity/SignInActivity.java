package com.tdw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.tdw.R;

public class SignInActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_sign_in);
		
		//导航栏信息
		Button btn_back = (Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(listener);
		TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
		tv_title.setText("签到");
		
		Button btn_sign_in = (Button)this.findViewById(R.id.btn_sign_in);
		btn_sign_in.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.btn_back:
				finish();
				
				break;
			case R.id.btn_sign_in:
				Intent intent = new Intent(SignInActivity.this, BalanceResultActivity.class);
				SignInActivity.this.startActivity(intent);
				break;
			default:
				break;
			}
			
		}
	};
}
