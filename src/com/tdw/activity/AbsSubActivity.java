package com.tdw.activity;

import com.tdw.R;
import com.tdw.view.LKAlertDialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/** 继承该类即可实现子Activity的功能 */
public abstract class AbsSubActivity extends BaseActivity implements OnClickListener{
	
	protected Button btn_back = null;
	protected TextView titleView = null;
		
	private AbsSubActivity requestSubActivity;
	
	protected void initTitlebar(String title, Boolean hasBackBtn) {
		
		btn_back = (Button) this.findViewById(R.id.btn_back);
		if(!hasBackBtn){
			btn_back.setVisibility(View.GONE);
		}
		titleView = (TextView) this.findViewById(R.id.tv_title);
		
		titleView.setText(title);
		
		btn_back.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		switch(view.getId()){
		case R.id.btn_back:
			this.backAction();
			break;
			
		}
	}
	
	public void backAction() {
		this.goback();
	}
	
	
	/**********************************/
	
	public AbsSubActivity getRequestSubActivity() {
		return requestSubActivity;
	}

	public void setRequestSubActivity(AbsSubActivity requestSubActivity) {
		this.requestSubActivity = requestSubActivity;
	}

	private Class<?> getTargetClass(Intent intent){
		Class<?> clazz = null;
		try {
			if(intent.getComponent() != null)
			clazz = Class.forName(intent.getComponent().getClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clazz;
	}
	
	// 重写了startActivity()方法，
	// 这样调用该方法时会根据目标Activity是否是子Activity而调用不同的方法
	@Override
	public void startActivity(Intent intent) {
		if( getTargetClass(intent) != null && AbsSubActivity.class.isAssignableFrom(getTargetClass(intent)) ){
			if(this.getParent() instanceof AbsActivityGroup){
				intent.putExtra("fromSubActivity", getClass().getName());
				((AbsActivityGroup)this.getParent()).launchNewActivity(intent);
			}
		}else{
			super.startActivity(intent);
		}
	}

	// 重写了startActivityForResult()方法，
	// 这样调用该方法时会根据目标Activity是否是子Activity而调用不同的方法
	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		if( getTargetClass(intent) != null && AbsSubActivity.class.isAssignableFrom(getTargetClass(intent)) ){
			if(this.getParent() instanceof AbsActivityGroup){
				intent.putExtra("fromSubActivity", getClass().getName());
				((AbsActivityGroup) this.getParent())
						.launchNewActivityForResult(this, intent, requestCode);
			}
		}else{
			super.startActivityForResult(intent, requestCode);
		}
	}
		
	/** 调用此方法来返回上一个界面 */
	// TODO 跟finish的区别？有销毁吗？
	public void goback() {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(getIntent().getStringExtra("fromSubActivity"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Intent intent = new Intent(this,clazz);
		((AbsActivityGroup)this.getParent()).launchActivity(intent);
		
		BaseActivity.popActivity();
	}
	
	/** 调用此方法来返回上一个界面并返回数据 */
	public void gobackWithResult(int resultCode, Intent data) {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(getIntent().getStringExtra("fromSubActivity"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		data.setClass(this, clazz);
		if( requestSubActivity != null){
			requestSubActivity.onActivityResult(
					data.getIntExtra("requestCode", 0), resultCode, data);
		}
		((AbsActivityGroup)this.getParent()).launchActivity(data);	
		
		BaseActivity.popActivity();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK){
			this.setResult(Activity.RESULT_OK);
			this.gobackWithResult(resultCode, data);
		}
	}

}
