package com.example.administrator.weiying.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2017/12/13.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
        Fresco.initialize(this);
    }
}
