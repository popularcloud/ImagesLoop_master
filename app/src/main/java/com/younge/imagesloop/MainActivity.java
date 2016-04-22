package com.younge.imagesloop;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.younge.imagesloop.autoPager.AutoScrollViewPager;
import com.younge.imagesloop.autoPager.BannerImageInfo;
import com.younge.imagesloop.autoPager.EventClick;
import com.younge.imagesloop.autoPager.ImagePagerAdapter;
import com.younge.imagesloop.autoPager.ListUtils;
import com.younge.imagesloop.autoPager.Test;
import com.younge.imagesloop.util.UIUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutoScrollViewPager autoScrollViewPager;
    ViewGroup loop_main_layout;
   // TextView loop_bannerTitle;
    List<BannerImageInfo> arrayList = null;
    int index,oldPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Picasso.with(this).setIndicatorsEnabled(true);
        initData();
        initContentView();
    }

    private void initData() {
        arrayList = new ArrayList<>();
        arrayList.add(new BannerImageInfo("全面回忆高清影视","http://img2.cache.netease.com/ent/2012/8/3/2012080303380055dd4.jpg"));
        arrayList.add(new BannerImageInfo("名牌大厂的美女","http://imgsrc.baidu.com/forum/pic/item/cf8cdb22720e0cf39b7f28510a46f21fbc09aaea.jpg"));
        arrayList.add(new BannerImageInfo("圣诞老人的礼物","http://i1.sinaimg.cn/edu/2014/1203/U12216P42DT20141203165538.jpeg"));
    }

    private void initContentView() {
        autoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.loop_view_pager);
        loop_main_layout = (ViewGroup) findViewById(R.id.loop_main_layout);
        //loop_bannerTitle = (TextView) findViewById(R.id.loop_bannerTitle);
        if(arrayList != null && arrayList.size() > 0) {
            initDots(arrayList.size());
            autoScrollViewPager.setAdapter(new ImagePagerAdapter(this, arrayList, new EventClick() {
                @Override
                public void eventClick(View v) {
                }
            }).setInfiniteLoop(true));

            autoScrollViewPager.setOffscreenPageLimit(arrayList.size());
            autoScrollViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
            autoScrollViewPager.setInterval(5000);
            autoScrollViewPager.startAutoScroll();
            autoScrollViewPager.setCurrentItem(0);
        }
    }

    private void initDots(int size) {
        loop_main_layout.removeAllViews();
        index = 0;
        oldPosition = 0;
        for (int i = 0; i < size; i++) {
            if(i==0) {
                loop_main_layout.addView(setDaoHangText(R.drawable.dot_focused));
            }else {
                loop_main_layout.addView(setDaoHangText(R.drawable.dot_normal));
            }
        }
    }

    private View setDaoHangText(int id) {
        View text = new View(this);
        LinearLayout.LayoutParams Viewpar = new LinearLayout.LayoutParams(UIUtil.dip2px(this, 4), UIUtil.dip2px(this,4));
        Viewpar.setMargins(5, 5, 5, 5);
        text.setLayoutParams(Viewpar);
        text.setBackgroundResource(id);
        return text;
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            index=(position) % ListUtils.getSize(arrayList);
           // loop_bannerTitle.setText(arrayList.get((position) % ListUtils.getSize(arrayList)).getTitle());
            loop_main_layout.getChildAt(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            loop_main_layout.getChildAt((position) % ListUtils.getSize(arrayList)).setBackgroundResource(R.drawable.dot_focused);
            oldPosition=(position) % ListUtils.getSize(arrayList);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }

}
