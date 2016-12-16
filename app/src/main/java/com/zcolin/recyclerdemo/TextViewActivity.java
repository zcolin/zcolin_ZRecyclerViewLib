/*
 * *********************************************************
 *   author   colin
 *   company  fosung
 *   email    wanglin2046@126.com
 *   date     16-12-16 下午3:40
 * ********************************************************
 */

package com.zcolin.recyclerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.zcolin.gui.zrecyclerview.ZRefreshLayout;
import com.zcolin.gui.zrecyclerview.progressindicator.ProgressStyle;

public class TextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);


        final ZRefreshLayout refreshLayout = (ZRefreshLayout) findViewById(R.id.refresh_layout);
        // refreshLayout.setIsRefreshEnabled(false);
        //        refreshLayout.setRefreshHeader(new DefRefreshHeader(this));
//        refreshLayout.getRefreshHeaderView()
        //                     .setBackgroundColor(Color.BLUE);
        refreshLayout.setRefreshProgressStyle(ProgressStyle.LineScaleIndicator);
        refreshLayout.setRefreshListener(new ZRefreshLayout.RefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshCompleted();
                    }
                }, 1000);
            }
        });

        refreshLayout.refreshWithPull();
    }
}
