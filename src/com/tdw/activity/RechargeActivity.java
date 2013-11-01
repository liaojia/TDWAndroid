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

public class RechargeActivity extends BaseActivity implements OnItemSelectedListener {
	Spinner spinner = null;
	private ArrayAdapter<RechargeModel> adapter;
	private ArrayList<RechargeModel> list = new ArrayList<RechargeModel>();
	private Button linkManBtn = null;
	private EditText phoneNumET = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recharge);

		//导航栏信息
		Button btn_back = (Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(listener);
		TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
		tv_title.setText("充值");
		
		//测试数据
		RechargeModel model1 = new RechargeModel("30", "30");
		RechargeModel model2 = new RechargeModel("50", "50");
		RechargeModel model3 = new RechargeModel("150", "150");
		RechargeModel model4 = new RechargeModel("200", "200");
		list.add(model1);
		list.add(model2);
		list.add(model3);
		list.add(model4);
		
		//
		spinner = (Spinner) findViewById(R.id.Spinner01);
		adapter = new ArrayAdapter<RechargeModel>(this, R.layout.myspinner,
				list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(this);
		
		linkManBtn = (Button)this.findViewById(R.id.linkManIB);
		linkManBtn.setOnClickListener(listener);
		
		phoneNumET = (EditText)this.findViewById(R.id.phoneET);
		Button btn_next = (Button)this.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(listener);
		

	}
	
	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.linkManIB:
				Intent intent0 = new Intent(RechargeActivity.this, ContactsActivity.class);
				startActivityForResult(intent0, 0);
				break;
			case R.id.btn_next:
				Intent intent1 = new Intent(RechargeActivity.this, RechargeNextActivity.class);
				startActivityForResult(intent1, 0);
				break;
			case R.id.btn_back:
				finish();
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
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (null != data){
			Bundle bundle = data.getExtras();
		    String str = bundle.getString("phoneNumber");
		    if(null != str){
		    	phoneNumET.setText(str);
		    }
		}
		
	}
}
