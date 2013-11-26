package com.tdw.activity;

import android.content.Context;
import android.content.Intent;
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
	
	private Integer[] icons= {R.drawable.icon_business_0, R.drawable.icon_business_1, R.drawable.icon_business_2, 
			R.drawable.icon_business_3, R.drawable.icon_business_4, R.drawable.icon_business_5,
			R.drawable.icon_business_6, R.drawable.icon_business_7, R.drawable.icon_business_8,
			R.drawable.icon_business_8, R.drawable.icon_business_8};
	private String[] title = {"签到", "结算", "签退", "商户信息", "帐户查询", "商户提现", "银行卡余额查询", 
			"会员卡查询", "修改商户密码", "完善注册信息", "实名认证"};
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
				switch (arg2) {
				case 0://签到
					Intent intent0 = new Intent(BusinessActivity.this, SignInActivity.class);
					BusinessActivity.this.startActivity(intent0);
					break;
				case 1://结算
					Intent intent1 = new Intent(BusinessActivity.this, SettlementActivity.class);
					BusinessActivity.this.startActivity(intent1);
					break;
				case 2://签退
					
					break;
				case 3://商户信息
					Intent intent3 = new Intent(BusinessActivity.this, BusinessManInfoActivity.class);
					BusinessActivity.this.startActivity(intent3);
				case 4://帐户查询
					
					break;
				case 5://商户提现
					
					break;
				case 6://银行卡余额查询
					Intent intent6 = new Intent(BusinessActivity.this, BalanceQueryActivity.class);
					BusinessActivity.this.startActivity(intent6);
					break;
				case 7://会员卡查询
					Intent intent7 = new Intent(BusinessActivity.this, LoyaltyCardQueryActivity.class);
					BusinessActivity.this.startActivity(intent7);
					break;
				case 8://修改商户密码
					Intent intent8 = new Intent(BusinessActivity.this, ModifyPwdActivity.class);
					BusinessActivity.this.startActivity(intent8);
					break;
				case 9://完善注册信息
					
					break;
				case 10://实名认证
					
					break;
				default:
					break;
				}
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
