package com.example.administrator.weiying.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.fragment.Fragment_book;
import com.example.administrator.weiying.fragment.Fragment_choice;
import com.example.administrator.weiying.fragment.Fragment_find;
import com.example.administrator.weiying.fragment.Fragment_mine;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomTabBar btb;
    private DrawerLayout dra;
    private NavigationView nav;
    private ImageView mUserIv;
    private LinearLayout mShouc;
    private LinearLayout mDown;
    private LinearLayout mFuli;
    private LinearLayout mSharee;
    private LinearLayout mFank;
    private LinearLayout mSeting;
    /**
     * 关于
     */
    private TextView mGuanyu;
    /**
     * 主题
     */
    private TextView mZhut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btb = (BottomTabBar) findViewById(R.id.btb);
        btb.init(getSupportFragmentManager())
                .setImgSize(28, 28)
                .setFontSize(13)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("精选", R.mipmap.found_select, R.mipmap.found, Fragment_choice.class)
                .addTabItem("专题", R.mipmap.special_select, R.mipmap.special, Fragment_book.class)
                .addTabItem("发现", R.mipmap.fancy_select, R.mipmap.fancy, Fragment_find.class)
                .addTabItem("我的", R.mipmap.my_select, R.mipmap.my, Fragment_mine.class)
                .isShowDivider(false);
    }

    private void initView() {
        mUserIv = (ImageView) findViewById(R.id.user_iv);
        mUserIv.setOnClickListener(this);
        mShouc = (LinearLayout) findViewById(R.id.shouc);
        mShouc.setOnClickListener(this);
        mDown = (LinearLayout) findViewById(R.id.down);
        mDown.setOnClickListener(this);
        mFuli = (LinearLayout) findViewById(R.id.fuli);
        mFuli.setOnClickListener(this);
        mSharee = (LinearLayout) findViewById(R.id.sharee);
        mSharee.setOnClickListener(this);
        mFank = (LinearLayout) findViewById(R.id.fank);
        mFank.setOnClickListener(this);
        mSeting = (LinearLayout) findViewById(R.id.seting);
        mSeting.setOnClickListener(this);
        mGuanyu = (TextView) findViewById(R.id.guanyu);
        mGuanyu.setOnClickListener(this);
        mZhut = (TextView) findViewById(R.id.zhut);
        mZhut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.user_iv:
               break;
            case R.id.shouc:
                Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
               break;
            case R.id.down:
                Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fuli:
                Intent intent = new Intent(MainActivity.this,GankActivity.class);
                startActivity(intent);
                break;
            case R.id.sharee:
                Toast.makeText(this, "敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fank:
                break;
            case R.id.seting:
                break;
            case R.id.guanyu:
                break;
            case R.id.zhut:
                break;
        }
    }
}
