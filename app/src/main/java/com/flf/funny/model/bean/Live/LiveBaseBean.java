package com.flf.funny.model.bean.Live;

import java.util.ArrayList;

/**
 * 作者：Administrator
 * 时间：2017/5/11:10:14
 * 说明：直播网络请求实体基类
 */

public class LiveBaseBean<T> {

    /**
     * msg :
     * result : [{"enable":1,"game_type":"lol","live_id":"787579","live_img":"https://rpic.douyucdn.cn/a1705/16/12/787579_170516124645.jpg","live_name":"douyu","live_nickname":"仙凡哥哥丶","live_online":119661,"live_title":"仙凡:SOLO王,赢我一次50QB","live_type":"douyu","live_userimg":"","offline_time":"1494414063.5399","online_time":"1494411011.7466","push_time":"1494397301.7860","show_type":"native","sort_num":119661,"url_info":{"Referer":"http://api.douyutv.com/","User_Agent":"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.54","url":"http://capi.douyucdn.cn/api/v1/room/787579?aid=dotamax&time=1494911280&auth=abe07b99e22db23f4454bcc36975ea87"}},{"enable":1,"game_type":"lol","live_id":"780824","live_img":"https://rpic.douyucdn.cn/a1705/16/12/780824_170516125312.jpg","live_name":"douyu","live_nickname":"神威仙大将军","live_online":63566,"live_title":"最强沙漠死神，崛起于微末，王于巅","live_type":"douyu","live_userimg":"","offline_time":"1494401567.1788","online_time":"1494401260.9402","push_time":"1494383607.5878","show_type":"native","sort_num":63566,"url_info":{"Referer":"http://api.douyutv.com/","User_Agent":"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.54","url":"http://capi.douyucdn.cn/api/v1/room/780824?aid=dotamax&time=1494911280&auth=97723de4bdc01e58863cdea54679d181"}},{"enable":1,"game_type":"lol","live_id":"232981","live_img":"https://rpic.douyucdn.cn/a1705/16/12/232981_170516124735.jpg","live_name":"douyu","live_nickname":"小舒君","live_online":24956,"live_title":"我的提莫自己都怕","live_type":"douyu","live_userimg":"","offline_time":"1494472454.5294","online_time":"1494472758.6892","push_time":"1494471240.2898","show_type":"native","sort_num":24956,"url_info":{"Referer":"http://api.douyutv.com/","User_Agent":"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.54","url":"http://capi.douyucdn.cn/api/v1/room/232981?aid=dotamax&time=1494911280&auth=be6c66af053b029a48e287644578c21f"}},{"enable":1,"game_type":"lol","live_id":"244036","live_img":"https://rpic.douyucdn.cn/a1705/16/12/244036_170516125300.jpg","live_name":"douyu","live_nickname":"大莉cc","live_online":19704,"live_title":"【大莉cc】爱玩中单的妹子","live_type":"douyu","live_userimg":"","offline_time":"1494396079.8562","online_time":"1494394862.7819","push_time":"1494385433.5054","show_type":"native","sort_num":19704,"url_info":{"Referer":"http://api.douyutv.com/","User_Agent":"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.54","url":"http://capi.douyucdn.cn/api/v1/room/244036?aid=dotamax&time=1494911280&auth=8dfe0dacc71496163ddcebff68c1a85d"}},{"enable":1,"game_type":"lol","live_id":"22822","live_img":"https://rpic.douyucdn.cn/a1705/16/12/22822_170516124735.jpg","live_name":"douyu","live_nickname":"齐小岳丶","live_online":18060,"live_title":"齐小岳：偶尔也想冲个第一","live_type":"douyu","live_userimg":"","offline_time":"1494311892.5209","online_time":"1494309144.0539","push_time":"1494298174.8120","show_type":"native","sort_num":18060,"url_info":{"Referer":"http://api.douyutv.com/","User_Agent":"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.54","url":"http://capi.douyucdn.cn/api/v1/room/22822?aid=dotamax&time=1494911280&auth=924dc87f308762c076dbba8306184979"}},{"enable":1,"game_type":"lol","live_id":"632353","live_img":"https://rpic.douyucdn.cn/a1705/16/12/632353_170516124730.jpg","live_name":"douyu","live_nickname":"赵锤石丶","live_online":17721,"live_title":"斗鱼第一【CD流】锤石！2秒1钩！","live_type":"douyu","live_userimg":"","offline_time":"1494471846.8452","online_time":"1494474584.4699","push_time":"1494470932.8400","show_type":"native","sort_num":17721,"url_info":{"Referer":"http://api.douyutv.com/","User_Agent":"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.54","url":"http://capi.douyucdn.cn/api/v1/room/632353?aid=dotamax&time=1494911280&auth=30338520f5e57c386c413bfb77aac9c8"}},{"enable":1,"game_type":"lol","live_id":"223770","live_img":"https://rpic.douyucdn.cn/a1705/16/12/223770_170516124740.jpg","live_name":"douyu","live_nickname":"地下皇帝丶","live_online":13087,"live_title":"第一狼人：皮皮狼野区制霸之路","live_type":"douyu","live_userimg":"","offline_time":"1494472454.5578","online_time":"1494472758.7358","push_time":"1494461142.3966","show_type":"native","sort_num":13087,"url_info":{"Referer":"http://api.douyutv.com/","User_Agent":"Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.54","url":"http://capi.douyucdn.cn/api/v1/room/223770?aid=dotamax&time=1494911280&auth=2869b8b13295e5d8c6df532f53bb50a8"}}]
     * status : ok
     */

    private String msg;
    private String status;
    private ArrayList<ResultBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ResultBean> getResult() {
        return result;
    }

    public void setResult(ArrayList<ResultBean> result) {
        this.result = result;
    }

}
