package com.tdw.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.tdw.R;
import com.tdw.model.RechargeModel;

public class RechargeNextActivity extends BaseActivity implements OnItemSelectedListener {
	
	private ArrayList<RechargeModel> list = new ArrayList<RechargeModel>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recharge_next);

		//导航栏信息
		Button btn_back = (Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(listener);
		TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
		tv_title.setText("交易订单");
		
		//测试数据
		RechargeModel model1 = new RechargeModel("30", "30");
		RechargeModel model2 = new RechargeModel("50", "50");
		RechargeModel model3 = new RechargeModel("150", "150");
		RechargeModel model4 = new RechargeModel("200", "200");
		list.add(model1);
		list.add(model2);
		list.add(model3);
		list.add(model4);
		
		Button btn_commit = (Button)this.findViewById(R.id.btn_commit);
		btn_commit.setOnClickListener(listener);
		

	}
	
	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_back:
				finish();
				break;
			case R.id.btn_commit:
				
				break;
			default:
				break;
			}
			
			
		}
	};
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
