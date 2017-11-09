package com.example.buscardzz.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

import com.example.buscardzz.R;
import com.example.buscardzz.tools.AlignTextView;
import com.example.buscardzz.util.SiteMsg_Util;

import java.util.ArrayList;
import java.util.List;


public class leftMyAdapter extends BaseAdapter {
	private List<SiteMsg_Util> list = new ArrayList<SiteMsg_Util>();
	private LayoutInflater inflater;
	private Context context;
	private int index;
	private AlignTextView zdname, zdname1;
	private ImageView img;
	private FrameLayout layout;
	private ImageView dqimg;
	private int isdz;

	public leftMyAdapter(List<SiteMsg_Util> list, Context context, int index, int isdz) {
		this.list = list;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.index = index;
		this.isdz = isdz;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		view = inflater.inflate(R.layout.left_list_item, null);
		zdname = view.findViewById(R.id.left_name);
		zdname1 = view.findViewById(R.id.left_name1);
		img = view.findViewById(R.id.left_stype_img);
		layout = view.findViewById(R.id.left_szdbuju);
		LayoutParams lp;
		lp = (LayoutParams) layout.getLayoutParams();
		lp.height = context.getResources().getDimensionPixelOffset(R.dimen.dp_355) / list.size();
		layout.setLayoutParams(lp);
		zdname.setAlingText(list.get(arg0).getStationName());
		if (list.get(arg0).getStationName() != null) {
			switch (list.get(arg0).getStationName().length()) {
				case 2:
					zdname.setLineSpacing(0, 1);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_25));
					break;
				case 3:
					zdname.setLineSpacing(0, 1);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_25));
					break;
				case 4:
					zdname.setLineSpacing(0, 1);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_25));
					break;
				case 5:
					zdname.setLineSpacing(0, 1);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 6:
					zdname.setLineSpacing(0, 1);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 7:
					zdname.setLineSpacing(0, 1);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 8:
					zdname.setLineSpacing(0, 1);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					zdname.setPadding(0, 0, 0, 22);
					break;
				case 9:
					zdname.setAlingText(list.get(arg0).getStationName().substring(0, 5));
					zdname1.setAlingText(list.get(arg0).getStationName().substring(5, 9));
					zdname1.setVisibility(View.VISIBLE);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_25));
					zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 10:
					zdname.setAlingText(list.get(arg0).getStationName().substring(0, 5));
					zdname1.setAlingText(list.get(arg0).getStationName().substring(5, 10));
					zdname1.setVisibility(View.VISIBLE);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 11:
					zdname.setAlingText(list.get(arg0).getStationName().substring(0, 6));
					zdname1.setAlingText(list.get(arg0).getStationName().substring(6, 11));
					zdname1.setVisibility(View.VISIBLE);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 12:
					zdname.setAlingText(list.get(arg0).getStationName().substring(0, 6));
					zdname1.setAlingText(list.get(arg0).getStationName().substring(6, 12));
					zdname1.setVisibility(View.VISIBLE);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 13:
					zdname.setAlingText(list.get(arg0).getStationName().substring(0, 7));
					zdname1.setAlingText(list.get(arg0).getStationName().substring(7, 13));
					zdname1.setVisibility(View.VISIBLE);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 14:
					zdname.setAlingText(list.get(arg0).getStationName().substring(0, 7));
					zdname1.setAlingText(list.get(arg0).getStationName().substring(7, 14));
					zdname1.setVisibility(View.VISIBLE);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 15:
					zdname.setAlingText(list.get(arg0).getStationName().substring(0, 8));
					zdname1.setAlingText(list.get(arg0).getStationName().substring(8, 15));
					zdname1.setVisibility(View.VISIBLE);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				case 16:
					zdname.setAlingText(list.get(arg0).getStationName().substring(0, 8));
					zdname1.setAlingText(list.get(arg0).getStationName().substring(8, 16));
					zdname1.setVisibility(View.VISIBLE);
					zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
					break;
				default:
					break;
			}
		}
		TextPaint tp = zdname.getPaint();
		tp.setFakeBoldText(true);
		TextPaint tp1 = zdname1.getPaint();
		tp1.setFakeBoldText(true);
		if (arg0 < index) {
			img.setImageResource(R.mipmap.bs_yuan);
			zdname.setTextColor(Color.parseColor("#ffffff"));
			zdname1.setTextColor(Color.parseColor("#ffffff"));
		} else if (arg0 == index) {
			Log.v("MyAdapter", "isdz:"+isdz);
			if (isdz == 1) {
				img.setImageResource(R.mipmap.hs_yuan);
				zdname.setTextColor(Color.parseColor("#ffffff"));
				zdname1.setTextColor(Color.parseColor("#ffffff"));
			} else {
				dqimg = img;
				handler.sendEmptyMessage(0x4141);
				zdname.setTextColor(Color.parseColor("#ffffff"));
				zdname1.setTextColor(Color.parseColor("#ffffff"));
			}
		} else {
			img.setImageResource(R.mipmap.heise_yuan);
			zdname.setTextColor(Color.parseColor("#ffffff"));
			zdname1.setTextColor(Color.parseColor("#ffffff"));
		}
		return view;
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
				case 0x4141:
					dqimg.setImageResource(R.mipmap.hs_yuan);
					handler.sendEmptyMessageDelayed(0x3131, 200);
					break;
				case 0x3131:
					dqimg.setImageResource(R.mipmap.heise_yuan);
					handler.sendEmptyMessageDelayed(0x4141, 200);
					break;
				default:
					break;
			}
		};
	};
}
