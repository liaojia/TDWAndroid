package com.tdw.activity;

import java.util.ArrayList;

import com.tdw.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("CommitPrefEdits")
public class CounterActivity extends BaseActivity {
	private Button backBtn;
	private LinearLayout displayPadLayout;
	private String inputString = "0.00";
	private Integer[] imageIds = { R.drawable.num_0,
			R.drawable.num_1, R.drawable.num_2,
			R.drawable.num_3, R.drawable.num_4,
			R.drawable.num_5, R.drawable.num_6,
			R.drawable.num_7, R.drawable.num_8, 
			R.drawable.num_9, R.drawable.num_c,
			R.drawable.num_c};
	
	private GridView gridView = null;
	private CounterAdapter adapter = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		
//		initTitlebar("输入金额", true);
		gridView = (GridView) findViewById(R.id.gridveiw);
		gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		gridView.setOnItemClickListener(onclickcistener);

		adapter = new CounterAdapter(this);
		gridView.setAdapter(adapter);
		
		displayPadLayout = (LinearLayout) this.findViewById(R.id.displayPadLayout);
		backBtn = (Button)this.findViewById(R.id.btn_back);
		backBtn.setOnClickListener(listener);
		
		this.refreshDisplayPad(inputString);

	}
	
	@Override  
    protected void onStart() {
		super.onStart();
	}
	
	 @Override
	protected void onPause() {
		super.onPause();
		
	}


	// 点击事件
	private OnItemClickListener onclickcistener = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
			Log.i("---", arg2+"");
		}

	};
	

	
	public final class CounterHolder{
		public Button numBtn;
		public TextView numTV;
	}

	public class CounterAdapter extends BaseAdapter {
		
		private LayoutInflater mInflater;
		
		public CounterAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}
		
		public int getCount(){
			return imageIds.length;
		}
		
		public Object getItem(int arg0){
			return arg0;
		}
		
		public long getItemId(int arg0){
			return arg0;
		}
		
		public View getView(int position, View convertView, ViewGroup parent){
			CounterHolder holder = null;
			
			if (null == convertView){
				convertView = this.mInflater.inflate(R.layout.item_counter, null);
				holder = new CounterHolder();
				
				holder.numTV = (TextView) convertView.findViewById(R.id.numTV);
				holder.numBtn = (Button) convertView.findViewById(R.id.counterCellBtn);
				holder.numBtn.setTag(position);
				holder.numBtn.setOnClickListener(listener);
				convertView.setTag(holder);
			} else {
				holder = (CounterHolder) convertView.getTag(); 
			}
			String tmpStr = position + "";
			if(position == 10){
				tmpStr = ".";
			}else if(position == 11){
				tmpStr = "C";
			}
			holder.numTV.setText(tmpStr);
			TextPaint tp = holder.numTV.getPaint();
			tp.setFakeBoldText(true);
			return convertView;
		}
	}

	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v.getId() == R.id.btn_back){
				finish();
			}else{
				int tag = (Integer)v.getTag();
				switch(tag){
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					if (inputString.length() > 10)
						return;
					pressNumericButton(tag);
					break;
				case 10://dot
					
					break;
				case 11://删除
					if ("0.00".equals(inputString))
						return;
					
					pressDeleteButton(11);
					break;
					
				}
			}
			
		}
	};
	private void pressNumericButton(int tag){
		inputString = this.formatString(inputString, tag);
		this.refreshDisplayPad(inputString);
	}
	
	private void pressDeleteButton(int tag){
		inputString = this.formatString(inputString, tag);
		this.refreshDisplayPad(inputString);
	}
	private void pressClearButton(){
		inputString = "0.00";
		this.refreshDisplayPad(inputString);
	}
	
	private void refreshDisplayPad(String money){
		displayPadLayout.removeAllViews();
		
		for (int i=0; i<money.length(); i++){
			displayPadLayout.addView(this.getDigitMoneyImage(money.charAt(i)));
		}
	}
	/**
	 * 
	 * @param srcStr 原字符串
	 * @param tag 代表一种操作。如果是0-9表示输入，如果是11表示删除一个字符
	 * @return 返回新的字符串
	 */
	private String formatString(String srcStr, int tag){
		 double temp = Double.parseDouble(srcStr);
		 double des = 0.00;
		if (tag == 11){ // 删除一位
			 des = temp / 10;// -0.005防止四舍五入
		} else {
			des = temp * 10 + 0.01 * tag;
		}
		// 一个奇怪的问题，0.005->0.00   ,  0.055->0.06
		// return String.format("%.2f", des);
		// SO  des = temp * 10 + 0.01 * tag - 0.005;  不再减0.005
		
		String str = String.format("%.3f",des);
		return str.substring(0, str.length()-1);
	}
	
	private ImageView getDigitMoneyImage(char c){
		int resourceId = this.getResources().getIdentifier("digit_green_"+(c == '.'?"dot":c), "drawable", this.getPackageName());
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), resourceId); 
		
		// http://blog.csdn.net/hustspy1990/article/details/6676303
		float scaleWidth = 0.7f;
		float scaleHeight = 0.7f;
		
		int bmpWidth = bmp.getWidth();
		int bmpHeight = bmp.getHeight();
		
		//产生ReSize之后的bmp对象
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap resizeBmp = Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeight, matrix, true);
		
		ImageView imageView = new ImageView(this);
		imageView.setImageBitmap(resizeBmp);
		
		return imageView;
	}
}
