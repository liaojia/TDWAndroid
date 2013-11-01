package com.tdw.activity;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.tdw.R;

/** 继承该类并实现其五个抽象方法即可 */
@SuppressLint("UseSparseArrays")
public abstract class AbsActivityGroup extends ActivityGroup{
	
	/** 源Intent */
	protected Intent fromIntent;
	
	/** 功能模块跳转的目标Intent */
	protected Intent targetIntent = new Intent();
	
//	/** Group的标题控件 */ 
//	protected TextView topBarTitleTextView;
//	
//	/** Group的标题内容 */ 
//	protected String topBarName = "";
	
	// 当前选中的项目的tag
	private int selectedImageButtonId = 0;
	
	/** 用来加载子Activity的布局 */
	private LinearLayout container = null;
	
	/** 选项卡的所有标签 */
	private ImageButton[] imageButtons = null;
	
	/** 选项卡所有标签的ID */
	private int[] imageButtonIds = null;
	
	/** 标签ID对应的初始Activity集合 */
	private Map<Integer,Class<? extends Activity>> classes = new HashMap<Integer,Class<? extends Activity>>();
	
	/**
	 * 在子类中实现的设定布局的方法，Activity的布局的id必须为activity_group_container；
	 * 选项卡的id必须为activity_group_radioGroup
	 */
	protected abstract int getLayoutResourceId();
	
	/** 在子类中需要实现的获取选项卡所有标签的ID的方法 */ 
	protected abstract int[] getImageButtonIds();
	
	
	private Integer[] nomel_ImageIds= {R.drawable.main_icon_1_n, R.drawable.main_icon_2_n, R.drawable.main_icon_3_n, R.drawable.main_icon_4_n};
	private Integer[] select_ImageIds= {R.drawable.main_icon_1_s, R.drawable.main_icon_2_s, R.drawable.main_icon_3_s, R.drawable.main_icon_4_s};
	
	/** 在子类中需要实现的获取选项卡所有标签的图标的方法 */ 
//	protected abstract int[] getImageWithTextViewImageIds();
	
	/** 在子类中需要实现的获取选项卡所有标签ID对应的初始Activity的方法 */ 
	public abstract Class<? extends Activity>[] getClasses();
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());         
        // 获取源Intent
		fromIntent = getIntent();
		// 设定原始数据
        setData();
        // 初始化控件
        initWidgetStatic();
    }
			
	/** 设定数据源的方法 */ 
	protected  void setData(){
		imageButtonIds = getImageButtonIds();
//		imageWithTextViewImageIds = getImageWithTextViewImageIds();
		
		for(int i=0;i<imageButtonIds.length;i++){
			classes.put(imageButtonIds[i], getClasses()[i]);
		}
		
		this.selectedImageButtonId = this.imageButtonIds[fromIntent.getIntExtra("TAG", 0)];
	}
	
	/** 初始化控件 */ 
	protected void initWidgetStatic(){
		container = (LinearLayout) findViewById(R.id.container);
		imageButtons = new ImageButton[imageButtonIds.length];
		for(int i=0;i<imageButtons.length;i++){
			imageButtons[i] = (ImageButton) findViewById(imageButtonIds[i]);
			
			imageButtons[i].setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View view) {
					selectedImageButtonId = view.getId();
					for (int i=0; i<imageButtonIds.length; i++){

					//TODO 
					}
					switch (selectedImageButtonId) {
					case R.id.payIB:
						setButtonBg(0);
						break;
					case R.id.glideIB:
						setButtonBg(1);
						break;
					case R.id.businessIB:
						setButtonBg(2);
						break;
					case R.id.toolIB:
						setButtonBg(3);
						break;
					default:
						break;
					}
					targetIntent.setClass(AbsActivityGroup.this, classes.get(selectedImageButtonId));
					//launchActivity(targetIntent);
					launchNewActivity(targetIntent);
				}
			});
		}

		setButtonBg(0);
		// 初始化加载
		targetIntent.setClass(AbsActivityGroup.this, classes.get(this.selectedImageButtonId));
		launchNewActivity(targetIntent);
	}
	
	private void setButtonBg(int tag){
		for(int i=0; i<4; i++){
			if(i == tag){
				imageButtons[i].setBackgroundResource(select_ImageIds[i]);
			}else{
				imageButtons[i].setBackgroundResource(nomel_ImageIds[i]);
			}
		}
	}
	/** ActivityGroup加载新的子Activity的方法(创建新的) */ 
	public void launchNewActivity(Intent intent) {
		container.removeAllViews();
		@SuppressWarnings("deprecation")
		View view = getLocalActivityManager().startActivity(
				intent.getComponent().getShortClassName() + this.selectedImageButtonId,
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)).getDecorView();
		
		/*
		Animation fadeInAnimation = AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in);
		view.startAnimation(fadeInAnimation);
		*/
		
		container.addView(view);
	}
	
	/** ActivityGroup加载新的子Activity的方法(创建新的) */ 
	@SuppressWarnings("deprecation")
	public void launchNewActivityForResult(AbsSubActivity requestSubActivity,
			Intent intent, int requestCode) {
		intent.putExtra("requestCode", requestCode);
		container.removeAllViews();
		@SuppressWarnings("deprecation")
		View view = getLocalActivityManager().startActivity(
				intent.getComponent().getShortClassName() + this.selectedImageButtonId, 
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)).getDecorView();
		/*
		Animation fadeInAnimation = AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in);
		view.startAnimation(fadeInAnimation);
		**/
		container.addView(view);
		
		((AbsSubActivity)getCurrentActivity()).setRequestSubActivity(requestSubActivity);
	}
	
	/** ActivityGroup加载子Activity的方法(先看有没有，有则加载原来的，否则创建新的) */ 
	public void launchActivity(Intent intent) {
		container.removeAllViews();
		@SuppressWarnings("deprecation")
		View view = getLocalActivityManager().startActivity(
				intent.getComponent().getShortClassName() + this.selectedImageButtonId, 
				intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)).getDecorView();
		
		/*
		Animation fadeOutAnimation = AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out);
		view.startAnimation(fadeOutAnimation);
		
		 **/
		container.addView(view);
	}
	
	
}
