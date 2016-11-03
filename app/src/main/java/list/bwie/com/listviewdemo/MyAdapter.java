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
    private boolean  hide;
    private ArrayList<MyBean> list;
    private  Context context;
    public MyAdapter(ArrayList<MyBean> list, Context context, boolean isHide) {
        this.context=context;
        this.list=list;
        this.hide=isHide;

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView==null) {
            convertView=View.inflate(context,R.layout.lv_item,null);
            vh=new ViewHolder();
            vh.tv= (TextView) convertView.findViewById(R.id.tv);
            vh.cb= (CheckBox) convertView.findViewById(R.id.cb);
            convertView.setTag(vh);

        }else{
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tv.setText(list.get(position).text);

        vh.cb.setChecked(list.get(position).isCheck);
        vh.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).isCheck=vh.cb.isChecked();
            }
        });





        return convertView;
    }
    class  ViewHolder{
        TextView tv;
        CheckBox cb;
    }
}
