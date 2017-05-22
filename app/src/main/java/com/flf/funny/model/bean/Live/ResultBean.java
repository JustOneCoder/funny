package com.flf.funny.model.bean.Live;

import java.io.Serializable;

/**
 * 作者：Administrator
 * 时间：2017/5/11:10:12
 * 说明：直播条目数据bean
 */

public class ResultBean implements Serializable {
    /**
     * enable : 1
     * game_type : lol
     * live_id : 787579
     * live_img : https://rpic.douyucdn.cn/a1705/16/12/787579_170516124645.jpg
     * live_name : douyu
     * live_nickname : 仙凡哥哥丶
     * live_online : 119661
     * live_title : 仙凡:SOLO王,赢我一次50QB
     * live_type : douyu
     * live_userimg :
     * offline_time : 1494414063.5399
     * online_time : 1494411011.7466
     * push_time : 1494397301.7860
     * show_type : native
     * sort_num : 119661
     * url_info : {"Referer":"http://api.douyutv.com/","User_Agent":"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.54","url":"http://capi.douyucdn.cn/api/v1/room/787579?aid=dotamax&time=1494911280&auth=abe07b99e22db23f4454bcc36975ea87"}
     */

    private int enable;
    private String game_type;
    private String live_id;
    private String live_img;
    private String live_name;
    private String live_nickname;
    private String live_online;
    private String live_title;
    private String live_type;
    private String live_userimg;
    private String offline_time;
    private String online_time;
    private String push_time;
    private String show_type;
    private int sort_num;
    private UrlInfoBean url_info;

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public String getGame_type() {
        return game_type;
    }

    public void setGame_type(String game_type) {
        this.game_type = game_type;
    }

    public String getLive_id() {
        return live_id;
    }

    public void setLive_id(String live_id) {
        this.live_id = live_id;
    }

    public String getLive_img() {
        return live_img;
    }

    public void setLive_img(String live_img) {
        this.live_img = live_img;
    }

    public String getLive_name() {
        return live_name;
    }

    public void setLive_name(String live_name) {
        this.live_name = live_name;
    }

    public String getLive_nickname() {
        return live_nickname;
    }

    public void setLive_nickname(String live_nickname) {
        this.live_nickname = live_nickname;
    }

    public String getLive_online() {
        return live_online;
    }

    public void setLive_online(String live_online) {
        this.live_online = live_online;
    }

    public String getLive_title() {
        return live_title;
    }

    public void setLive_title(String live_title) {
        this.live_title = live_title;
    }

    public String getLive_type() {
        return live_type;
    }

    public void setLive_type(String live_type) {
        this.live_type = live_type;
    }

    public String getLive_userimg() {
        return live_userimg;
    }

    public void setLive_userimg(String live_userimg) {
        this.live_userimg = live_userimg;
    }

    public String getOffline_time() {
        return offline_time;
    }

    public void setOffline_time(String offline_time) {
        this.offline_time = offline_time;
    }

    public String getOnline_time() {
        return online_time;
    }

    public void setOnline_time(String online_time) {
        this.online_time = online_time;
    }

    public String getPush_time() {
        return push_time;
    }

    public void setPush_time(String push_time) {
        this.push_time = push_time;
    }

    public String getShow_type() {
        return show_type;
    }

    public void setShow_type(String show_type) {
        this.show_type = show_type;
    }

    public int getSort_num() {
        return sort_num;
    }

    public void setSort_num(int sort_num) {
        this.sort_num = sort_num;
    }

    public UrlInfoBean getUrl_info() {
        return url_info;
    }

    public void setUrl_info(UrlInfoBean url_info) {
        this.url_info = url_info;
    }

    public static class UrlInfoBean {
        /**
         * Referer : http://api.douyutv.com/
         * User_Agent : Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.54
         * url : http://capi.douyucdn.cn/api/v1/room/787579?aid=dotamax&time=1494911280&auth=abe07b99e22db23f4454bcc36975ea87
         */

        private String Referer;
        private String User_Agent;
        private String url;

        public String getReferer() {
            return Referer;
        }

        public void setReferer(String Referer) {
            this.Referer = Referer;
        }

        public String getUser_Agent() {
            return User_Agent;
        }

        public void setUser_Agent(String User_Agent) {
            this.User_Agent = User_Agent;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
