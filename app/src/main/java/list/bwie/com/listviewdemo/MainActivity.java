package list.bwie.com.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import java.util.ArrayList;

import list.bwie.com.listviewdemo.com.bwie.listview.bean.MyBean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private String[] arrs;
    private MyListView listView;
    ArrayList<MyBean> list=new ArrayList<MyBean>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        ((ScrollView)findViewById(R.id.scrollView)).smoothScrollTo(0,0);
        listView = (MyListView) findViewById(R.id.lv_list);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

    }

    private void initData() {
        arrs = new String[]{"潜力无限", "感恩奉献", "正确归因", "内方外圆",
                "知识很简单", "学习很快乐", "你很棒", "你最棒", "你很好", "你最好"};
        list = new ArrayList<MyBean>();
        for (int i = 0; i < arrs.length; i++) {
            list.add(new MyBean(arrs[i], false));
        }

        //添加数据

        adapter = new MyAdapter(list,this,false);
        listView.setAdapter(adapter);
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                for (MyBean mb:list){
                   mb.isCheck=true;
                    adapter.notifyDataSetChanged();;
                }
                break;
            case R.id.bt2:
                for (MyBean mb:list){
                    if (mb.isCheck=true) {
                        mb.isCheck=false;
                    }
                    adapter.notifyDataSetChanged();
                }

                break;
            case R.id.bt3:
                for (MyBean mb:list){
                    mb.isCheck=false;
                    adapter.notifyDataSetChanged();
                }
                break;
        }


    }



}
