package com.younge.imagesloop.autoPager;

import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/3/23.
 */
public class Test {
    private TextView title;
    private int oldPosition,index;
    private ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String,String>>();
    LinearLayout mainLayout;
    private AutoScrollViewPager viewPager;
    public void test(){
        HashMap<String, String> hashMap1=new HashMap<String, String>();
        hashMap1.put("title", "全面回忆高清影视");
        hashMap1.put("img_src", "http://img2.cache.netease.com/ent/2012/8/3/2012080303380055dd4.jpg");
        hashMap1.put("src_link", "http://www.baidu.com");
        arrayList.add(hashMap1);

        HashMap<String, String> hashMap2=new HashMap<String, String>();
        hashMap2.put("title", "名牌大厂的美女");
        hashMap2.put("img_src", "http://imgsrc.baidu.com/forum/pic/item/cf8cdb22720e0cf39b7f28510a46f21fbc09aaea.jpg");
        hashMap2.put("src_link", "http://www.baidu.com");
        arrayList.add(hashMap2);

        HashMap<String, String> hashMap3=new HashMap<String, String>();
        hashMap3.put("title", "圣诞老人的礼物");
        hashMap3.put("img_src", "http://i1.sinaimg.cn/edu/2014/1203/U12216P42DT20141203165538.jpeg");
        hashMap3.put("src_link", "http://www.baidu.com");
        arrayList.add(hashMap3);

        if(arrayList.size() == 0){
            return;
        }
 /*       title = (TextView)findViewById(R.id.bannerTitle);
        mainLayout= (LinearLayout)findViewById(R.id.mainlayout);
        initDots();
        viewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new ImagePagerAdapter(MainActivity.this, arrayList, new EventClick() {

            @Override
            public void eventClick() {
                // TODO Auto-generated method stub
                if (arrayList == null || arrayList.size() == 0) {
                    return;
                }
                Log.e("TAG", index + "处理点击每张图片的点击事件：" + arrayList.get(index).get("src_link") + "----:" + arrayList.get(index).get("title"));
                Intent intent = new Intent();
                intent.putExtra("url", arrayList.get(index).get("src_link"));
            }
        }).setInfiniteLoop(true));
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
        viewPager.setInterval(4000);
        viewPager.startAutoScroll();
        //Log.e(TAG,Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % ListUtils.getSize(arrayList)+"");
        viewPager.setCurrentItem(0);*/
    }
/*
    private void initDots() {
        for (int i = 0; i < arrayList.size(); i++) {
            if(i==0) {
                mainLayout.addView(setDaoHangText(R.drawable.dot_focused));
            }else {
                mainLayout.addView(setDaoHangText(R.drawable.dot_normal));
            }
        }
    }*/

/*
    private View setDaoHangText(int id) {
        View text = new View(MainActivity.this);
        LinearLayout.LayoutParams Viewpar = new LinearLayout.LayoutParams(UIUtil.dip2px(MainActivity.this, 8), UIUtil.dip2px(MainActivity.this, 8));
        Viewpar.setMargins(5, 5, 5, 5);
        text.setLayoutParams(Viewpar);
        text.setBackgroundResource(id);
        return text;
    }
*/

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int position) {
   /*         index=(position) % ListUtils.getSize(arrayList);
            title.setText(arrayList.get((position) % ListUtils.getSize(arrayList)).get("title"));

            mainLayout.getChildAt(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            mainLayout.getChildAt((position) % ListUtils.getSize(arrayList)).setBackgroundResource(R.drawable.dot_focused);
            oldPosition=(position) % ListUtils.getSize(arrayList);*/
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
}
