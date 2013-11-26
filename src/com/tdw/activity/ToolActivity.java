package com.tdw.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.tdw.R;

public class ToolActivity extends AbsSubActivity {
	private ListView listView;
	private ToolAdapter adapter;

	private String[] title = { "会员注册", "会员充值", "会员改密", "版本升级", "关于我们" };
	private int[] icons = { R.drawable.icon_tool_0, R.drawable.icon_tool_1,
			R.drawable.icon_tool_2, R.drawable.icon_tool_3,
			R.drawable.icon_tool_4 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_tool);
		initTitlebar("工具", false);

		listView = (ListView) this.findViewById(R.id.listview);

		adapter = new ToolAdapter(this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch (arg2) {
				case 0:

					break;
				case 1:
					Intent intent1= new Intent(ToolActivity.this, LoyaltyRechargeActivity.class);
					ToolActivity.this.startActivity(intent1);
					break;
				case 2:
					Intent intent2= new Intent(ToolActivity.this, ModifyPwdActivity.class);
					ToolActivity.this.startActivity(intent2);
					break;
				case 3:

					break;
				case 4:

					break;

				default:
					break;
				}

			}

		});

	}

	public final class ToolHolder {
		private ImageView iv_icon_left;
		private TextView tv_title;
	}

	public class ToolAdapter extends BaseAdapter {
		private LayoutInflater mInflater;

		public ToolAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}

		public int getCount() {
			return title.length;
		}

		public Object getItem(int arg0) {
			return 0;
		}

		public long getItemId(int arg0) {
			return arg0;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ToolHolder holder = null;
			if (null == convertView) {
				holder = new ToolHolder();

				convertView = mInflater.inflate(R.layout.list_item, null);

				holder.tv_title = (TextView) convertView
						.findViewById(R.id.tv_title);
				holder.tv_title.setText(title[position]);

				holder.iv_icon_left = (ImageView) convertView
						.findViewById(R.id.iv_icon_left);
				holder.iv_icon_left.setBackgroundResource(icons[position]);
				convertView.setTag(holder);
			} else {
				holder = (ToolHolder) convertView.getTag();
			}

			return convertView;
		}
	}

}
