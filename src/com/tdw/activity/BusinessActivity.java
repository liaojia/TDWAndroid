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

public class BusinessActivity extends AbsSubActivity {
	private ListView listView;
	private BusinessAdapter adapter;
	
	private Integer[] icons= {R.drawable.icon_business_0, R.drawable.icon_business_1, R.drawable.icon_business_2, R.drawable.icon_business_3, R.drawable.icon_business_4, R.drawable.icon_business_5, R.drawable.icon_business_6, R.drawable.icon_business_7, R.drawable.icon_business_8};
	private String[] title = {"签到", "商户提现", "银行卡余额查询", "会员卡查询", "帐户查询", "修改商户密码", "完善注册信息", "实名认证", "退出登录"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_business);
		initTitlebar("商户", false);
		
		listView = (ListView)this.findViewById(R.id.listview);
		
		adapter = new BusinessAdapter(this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
			}
			
		});
		
	}

	public final class BusinessHolder{
		private ImageView iv_icon_left;
		private TextView tv_title;
	}
	
	public class BusinessAdapter extends BaseAdapter{
		private LayoutInflater mInflater;
		public BusinessAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}
		
		public int getCount(){
			return title.length;
		}
		
		public Object getItem(int arg0){
			return arg0;
		}
		
		public long getItemId(int arg0){
			return arg0;
		}
		
		public View getView(int position, View convertView, ViewGroup parent){
			BusinessHolder holder = null;
			if (null == convertView){
				holder = new BusinessHolder();
				
				convertView = mInflater.inflate(R.layout.list_item, null);
				convertView.setTag(holder);
			} else {
				holder = (BusinessHolder) convertView.getTag();
			}
			holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			holder.tv_title.setText(title[position]);
			holder.iv_icon_left = (ImageView) convertView.findViewById(R.id.iv_icon_left);
			holder.iv_icon_left.setBackgroundResource(icons[position]);
			return convertView;
		}
	}
	
}
