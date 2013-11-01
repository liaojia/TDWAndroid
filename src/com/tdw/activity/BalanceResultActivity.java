package com.tdw.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.tdw.R;

public class BalanceResultActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_balance_result);		
		
		//导航栏信息
		Button btn_back = (Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(listener);
		TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
		tv_title.setText("查询结果");
			
	}

	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.btn_back:
				finish();
				
				break;

			default:
				break;
			}
			
		}
	};
}