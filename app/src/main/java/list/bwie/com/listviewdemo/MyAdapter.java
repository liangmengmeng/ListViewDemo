package list.bwie.com.listviewdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import list.bwie.com.listviewdemo.com.bwie.listview.bean.MyBean;

/**
 * Created by admina on 2016/11/2.
 */
public class MyAdapter extends BaseAdapter {
    private  String[] arrs;
    private  Context context;
    private ArrayList<MyBean> al=new ArrayList<MyBean>();

    public MyAdapter(String[] arrs, Context context) {
        this.context=context;
        this.arrs=arrs;

    }

    @Override
    public int getCount() {
        return arrs.length;
    }

    @Override
    public Object getItem(int position) {
        return arrs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null) {
            convertView=View.inflate(context,R.layout.lv_item,null);
            vh=new ViewHolder();
            vh.tv= (TextView) convertView.findViewById(R.id.tv);
            vh.cb= (CheckBox) convertView.findViewById(R.id.cb);
            convertView.setTag(vh);

        }else{
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tv.setText(arrs[position]);
        //vh.cb.setChecked(al.get(position).isCheck);




        return convertView;
    }
    class  ViewHolder{
        TextView tv;
        CheckBox cb;
    }
}
