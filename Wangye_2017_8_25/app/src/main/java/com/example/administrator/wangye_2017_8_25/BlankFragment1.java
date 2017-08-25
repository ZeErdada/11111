package com.example.administrator.wangye_2017_8_25;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.administrator.wangye_2017_8_25.Adapter.MyBaseAdapter;
import com.example.administrator.wangye_2017_8_25.Bean.NewsBean;
import com.google.gson.Gson;
import com.sn.xlistviewlibrary.XListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment implements XListView.IXListViewListener {

    private XListView xlist_view;
    private String path = "http://v.juhe.cn/toutiao/index?type=tiyu&key=d4c18a18c3391f90dc971633f6e6f445";
    private List<NewsBean.ResultBean.DataBean> list;
    private MyHelper helper;
    private SQLiteDatabase db;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.notifyDataSetChanged();
            CollManager();
        }
    };
    private MyBaseAdapter adapter;
    private PopupWindow popupWindow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        xlist_view = (XListView) view.findViewById(R.id.xlist_view);
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(result, NewsBean.class);
                list = newsBean.result.data;
                adapter = new MyBaseAdapter(getActivity(), list);
                xlist_view.setAdapter(adapter);


                //保存至数据库
                helper = new MyHelper(getActivity());
                db = helper.getWritableDatabase();

                ContentValues values = new ContentValues();
                for (int i = 0; i < list.size(); i++) {
                    values.put("title", list.get(i).title);
                }
                long yuekaodb = db.insert("yuekaodb", null, values);
                Toast.makeText(getActivity(), yuekaodb + "保存成功", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        //上拉加载
        xlist_view.setPullLoadEnable(true);
        //下拉刷新
        xlist_view.setPullRefreshEnable(true);
        //XListView监听方法
        xlist_view.setXListViewListener(this);

        xlist_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity(),Main2Activity.class));
            }
        });
        return view;
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 1000);
    }
    public static boolean isOnline(Context context) {
            ConnectivityManager manager = (ConnectivityManager) context
                    .getSystemService(Activity.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                return true;
            }
            return false;
        }
    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 1000);
    }

    public void CollManager() {
        xlist_view.stopRefresh();

        xlist_view.stopLoadMore();

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        xlist_view.setRefreshTime(time);
    }
}
