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
import com.tdw.view.PasswordWithLabelView;

public class SettlementActivity extends BaseActivity {
	private PasswordWithLabelView et_pwd = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_settlement);
		
		//导航栏信息
		Button btn_back = (Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(listener);
		TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
		tv_title.setText("结算");
		
		Button btn_settle = (Button)this.findViewById(R.id.btn_settle);
		btn_settle.setOnClickListener(listener);
		
		et_pwd = (PasswordWithLabelView)this.findViewById(R.id.et_pwd);
		et_pwd.setHintWithLabel("商户密码", "请输入6位商户密码");
	}

	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.btn_back:
				finish();
				
				break;
			case R.id.btn_settle:
				Intent intent = new Intent(SettlementActivity.this, BalanceResultActivity.class);
				SettlementActivity.this.startActivity(intent);
				break;
			default:
				break;
			}
			
		}
	};
}
