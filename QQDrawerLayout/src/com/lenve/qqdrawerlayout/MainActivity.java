package com.lenve.qqdrawerlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends Activity {

	private DrawerLayout drawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().hide();
		initDrawerLayout();
	}

	private void initDrawerLayout() {
		drawerLayout = (DrawerLayout) this.findViewById(R.id.drawerLayout);
		drawerLayout.setDrawerListener(new DrawerListener() {

			// 当我们打开菜单的时候，先执行onDrawerStateChanged，然后不断执行onDrawerSlide，第三步会执行onDrawerOpened，最后执行onDrawerStateChanged
			// 当我们关闭菜单的时候，先执行onDrawerStateChanged，然后不断执行onDrawerSlide，第三步会执行onDrawerClosed，最后执行onDrawerStateChanged
			@Override
			public void onDrawerStateChanged(int newState) {
				Log.i("lenve", "onDrawerStateChanged");
			}

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				slideAnim(drawerView, slideOffset);
				Log.i("lenve", "onDrawerSlide");
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				Log.i("lenve", "onDrawerOpened");
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				Log.i("lenve", "onDrawerClosed");
			}
		});
	}

	private void slideAnim(View drawerView, float slideOffset) {
		View contentView = drawerLayout.getChildAt(0);
		// slideOffset表示菜单项滑出来的比例，打开菜单时取值为0->1,关闭菜单时取值为1->0
		float scale = 1 - slideOffset;
		float rightScale = 0.8f + scale * 0.2f;
		float leftScale = 1 - 0.3f * scale;

		ViewHelper.setScaleX(drawerView, leftScale);
		ViewHelper.setScaleY(drawerView, leftScale);
		ViewHelper.setAlpha(drawerView, 0.6f + 0.4f * (1 - scale));
		ViewHelper.setTranslationX(contentView, drawerView.getMeasuredWidth()
				* (1 - scale));
		ViewHelper.setPivotX(contentView, 0);
		ViewHelper.setPivotY(contentView, contentView.getMeasuredHeight() / 2);
		contentView.invalidate();
		ViewHelper.setScaleX(contentView, rightScale);
		ViewHelper.setScaleY(contentView, rightScale);
	}

	public void onClick(View v) {
		drawerLayout.openDrawer(Gravity.LEFT);
	}
}
