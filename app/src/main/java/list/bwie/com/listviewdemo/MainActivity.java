package list.bwie.com.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private String[] arrs;
    private MyListView listView;

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

    }

    private void initData() {
        arrs = new String[]{"潜力无限", "感恩奉献", "正确归因", "内方外圆",
                "知识很简单", "学习很快乐", "你很棒", "你最棒", "你很好", "你最好"};
        MyAdapter adapter=new MyAdapter(arrs,this);
        listView.setAdapter(adapter);
    }

}
