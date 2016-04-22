package com.younge.imagesloop.autoPager;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.younge.imagesloop.util.UIUtil;

import java.util.List;

public class ImagePagerAdapter extends RecyclingPagerAdapter {

    private Context context;
    private List<BannerImageInfo> imageIdList;

    private int size;
    private boolean isInfiniteLoop;
    private EventClick eventClick;
    private ViewHolder holder;

    public ImagePagerAdapter(Context context, List<BannerImageInfo> imageIdList,EventClick eventClick) {
        this.context = context;
        this.imageIdList = imageIdList;
        this.size = ListUtils.getSize(imageIdList);
        isInfiniteLoop = false;
        this.eventClick=eventClick;
    }

    @Override
    public int getCount() {
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

            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

            holder.imageView = new ImageView(context);
            holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout.addView(holder.imageView,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

            holder.textView = new TextView(context);
            holder.textView.setTextSize(UIUtil.dip2px(context,3));
            holder.textView.setTextColor(Color.parseColor("#ffffff"));
            holder.textView.setBackgroundColor(Color.parseColor("#c8414141"));
            holder.textView.setSingleLine(true);
            holder.textView.setEllipsize(TextUtils.TruncateAt.END);
            holder.textView.setGravity(Gravity.CENTER);
            RelativeLayout.LayoutParams rl =  new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            rl.addRule(RelativeLayout.CENTER_HORIZONTAL);
            rl.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            relativeLayout.addView(holder.textView,rl);
            view = relativeLayout;
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Picasso.with(context).load(imageIdList.get(index).getImg_src()).into(holder.imageView);
        holder.textView.setText(imageIdList.get(index).getTitle());
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
    public ImagePagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        return this;
    }
}
