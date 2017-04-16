package com.xu.fragmenttabhostdemo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

/*
* viewpager只能缓存3页，第四页的时候就清除数据了，还有一种办法
* setoffset这个方法可以设置viewpager缓存页面，但是会同时加载页面。有缺点
* 下面是新的方法来tab切换FragmentTabHost，是安卓类
* */

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.初始化TabHost
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //2.使tabHost和FrameLayout关联
        tabHost.setup(this, getSupportFragmentManager(),android.R.id.tabcontent);
        //3.添加tab和其对应的fragment
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("all");
        tabSpec.setIndicator("综合");
        Bundle bundle = new Bundle();
        bundle.putString("text","综合界面");
        //添加了tab之后要添加到tabhost来管理，每个tab都要添加fragment字节码，数据
        tabHost.addTab(tabSpec, BlankFragment.class,bundle);

        //2个tab切换
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tweet");
        tabSpec2.setIndicator("动弹");
        Bundle bundle2 = new Bundle();
        bundle2.putString("text","动弹界面");
        tabHost.addTab(tabSpec2, BlankFragment.class,bundle2);

        //自己替换fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事物，然后替换
        fragmentManager.beginTransaction().replace(android.R.id.tabhost,new BlankFragment()).commitAllowingStateLoss();//允许状态丢失，防止崩溃
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
