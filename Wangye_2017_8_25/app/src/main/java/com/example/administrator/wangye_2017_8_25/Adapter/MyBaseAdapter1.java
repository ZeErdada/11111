package com.example.administrator.wangye_2017_8_25.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.wangye_2017_8_25.Bean.NewsBean;
import com.example.administrator.wangye_2017_8_25.R;

import java.util.List;

/**
 * Created by admin on 2017/8/21.
 */

public class MyBaseAdapter1 extends BaseAdapter {
    private Context context;
    private List<NewsBean.ResultBean.DataBean> list;

    public MyBaseAdapter1(Context context, List<NewsBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view =View.inflate(context,R.layout.item,null);
            holder.iv= (ImageView) view.findViewById(R.id.image_iv);
            holder.tv= (TextView) view.findViewById(R.id.text_tv);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        holder.tv.setText(list.get(i).title);
        holder.iv.setImageResource(R.mipmap.ic_launcher);
        return view;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}