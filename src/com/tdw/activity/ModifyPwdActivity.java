package com.tdw.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.tdw.R;
import com.tdw.view.PasswordWithLabelView;

public class ModifyPwdActivity extends BaseActivity {
	private PasswordWithLabelView et_old_pwd;
	private PasswordWithLabelView et_new_pwd;
	private PasswordWithLabelView et_again_pwd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_modify_pwd);
		
		//导航栏信息
		Button btn_back = (Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(listener);
		TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
		tv_title.setText("修改密码");
		
		Button btn_confirm = (Button)this.findViewById(R.id.btn_confirm);
		btn_confirm.setOnClickListener(listener);
		
		et_old_pwd = (PasswordWithLabelView)this.findViewById(R.id.et_old_pwd);
		et_old_pwd.setHintWithLabel("原密码", "请输入原密码");
		et_new_pwd = (PasswordWithLabelView)this.findViewById(R.id.et_new_pwd);
		et_new_pwd.setHintWithLabel("新密码", "请输入新密码");
		et_again_pwd = (PasswordWithLabelView)this.findViewById(R.id.et_again_pwd);
		et_again_pwd.setHintWithLabel("确认密码", "请再次输入密码");
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
			default:
				break;
			}
			
		}
	};
}
