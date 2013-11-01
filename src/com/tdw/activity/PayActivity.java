package com.tdw.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.tdw.R;

public class PayActivity extends AbsSubActivity {
	private ListView listView;
	private PayAdapter adapter;
	
	private Integer[] imageIds= {R.drawable.main_1_btn, R.drawable.main_2_btn, R.drawable.main_3_btn, R.drawable.main_4_btn};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_pay);
		initTitlebar("支付", false);
		
		listView = (ListView)this.findViewById(R.id.listview);
		
		adapter = new PayAdapter(this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
			}
			
		});
		
	}

	public final class PayHolder{
		public Button itemButton;
	}
	
	public class PayAdapter extends BaseAdapter{
		private LayoutInflater mInflater;
		public PayAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}
		
		public int getCount(){
			return 4;
		}
		
		public Object getItem(int arg0){
			return 0;
		}
		
		public long getItemId(int arg0){
			return arg0;
		}
		
		public View getView(int position, View convertView, ViewGroup parent){
			PayHolder holder = null;
			if (null == convertView){
				holder = new PayHolder();
				
				convertView = mInflater.inflate(R.layout.item_pay, null);
				convertView.setTag(holder);
			} else {
				holder = (PayHolder) convertView.getTag();
			}
			holder.itemButton = (Button) convertView.findViewById(R.id.item_button);
			holder.itemButton.setBackgroundResource(imageIds[position]);
			holder.itemButton.setTag(position);
			holder.itemButton.setOnClickListener(listener);
			return convertView;
		}
	}
	
	private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch ((Integer)v.getTag()) {
			case 0:
				Intent intent0 = new Intent(PayActivity.this, BalanceQueryActivity.class);
				startActivity(intent0);
				break;
			case 1:
				Intent intent1 = new Intent(PayActivity.this, RechargeActivity.class);
				startActivity(intent1);
				break;
			default:
				break;
			}
			
		}
	};
}
