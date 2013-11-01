package com.tdw.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tdw.R;

public class GlideActivity extends AbsSubActivity {
	private ListView listView;
	private GlideAdapter adapter;
	
	private String[] title = {"会员注册", "会员充值", "会员民改密", "结算", "关于我们"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_glide);
		initTitlebar("流水", false);
		
		listView = (ListView)this.findViewById(R.id.listview);
		
		adapter = new GlideAdapter(this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
			}
			
		});
		
	}

	public final class GlideHolder{
		private ImageView iv_icon_left;
		private TextView tv_one;
	}
	
	public class GlideAdapter extends BaseAdapter{
		private LayoutInflater mInflater;
		public GlideAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}
		
		public int getCount(){
			return title.length;
		}
		
		public Object getItem(int arg0){
			return 0;
		}
		
		public long getItemId(int arg0){
			return arg0;
		}
		
		public View getView(int position, View convertView, ViewGroup parent){
			GlideHolder holder = null;
			if (null == convertView){
				holder = new GlideHolder();
				
				convertView = mInflater.inflate(R.layout.list_item_glide, null);
				
				convertView.setTag(holder);
			} else {
				holder = (GlideHolder) convertView.getTag();
			}
			
			return convertView;
		}
	}
	
}
