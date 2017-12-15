package com.example.administrator.weiying.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.weiying.R;

public class SearchActivity extends AppCompatActivity{

    /**
     * 请输入你喜欢的电影
     */
    private EditText mFind;
    /**
     * 取消
     */
    private TextView mTvDouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    private void initView() {
        mFind = (EditText) findViewById(R.id.find);
        mTvDouble = (TextView) findViewById(R.id.tv_double);
        mFind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mTvDouble.setText("取消");
            }

            @Override
            public void onTextChanged(CharSequence s, final int start, int before, int count) {
                if(mFind.getText().toString().trim().equals("")){
                    mTvDouble.setText("取消");
                    mTvDouble.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                }else{
                    mTvDouble.setText("搜索");
                    mTvDouble.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(SearchActivity.this,ShowSearchActivity.class);
                            String keyword = mFind.getText().toString().trim();
                            intent.putExtra("keyword",keyword);
                            startActivity(intent);
                        }
                    });
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
