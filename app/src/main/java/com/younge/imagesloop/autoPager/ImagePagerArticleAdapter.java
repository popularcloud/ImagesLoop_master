package com.younge.imagesloop.autoPager;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.List;


/**
 * ImagePagerAdapter
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2014-2-23
 */
public class ImagePagerArticleAdapter extends RecyclingPagerAdapter {

    private Activity activity;
    private List<BannerImageInfo> imageIdList;

    private int size;
    private boolean isInfiniteLoop;
    private EventClick eventClick;
    private ViewHolder holder;

    public ImagePagerArticleAdapter(Activity activity, List<BannerImageInfo> imageIdList, EventClick eventClick) {
        this.activity = activity;
        this.imageIdList = imageIdList;
        this.size = ListUtils.getSize(imageIdList);
        isInfiniteLoop = false;
        this.eventClick=eventClick;
    }

    @Override
    public int getCount() {
        // Infinite loop
        return isInfiniteLoop ? Integer.MAX_VALUE : ListUtils.getSize(imageIdList);
    }

    /**
     * get really position
     * 
     * @param position
     * @return
     */
    private int getPosition(int position) {
        return isInfiniteLoop ? position % size : position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup container) {
        int index = getPosition(position);
        if (view == null) {
            holder = new ViewHolder();
            RelativeLayout relativeLayout = new RelativeLayout(activity);

            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            holder.imageView = new ImageView(activity);
            holder.imageView.setScaleType(ImageView.ScaleType.CENTER);
            relativeLayout.addView(holder.imageView,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
            view = relativeLayout;
            holder.textView = new TextView(activity);
            //holder.textView.setTextSize(UIUtil.dip2px(activity,16));
            holder.textView.setTextColor(Color.parseColor("#ffffff"));
            holder.textView.setBackgroundColor(Color.parseColor("#c8414141"));
            holder.textView.setSingleLine(true);
            holder.textView.setEllipsize(TextUtils.TruncateAt.END);
            holder.textView.setGravity(Gravity.CENTER);
            RelativeLayout.LayoutParams rl =  new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            rl.addRule(RelativeLayout.CENTER_HORIZONTAL);
            rl.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            relativeLayout.addView(holder.textView,rl);
            //holder.textView = (TextView) activity.findViewById(R.id.loop_bannerTitle);
           // holder.textView = (TextView) activity.findViewById(R.id.loop_bannerTitle);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
       // holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(width,height));
/*        holder.imageView.setTag(R.id.imageTag,imageIdList.get(index).getLink_url());
        holder.imageView.setImageResource(R.mipmap.image_placeholder_873_240);
        holder.textView.setText(imageIdList.get(index).getTitle());*/
        holder.imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                eventClick.eventClick(v);
            }
        });
      //  RequestHttpUtil.loadImage(activity,imageIdList.get(getPosition(position)).getImg_src(),holder.imageView,R.drawable.big_loop_default);
        return view;
    }

    private static class ViewHolder {

        ImageView imageView;
        TextView textView;
    }

    /**
     * @return the isInfiniteLoop
     */
    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    /**
     * @param isInfiniteLoop
     *            the isInfiniteLoop to set
     */
    public ImagePagerArticleAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        return this;
    }
}
