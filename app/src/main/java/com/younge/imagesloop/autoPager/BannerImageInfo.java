package com.younge.imagesloop.autoPager;

/**
 * Created by Allen Lake on 2016/4/22 0022.
 */
public class BannerImageInfo{

    private Integer banner_id;
    private String img_src;
    private String title;
    private String link_url;

    public BannerImageInfo(String title,String img_src){
        setTitle(title);
        setImg_src(img_src);
    }

    public Integer getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(Integer banner_id) {
        this.banner_id = banner_id;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }
}
