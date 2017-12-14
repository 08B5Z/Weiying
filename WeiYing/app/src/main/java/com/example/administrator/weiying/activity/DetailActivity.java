package com.example.administrator.weiying.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.example.administrator.weiying.R;
import com.example.administrator.weiying.fragment.Fragment01;
import com.example.administrator.weiying.fragment.Fragment02;
import com.example.administrator.weiying.model.bean.DetailBean;
import com.example.administrator.weiying.presenter.DetailPresenter;
import com.example.administrator.weiying.view.DetailView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private String dataId;
    private String description;
    private TextView mTitle;
    private IjkVideoView mIvv;
    private ImageView back;
    private PagerSlidingTabStrip tabs;
    private ViewPager vp;
    private String[] names = {"简介","评论"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        initView();

        Intent intent = getIntent();
        dataId = intent.getStringExtra("dataId");
        description = intent.getStringExtra("description");

        DetailPresenter detailPresenter = new DetailPresenter(this);
        detailPresenter.getDetailPresenter();

        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(vp);

    }

    @Override
    public String getMediaId() {
        return dataId;
    }

    @Override
    public void getDetailView(DetailBean detailBean) {
        String hdurl = detailBean.getRet().getHDURL();
        String title = detailBean.getRet().getTitle();

        mTitle.setText(title);

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        AndroidMediaController controller = new AndroidMediaController(this, false);
        mIvv.setMediaController(controller);
        mIvv.setVideoURI(Uri.parse(hdurl));
        mIvv.start();
    }

    private void initView() {
        mTitle = (TextView) findViewById(R.id.title);
        mIvv = (IjkVideoView) findViewById(R.id.ivv);
        back = (ImageView) findViewById(R.id.back);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        vp = (ViewPager) findViewById(R.id.vp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //适配器
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String name = names[position];
            return name;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            switch (position){
                case 0:
                    fragment = new Fragment01();
                    break;

                case 1:
                    fragment = new Fragment02();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return names.length;
        }
    }
}
