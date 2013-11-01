package com.tdw.activity;

import java.lang.reflect.Method;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.tdw.R;
import com.tdw.view.MyAnimation;

public class MainActivity extends AbsActivityGroup {
	private RelativeLayout level2;
	
	
	private boolean isLevel2Show = true;
	
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			ImageButton ib_home = (ImageButton)this.findViewById(R.id.ib_home);
			ib_home.setOnClickListener(listener);
			level2 = (RelativeLayout) findViewById(R.id.level2);
			
		}

	// 第一个需要实现的方法，直接返回ActivityGroup实现类的layou布局即可
	// 注意该布局一定要有个id为activity_group_container的布局用来放子Activity的布局
	@Override
	protected int getLayoutResourceId() {
		// 横向排列选项卡
		return R.layout.activity_group;
	}

	// 第二个需要实现的方法，返回layout布局下选项卡对应的radioButton的id
	@Override
	protected int[] getImageButtonIds() {
		return new int[] { 
				R.id.payIB,
				R.id.glideIB,
				R.id.businessIB,
				R.id.toolIB};
	}


	// 第五个需要实现的方法，返回每个选项卡对应的第一个子Activity（注意要继承自AbsSubActivity）
	@SuppressWarnings("unchecked")
	@Override
	public Class<? extends Activity>[] getClasses() {
		Class<? extends Activity>[] classes = new Class[] { PayActivity.class,
				GlideActivity.class, BusinessActivity.class, ToolActivity.class};
		return classes;
	}
	
	@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getKeyCode()==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_DOWN){
        	
        	Class<?> subActivityClass = BaseActivity.getTopActivity().getClass();
        	
        	try{
				Method backMethod  = subActivityClass.getMethod("backAction", null);
				backMethod.invoke(BaseActivity.getTopActivity(), null);
				
			} catch(Exception e){
				e.printStackTrace();
			}
        	
        	return true;
        	
        }
        
        return super.dispatchKeyEvent(event);
    }

	
	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.ib_home:
				if(!isLevel2Show){
					//显示2级导航菜单
					MyAnimation.startAnimationIN(level2, 500);
				} else {
					//隐藏2级导航菜单
					MyAnimation.startAnimationOUT(level2, 500, 0);
				}
				isLevel2Show = !isLevel2Show; 
				break;

			default:
				break;
			}
			
		}
	};
}
