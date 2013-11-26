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

public class LoyaltyCardQueryActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_loyalty_card);
		
		//导航栏信息
		Button btn_back = (Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(listener);
		TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
		tv_title.setText("会员卡查询");
		
		Button btn_confirm = (Button)this.findViewById(R.id.btn_confirm);
		btn_confirm.setOnClickListener(listener);
		Button btn_pay = (Button)this.findViewById(R.id.btn_pay);
		btn_pay.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.btn_back:
				finish();
				
				break;
			case R.id.btn_confirm:
				
				break;
			case R.id.btn_pay:
				Intent intent_pay = new Intent(LoyaltyCardQueryActivity.this, SwipCardActivity.class);
				LoyaltyCardQueryActivity.this.startActivity(intent_pay);
				break;
			default:
				break;
			}
			
		}
	};
}
