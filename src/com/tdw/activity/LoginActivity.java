package com.tdw.activity;

import com.tdw.R;
import com.tdw.client.ApplicationEnvironment;
import com.tdw.client.Constant;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class LoginActivity extends BaseActivity {
	private EditText userNameET;
	private EditText pwdET;
	private ImageView rememberIV;
	private Button getPwdButton;
	private Button registerButton;
	private Button loginButton;
	
	private Boolean isRemember;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
//		initTitleBar("登 录", false);
		userNameET = (EditText)this.findViewById(R.id.usernameET);
		pwdET = (EditText)this.findViewById(R.id.pwdET);
		
		rememberIV = (ImageView)this.findViewById(R.id.rememberIV);
		rememberIV.setOnClickListener(listener);
		isRemember = ApplicationEnvironment.getInstance().getPreferences().getBoolean(Constant.kISREMEBER, false);
		setRemeberImageView(isRemember);
		
		getPwdButton = (Button)this.findViewById(R.id.getPwdButton);
		getPwdButton.setOnClickListener(listener);
		
		registerButton = (Button)this.findViewById(R.id.registerButton);
		registerButton.setOnClickListener(listener);
		
		loginButton = (Button)this.findViewById(R.id.loginButton);
		loginButton.setOnClickListener(listener);
	}

	private void setRemeberImageView(Boolean remember){
		if(remember){
			rememberIV.setBackgroundResource(R.drawable.remeberpwd_s);
		}else{
			rememberIV.setBackgroundResource(R.drawable.remeberpwd_n);
		}
	}
	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.rememberIV:
				{
					isRemember = !isRemember;
					setRemeberImageView(isRemember);
					break;
				}
			case R.id.getPwdButton:
				{
					getPwdAction();
					break;
				}
			case R.id.registerButton:
				{
					registerAction();
					break;
				}
			case R.id.loginButton:
				{
					loginAction();
					break;
				}
			}
			
		}

		
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	private Boolean checkValue(){
		
		if(userNameET.length() == 0){
			this.showToast("用户名不能为空！");
			return false;
		}else if(pwdET.length() == 0){
			this.showToast("密码不能为空！");
			return false;
		}
		return true;
	}
	
	private void loginAction(){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		if(checkValue()){
			
			Editor editor = ApplicationEnvironment.getInstance().getPreferences().edit();
			editor.putBoolean(Constant.kISREMEBER, isRemember);
			editor.commit();
		}
	}
	
	private void registerAction(){
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
	}
	
	private void getPwdAction(){
		
	}
}
