package com.lenve.qqdrawerlayout;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class LeftMenuFragment extends Fragment {

	private List<LeftMenu> list = null;
	private ListView lv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		list = new ArrayList<LeftMenu>();
		list.add(new LeftMenu(R.drawable.svip, "开通会员"));
		list.add(new LeftMenu(R.drawable.qianbao, "QQ钱包"));
		list.add(new LeftMenu(R.drawable.zhuangban, "个性装扮"));
		list.add(new LeftMenu(R.drawable.shoucang, "我的收藏"));
		list.add(new LeftMenu(R.drawable.xiangce, "我的相册"));
		list.add(new LeftMenu(R.drawable.wenjian, "我的文件"));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.left_menu, container, false);
		lv = (ListView) view.findViewById(R.id.left_menu_lv);
		LeftMenuAdapter adapter = new LeftMenuAdapter(list);
		lv.setAdapter(adapter);
		return view;
	}
}
