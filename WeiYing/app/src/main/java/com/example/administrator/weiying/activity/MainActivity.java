package com.example.administrator.weiying.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.fragment.Fragment_book;
import com.example.administrator.weiying.fragment.Fragment_choice;
import com.example.administrator.weiying.fragment.Fragment_find;
import com.example.administrator.weiying.fragment.Fragment_mine;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar btb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btb = (BottomTabBar) findViewById(R.id.btb);
        btb.init(getSupportFragmentManager())
                .setImgSize(28,28)
                .setFontSize(13)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("精选",R.mipmap.found_select,R.mipmap.found, Fragment_choice.class)
                .addTabItem("专题",R.mipmap.special_select,R.mipmap.special,Fragment_book.class)
                .addTabItem("发现",R.mipmap.fancy_select,R.mipmap.fancy, Fragment_find.class)
                .addTabItem("我的",R.mipmap.my_select,R.mipmap.my, Fragment_mine.class)
                .isShowDivider(false);
    }
}
