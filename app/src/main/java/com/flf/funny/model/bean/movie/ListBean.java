package com.flf.funny.model.bean.movie;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：Administrator
 * 时间：2017/4/25:9:15
 * 说明：ListBean.getList  [0]   视频界面顶部ViewPager的六张图片和点击详情
 *       ListBean.getList  [1]   两部电影展示
 *       ListBean.getList  [2]
 *       ListBean.getList  [3]     电影列表展示
 *       ListBean.getList  [4]
 *
 */

public class ListBean implements Serializable {

    private String showStyle;
    private String loadType;
    private String changeOpenFlag;
    private int line;
    private String showType;
    private String moreURL;                //电影列表展示点击进去展示具体电影类型
    private String title;
    private String bigPicShowFlag;
    private List<ListBean.ChildListBean> childList;

    public String getShowStyle() {
        return showStyle;
    }

    public void setShowStyle(String showStyle) {
        this.showStyle = showStyle;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getChangeOpenFlag() {
        return changeOpenFlag;
    }

    public void setChangeOpenFlag(String changeOpenFlag) {
        this.changeOpenFlag = changeOpenFlag;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getMoreURL() {
        return moreURL;
    }

    public void setMoreURL(String moreURL) {
        this.moreURL = moreURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBigPicShowFlag() {
        return bigPicShowFlag;
    }

    public void setBigPicShowFlag(String bigPicShowFlag) {
        this.bigPicShowFlag = bigPicShowFlag;
    }

    public List<ListBean.ChildListBean> getChildList() {
        return childList;
    }

    public void setChildList(List<ListBean.ChildListBean> childList) {
        this.childList = childList;
    }


    public static class ChildListBean {

        private int airTime;
        private String duration;
        private String loadType;
        private float score;
        private String angleIcon;
        private String dataId;
        private String description;
        private String loadURL;                //点击进入详情,需要在解析数据
        private String shareURL;
        private String pic;
        private String title;
        private String roomId;

        public int getAirTime() {
            return airTime;
        }

        public void setAirTime(int airTime) {
            this.airTime = airTime;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLoadType() {
            return loadType;
        }

        public void setLoadType(String loadType) {
            this.loadType = loadType;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }

        public String getAngleIcon() {
            return angleIcon;
        }

        public void setAngleIcon(String angleIcon) {
            this.angleIcon = angleIcon;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLoadURL() {
            return loadURL;
        }

        public void setLoadURL(String loadURL) {
            this.loadURL = loadURL;
        }

        public String getShareURL() {
            return shareURL;
        }

        public void setShareURL(String shareURL) {
            this.shareURL = shareURL;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }
    }
}
