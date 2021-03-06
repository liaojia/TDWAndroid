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

public class BusinessManInfoActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_businessman_info);
		
		//导航栏信息
		Button btn_back = (Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(listener);
		TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
		tv_title.setText("商户信息");
		
		Button btn_next = (Button)this.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.btn_back:
				finish();
				
				break;
			case R.id.btn_next:
				Intent intent = new Intent(BusinessManInfoActivity.this, BalanceResultActivity.class);
				BusinessManInfoActivity.this.startActivity(intent);
				break;
			default:
				break;
			}
			
		}
	};
}
