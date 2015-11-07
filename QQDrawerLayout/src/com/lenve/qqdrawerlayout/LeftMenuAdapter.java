package com.lenve.qqdrawerlayout;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LeftMenuAdapter extends BaseAdapter {

	private List<LeftMenu> list;

	public LeftMenuAdapter(List<LeftMenu> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.listview_item, null);
			holder = new ViewHolder();
			holder.iv = (ImageView) convertView.findViewById(R.id.left_iv);
			holder.tv = (TextView) convertView.findViewById(R.id.left_tv);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.iv.setImageResource(list.get(position).getImageView());
		holder.tv.setText(list.get(position).getText());
		return convertView;
	}

	class ViewHolder {
		ImageView iv;
		TextView tv;
	}
}
