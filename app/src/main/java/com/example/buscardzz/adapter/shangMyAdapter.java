package com.example.buscardzz.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

import com.example.buscardzz.R;
import com.example.buscardzz.tools.MyTextView;
import com.example.buscardzz.util.SiteMsg_Util;

import java.util.ArrayList;
import java.util.List;


public class shangMyAdapter extends BaseAdapter {
    private List<SiteMsg_Util> list = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;
    private int index;
    private ImageView dqimg;
    private int isdz;
    private boolean isdayu40;

    public shangMyAdapter(List<SiteMsg_Util> list, Context context, int index,
                          int isdz, boolean isdayu40) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.index = index;
        this.isdz = isdz;
        this.isdayu40 = isdayu40;
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

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int arg0, View view, ViewGroup arg2) {
        view = inflater.inflate(R.layout.shanghuangse_item, null);
        MyTextView zdname = view.findViewById(R.id.shhs_name);
        MyTextView zdname1 = view.findViewById(R.id.shhs_name1);
        ImageView img = view.findViewById(R.id.stype_img);
        FrameLayout layout = view.findViewById(R.id.szdbuju);
        LayoutParams lp;
        lp = (LayoutParams) layout.getLayoutParams();
        int dp1=context.getResources().getDimensionPixelOffset(R.dimen.dp_1850);
        int dp2=context.getResources().getDimensionPixelOffset(R.dimen.dp_1360);
        int dp3=context.getResources().getDimensionPixelOffset(R.dimen.dp_30);
        if (isdayu40) {
            lp.width = dp2 / list.size();
        } else {
            lp.width = dp1 / list.size();
        }
        layout.setLayoutParams(lp);
       String mzdname=list.get(arg0).getStationName();
        mzdname=mzdname.replace("(","︵");
        mzdname=mzdname.replace("（","︵");
        mzdname=mzdname.replace("）","︶");
        mzdname=mzdname.replace(")","︶");
        zdname.setText(mzdname);
        if (!isdayu40) {
            LayoutParams lp1;
            lp1 = (LayoutParams) zdname.getLayoutParams();
            lp1.width = dp3;
            zdname.setLayoutParams(lp1);
            zdname1.setLayoutParams(lp1);
            if (mzdname != null) {
                switch (mzdname.length()) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        break;
                    case 7:
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_28));
                        break;
                    case 8:
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_28));
                        break;
                    case 9:
                        zdname.setText(mzdname
                                .substring(0, 5));
                        zdname1.setText(mzdname
                                .substring(5, 9));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        break;
                    case 10:
                        zdname.setText(mzdname
                                .substring(0, 5));
                        zdname1.setText(mzdname
                                .substring(5, 10));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        break;
                    case 11:
                        zdname.setText(mzdname
                                .substring(0, 6));
                        zdname1.setText(mzdname
                                .substring(6, 11));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        break;
                    case 12:
                        zdname.setText(mzdname
                                .substring(0, 6));
                        zdname1.setText(mzdname
                                .substring(6, 12));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        break;
                    case 13:
                        zdname.setText(mzdname
                                .substring(0, 7));
                        zdname1.setText(mzdname
                                .substring(7, 13));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_28));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_30));
                        break;
                    case 14:
                        zdname.setText(mzdname
                                .substring(0, 7));
                        zdname1.setText(mzdname
                                .substring(7, 14));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_28));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_28));
                        break;
                    case 15:
                        zdname.setText(mzdname
                                .substring(0, 8));
                        zdname1.setText(mzdname
                                .substring(8, 15));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_28));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_28));
                        break;
                    case 16:
                        zdname.setText(mzdname
                                .substring(0, 8));
                        zdname1.setText(mzdname
                                .substring(8, 16));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_28));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_28));
                        break;
                    default:
                        break;
                }
            }
        } else {
            if (mzdname != null) {
                switch (mzdname.length()) {
                    case 2:
                    case 3:
                    case 4:
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_25));
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        break;
                    case 9:
                        zdname.setText(mzdname
                                .substring(0, 5));
                        zdname1.setText(mzdname
                                .substring(5, 9));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_25));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        break;
                    case 10:
                        zdname.setText(mzdname
                                .substring(0, 5));
                        zdname1.setText(mzdname
                                .substring(5, 10));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        break;
                    case 11:
                        zdname.setText(mzdname
                                .substring(0, 6));
                        zdname1.setText(mzdname
                                .substring(6, 11));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setLineSpacing(0, 1.42f);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        zdname1.setLineSpacing(0, 1.74f);
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        break;
                    case 12:
                        zdname.setText(mzdname
                                .substring(0, 6));
                        zdname1.setText(mzdname
                                .substring(6, 12));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        break;
                    case 13:
                        zdname.setText(mzdname
                                .substring(0, 7));
                        zdname1.setText(mzdname
                                .substring(7, 13));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        break;
                    case 14:
                        zdname.setText(mzdname
                                .substring(0, 7));
                        zdname1.setText(mzdname
                                .substring(7, 14));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        break;
                    case 15:
                        zdname.setText(mzdname
                                .substring(0, 8));
                        zdname1.setText(mzdname
                                .substring(8, 15));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        break;
                    case 16:
                        zdname.setText(mzdname
                                .substring(0, 8));
                        zdname1.setText(mzdname
                                .substring(8, 16));
                        zdname1.setVisibility(View.VISIBLE);
                        zdname.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        zdname1.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.sp_24));
                        break;
                    default:
                        break;
                }
            }
        }
        if (arg0 < index) {
            img.setImageResource(R.mipmap.bs_yuan);
            zdname.setTextColor(Color.parseColor("#ffffff"));
            zdname1.setTextColor(Color.parseColor("#ffffff"));
        } else if (arg0 == index) {
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

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
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
        }

        ;
    };
}
