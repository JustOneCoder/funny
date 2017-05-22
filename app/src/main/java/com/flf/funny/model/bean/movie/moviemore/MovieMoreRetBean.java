package com.flf.funny.model.bean.movie.moviemore;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：Administrator
 * 时间：2017/5/14:10:43
 * 说明：具体更多电影的数据实体类
 */

public class MovieMoreRetBean implements Serializable {

    private AdvBean adv;
    private int pnum;
    private int totalRecords;
    private int records;
    private int totalPnum;
    private List<?> bannerList;
    private List<ListBean> list;

    public AdvBean getAdv() {
        return adv;
    }

    public void setAdv(AdvBean adv) {
        this.adv = adv;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public int getTotalPnum() {
        return totalPnum;
    }

    public void setTotalPnum(int totalPnum) {
        this.totalPnum = totalPnum;
    }

    public List<?> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<?> bannerList) {
        this.bannerList = bannerList;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class AdvBean {
        /**
         * imgURL :
         * dataId :
         * htmlURL :
         * title :
         */

        private String imgURL;
        private String dataId;
        private String htmlURL;
        private String title;

        public String getImgURL() {
            return imgURL;
        }

        public void setImgURL(String imgURL) {
            this.imgURL = imgURL;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getHtmlURL() {
            return htmlURL;
        }

        public void setHtmlURL(String htmlURL) {
            this.htmlURL = htmlURL;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
