package com.tdw.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.tdw.R;
import com.tdw.util.PhoneUtil;
import com.tdw.util.StringUtil;

public class SignBillActivity extends BaseActivity {
	
	private String signImageName = "";
	private String imei = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_sign_bill);
		
		//导航栏信息
		Button btn_back = (Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(listener);
		TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
		tv_title.setText("签购单");
		
		//刷卡
		Button btn_confirm = (Button)this.findViewById(R.id.btn_confirm);
		btn_confirm.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.btn_back:
				finish();
				
				break;
			case R.id.btn_confirm:
				gotoHandSignActivity();
				break;
			default:
				break;
			}
			
		}
	};
	
	private void gotoHandSignActivity(){
		Intent intent = new Intent(this, HandSignActivity.class);
//		intent.putExtra("amount", StringUtil.String2SymbolAmount(fieldsMap.get("field4")));
		intent.putExtra("amount", "0000");
		intent.putExtra("tracenum", "0000");
		// 先将图片的名称暂定为日期13+流水号11
//		signImageName = fieldsMap.get("field13")+fieldsMap.get("field11");
		signImageName = "sign_image_name";
		intent.putExtra("signImageName", signImageName);
		intent.putExtra("MD5", getMD5Value());
		this.startActivityForResult(intent, 1);
	}
	
	private String getMD5Value(){
//    	String indexNo = fieldsMap.get("field37");// 银联返回的检索参考号（12位）
		String indexNo = "001";// 银联返回的检索参考号（12位）
    	
    	// 时间戳（14位）
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
    	String timeStamp = sdf.format(new Date());
    	
    	// 手机IMEI（15位）
    	imei = PhoneUtil.getIMEI();
    	
    	StringBuffer temp = new StringBuffer();
    	temp.append(indexNo).append(timeStamp).append(imei);
    	return StringUtil.MD5Crypto(temp.toString());
    }
}
