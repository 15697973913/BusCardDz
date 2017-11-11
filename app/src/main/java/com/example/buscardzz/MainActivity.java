package com.example.buscardzz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.buscardzz.adapter.leftMyAdapter;
import com.example.buscardzz.adapter.rightMyAdapter;
import com.example.buscardzz.adapter.shangMyAdapter;
import com.example.buscardzz.application.MyApplication;
import com.example.buscardzz.server.SerialPortService;
import com.example.buscardzz.tools.CopyFile;
import com.example.buscardzz.tools.GetLineMsg;
import com.example.buscardzz.tools.HorizontalListView;
import com.example.buscardzz.util.SiteMsg_Util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.buscardzz.R.id.LineWord;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    @SuppressLint("StaticFieldLeak")
    public static Context context;
    @BindView(LineWord)
    TextView mLineWord;
    @BindView(R.id.isdaozhan)
    TextView mIsdaozhan;
    @BindView(R.id.dzname)
    TextView mDzname;
    @BindView(R.id.list)
    HorizontalListView mList;
    @BindView(R.id.list_left)
    ListView mListLeft;
    @BindView(R.id.list_right)
    ListView mListRight;
    // 系统根路径
    public static String RootPath = Environment.getExternalStorageDirectory().toString();
    // 总路径
    public static String ZongFilePath = RootPath + File.separator + "Advert";
    // 配置文件路径
    public static String ConfigureFilePath = RootPath + File.separator + "Advert" + File.separator + "ConfigureFile" + File.separator;
    /**
     * Log文件路径
     */
    public static String LogFilePath=RootPath + File.separator + "Advert" + File.separator + "Log" + File.separator;
    public static File fwyyfile = new File(ConfigureFilePath + "fwyy.txt");
    public boolean ishavemsg = true;
    public int ishave = 0;
    public SharedPreferences sha;
    public boolean isOneStart = false;
    @BindView(R.id.moneymsg)
    LinearLayout mMoneymsg;
    @BindView(R.id.blankpart)
    LinearLayout mBlankpart;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);// 隐藏状态栏
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
        init();
    }

    public void copyfile() {
        CopyFile.CopyAssetsFile("fwyy.txt", ConfigureFilePath);
        GetLineMsg.readfwyyMsgToSqlite();
        CopyFile.CopyAssetsFile("stationline.ini", ConfigureFilePath);
        GetLineMsg.readLineMsgToSqlite();
        CopyFile.CopyAssetsFile("stationlines.ini", ConfigureFilePath);
        GetLineMsg.readsxLineMsgToSqlite();
        CopyFile.CopyAssetsFile("stationlinex.ini", ConfigureFilePath);
        GetLineMsg.readxxLineMsgToSqlite();

    }

    // 设置站点信息

    /**
     * @param i 判断要设置哪个信息1 ：线路信息 2：上行 3：下行 4:全部
     */
    public void getLineMsg(final int i) {
        new Thread() {
            public void run() {
                // 判断文件是否存在
                switch (i) {
                    case 1:
                        GetLineMsg.getline();
                        break;
                    case 2:
                        GetLineMsg.getsxsite();
                        break;
                    case 3:
                        GetLineMsg.getxxsite();
                        break;
                    case 4:
                        GetLineMsg.getline();
                        GetLineMsg.getsxsite();
                        GetLineMsg.getxxsite();
                        break;
                    default:
                        break;
                }
                // 设置listview
                handler.sendEmptyMessage(0x2153);
            }

        }.start();
    }

    /**
     * @param index 到站的序号
     * @param list  设置上下行的list
     * @param isdlz 是到站还是离站
     */
    public void setDrawin(int index, List<SiteMsg_Util> list, int isdlz) {
        if (list.size() <= 1) {
            return;
        }
        index--;
        Log.v(TAG, "到站序号：" + index);
        Log.v(TAG, "isdlz:" + isdlz);
        mIsdaozhan.setText(isdlz == 1 ? "到站：" : "下一站：");
        mDzname.setText(list.get(index).getStationName());
        int a;
        int leftindex = 0;
        int centreindex = 0;
        int rightindex = 0;
        boolean isdayu40;
        if (list.size() < 40) {
            isdayu40 = false;
            MyApplication.left_listview = new ArrayList<>();
            MyApplication.right_listview = new ArrayList<>();
            MyApplication.centre_listview = new ArrayList<>();
            MyApplication.centre_listview = list;
            centreindex = index;
            a = 40;
        } else {
            setlistnum(list);
            isdayu40 = true;
            a = getResources().getDimensionPixelOffset(R.dimen.dp_290);
            if (index < 7) {
                leftindex = index;
                centreindex = -1;
                rightindex = 8;
            } else if (7 <= index && index <= (list.size() - 8)) {
                leftindex = 8;
                centreindex = index - 7;
                rightindex = 8;
            } else if (index > (list.size() - 8)) {
                leftindex = 8;
                centreindex = index;
                rightindex = 6 - (index - (list.size() - 7));
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(a, 0, 0, 0);// 4个参数按顺序分别是左上右下
        mList.setLayoutParams(layoutParams);
        mListLeft.setAdapter(new leftMyAdapter(MyApplication.left_listview, MainActivity.this, leftindex, isdlz));
        mList.setAdapter(new shangMyAdapter(MyApplication.centre_listview, MainActivity.this, centreindex, isdlz, isdayu40));
        mListRight.setAdapter(new rightMyAdapter(MyApplication.right_listview, MainActivity.this, rightindex, isdlz));
    }

    private void createfile() {
        // 存放广告的路径
        try {
            File file = new File(ZongFilePath);
            if (!file.exists()) {
                if (file.mkdirs()){
                    Log.v(TAG, "创建总文件夹失败");
                }
                Log.v(TAG, "创建总文件夹成功");
            } else {
                Log.v(TAG, "文件夹已存在");
                Log.v(TAG, "FolderPath:" + ZongFilePath);
            }
            file = new File(ConfigureFilePath);
            if (!file.exists()) {
                if (file.mkdirs()){
                    Log.v(TAG, "创建配置文件夹失败");
                }
                Log.v(TAG, "创建配置文件夹成功");
            } else {
                Log.v(TAG, "文件夹已存在");
                Log.v(TAG, "FolderPath:" + ConfigureFilePath);
            }
            file = new File(LogFilePath);
            if (!file.exists()) {
                if (file.mkdirs()){
                    Log.v(TAG, "创建Log文件夹失败");
                }
                Log.v(TAG, "创建Log文件夹成功");
            } else {
                Log.v(TAG, "文件夹已存在");
                Log.v(TAG, "FolderPath:" + LogFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.v(TAG, "创建文件夹失败");
        }
    }

    // 初始化控件
    private void init() {
        context = MainActivity.this;
        MyApplication.mAppManager.addActivity(this);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, MyApplication.weight);
        mBlankpart.setLayoutParams(param);
        createfile();// 创建文件夹
        //如果是第一次启动就从本地获取数据
        sha = getSharedPreferences("isone", Context.MODE_PRIVATE);
        isOneStart = sha.getBoolean("isonestart", true);
        if (isOneStart) {
            copyfile();
            SharedPreferences.Editor editor = sha.edit();
            editor.putBoolean("isonestart", false);
            editor.apply();
        }
        getLineMsg(4);// 设置站点信息
        // 接收串口数据服务
        Intent intent = new Intent(MainActivity.this, SerialPortService.class);
        startService(intent);
    }

    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x2153:
                    // 设置listview
                    if (MyApplication.sxlist.size() == 0) {
                        ishavemsg = false;
                        if (ishave < 3) {
                            getLineMsg(4);
                        }
                        ishave++;
                    } else {
                        setDrawin(2, MyApplication.sxlist, 2);
                        ishavemsg = true;
                    }
                    setxlmsg();
                    break;
                default:
                    break;
            }
        }

        // 设置线路信息
        private void setxlmsg() {
            if (MyApplication.line_util.getLineWord() == null) {
                return;
            }
            String lineword = MyApplication.line_util.getLineWord();
            if (lineword.substring(MyApplication.line_util.getLineWord().length() - 1, lineword.length()).equals("路")) {
                mLineWord.setText(MyApplication.line_util.getLineWord());
            } else {
                mLineWord.setText(String.format("%s路", MyApplication.line_util.getLineWord()));
            }

        }

    };


    /**
     * @param list 设置左中右list的个数
     */
    public void setlistnum(List<SiteMsg_Util> list) {
        if (list.size() > 40) {
            MyApplication.left_listview = new ArrayList<>();
            MyApplication.right_listview = new ArrayList<>();
            MyApplication.centre_listview = new ArrayList<>();
            List<SiteMsg_Util> list2 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i < 7) {
                    MyApplication.left_listview.add(list.get(i));
                } else if (i > list.size() - 8) {
                    list2.add(list.get(i));
                } else {
                    MyApplication.centre_listview.add(list.get(i));
                }
            }
            for (int i = list2.size() - 1; i >= 0; i--) {
                MyApplication.right_listview.add(list2.get(i));
            }
        }
    }

    public void SetMoney(View view) {

    }

    public void setsxx(int i) {
        switch (i) {
            case 1:
                setDrawin(2, MyApplication.sxlist, 2);
                break;
            case 2:
                setDrawin(2, MyApplication.xxlist, 2);
                break;
        }
    }
}
