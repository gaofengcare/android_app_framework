/**
 * 
 */
package com.fgao.mobile.fly.activity;

import android.app.SearchManager.OnCancelListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author gaofeng
 *
 */
public class TabViewLoader {
	
	public static final int ID_HOME = 1;
	public static final int ID_GPS = 2;
	public static final int ID_TASK = 3;
	public static final int ID_SETTING = 4;

	/**
	 * 
	 */
	public TabViewLoader() {
	}

	static LinearLayout.LayoutParams params = null;
	
	public static View createTab(Context context,TabView tabView,OnClickListener clickListener){
		LinearLayout ly = new LinearLayout(context);
		ly.setOrientation(LinearLayout.VERTICAL);
		params = new LinearLayout.LayoutParams(60,60,1);
		params.topMargin = 2;
		params.leftMargin = 2;
		params.gravity = Gravity.CENTER_HORIZONTAL;
		ly.addView(createImage(tabView.imgId,context),params);
		
		params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,1);
		params.topMargin = 2;
		params.leftMargin = 2;
		params.gravity = Gravity.CENTER_HORIZONTAL;
		ly.addView(textView(tabView.desc,context),params);
		ly.setId(tabView.id);
		ly.setOnClickListener(clickListener);
		return ly;
	}
	
	private static ImageView createImage(int id,Context context){
		ImageView img = new ImageView(context);
		img.setImageResource(id);
		img.setScaleType(ScaleType.FIT_XY);
		return img;
	}
	
	private static TextView textView(String desc, Context context) {
	  TextView text = new TextView(context);	
	  text.setTextSize(18);
	  text.setText(desc);
	  text.setTextColor(Color.WHITE);
	  return text;
	}
	
	public static class TabView {
		public int id;
		public int imgId;
		public Bitmap bitmap;
		public String desc;
		
		public TabView(int id,int imgId,String desc) {
			this.id    = id;
			this.imgId = imgId;
			this.desc  = desc;
		}
	}
	
}
