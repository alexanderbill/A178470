package com.mobcent.discuz.bean;

import java.util.Collections;
import java.util.List;

/**
 * Created by sun on 2016/10/20.
 */

public class InitUIResult extends BaseResult{

    /**
     * externInfo : {"padding":""}
     * navigation : {"type":"bottom","navItemList":[{"icon":"mc_forum_main_bar_button1","title":"首页","moduleId":6},{"icon":"mc_forum_main_bar_button29","title":"论坛","moduleId":4},{"icon":"mc_forum_main_bar_button17","title":"发帖","moduleId":2},{"icon":"mc_forum_main_bar_button5","title":"发现","moduleId":8},{"icon":"mc_forum_main_bar_button26","title":"我的","moduleId":1}]}
     * moduleList : [{"id":1,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"我的","extParams":{"padding":""},"style":"flat","rightTopbars":[],"leftTopbars":[],"type":"full","versionNum":"1.0","componentList":[{"id":"c10","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"discover","componentList":[{"id":"c5","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"discoverSlider","type":"layout","componentList":[]},{"id":"c8","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"discoverDefault","type":"layout","componentList":[{"id":"c6","iconStyle":"image","icon":"mc_forum_squre_icon9","title":"个人中心","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"isHidden":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"userinfo","componentList":[]},{"id":"c7","iconStyle":"image","icon":"mc_forum_squre_icon7","title":"设置","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"isHidden":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"setting","componentList":[]}]},{"id":"c9","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"discoverCustom","type":"layout","componentList":[]}]}]},{"id":2,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"发帖","extParams":{"padding":""},"style":"flat","rightTopbars":[],"leftTopbars":[],"type":"fastpost","componentList":[{"id":"c15","iconStyle":"image","icon":"mc_forum_ico27","title":"文字","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":1,"dataId":0,"titlePosition":"left","subListStyle":"","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"","listBoardNameState":0,"order":0,"filterId":0,"forumId":0,"topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"fasttext","componentList":[]},{"id":"c16","iconStyle":"image","icon":"mc_forum_ico28","title":"图片","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":1,"dataId":0,"titlePosition":"left","subListStyle":"","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"","listBoardNameState":0,"order":0,"filterId":0,"forumId":0,"topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"fastimage","componentList":[]},{"id":"c17","iconStyle":"image","icon":"mc_forum_ico29","title":"拍照","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":1,"dataId":0,"titlePosition":"left","subListStyle":"","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"","listBoardNameState":0,"order":0,"filterId":0,"forumId":0,"topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"fastcamera","componentList":[]}]},{"id":3,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"推荐（旧版）","extParams":{"padding":""},"style":"flat","rightTopbars":[],"leftTopbars":[],"type":"subnav","componentList":[{"id":"c22","iconStyle":"image","icon":"","title":"热点","desc":"","extParams":{"fastpostForumIds":[],"talkId":0,"moduleId":6,"dataId":0,"titlePosition":"left","subListStyle":"","listTitleLength":40,"listSummaryLength":40,"newsModuleId":5,"articleId":0,"subDetailViewStyle":"","listBoardNameState":1,"order":0,"filterId":0,"forumId":0,"topicId":0,"redirect":"","orderby":"","isShowTopicTitle":0,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","px":0,"type":"moduleRef","componentList":[]},{"id":"c23","iconStyle":"image","icon":"","title":"最新","desc":"","extParams":{"fastpostForumIds":[],"talkId":0,"moduleId":6,"dataId":0,"titlePosition":"left","subListStyle":"","listTitleLength":80,"listSummaryLength":0,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","listBoardNameState":1,"order":0,"filterId":0,"forumId":0,"topicId":0,"redirect":"","orderby":"new","isShowTopicTitle":0,"isShowMessagelist":0,"listImagePosition":1,"filter":"typeid"},"style":"tieba","px":0,"type":"topiclistSimple","componentList":[]},{"id":"c24","iconStyle":"image","icon":"","title":"精华","desc":"","extParams":{"fastpostForumIds":[],"talkId":0,"moduleId":6,"dataId":0,"titlePosition":"left","subListStyle":"","listTitleLength":100,"listSummaryLength":0,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","listBoardNameState":1,"order":0,"filterId":0,"forumId":0,"topicId":0,"redirect":"","orderby":"marrow","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":1,"filter":"typeid"},"style":"flat","px":0,"type":"topiclistSimple","componentList":[]},{"id":"c25","iconStyle":"image","icon":"","title":"置顶","desc":"","extParams":{"fastpostForumIds":[],"talkId":0,"moduleId":6,"dataId":0,"titlePosition":"left","subListStyle":"","listTitleLength":100,"listSummaryLength":0,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","listBoardNameState":1,"order":0,"filterId":0,"forumId":0,"topicId":0,"redirect":"","orderby":"top","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":1,"filter":"typeid"},"style":"flat","px":0,"type":"topiclistSimple","componentList":[]}]},{"id":4,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"论坛","extParams":{"padding":""},"style":"card","rightTopbars":[{"px":0,"type":"search","style":"flat","icon":"mc_forum_top_bar_button10","iconStyle":"image","title":"","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":0,"forumId":0,"moduleId":6,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"","orderby":"","order":0,"redirect":"","listTitleLength":40,"listSummaryLength":40,"listImagePosition":2,"subListStyle":"","subDetailViewStyle":"","listBoardNameState":0},"id":"c38","componentList":[]},{"px":0,"type":"userinfo","style":"flat","icon":"mc_forum_top_bar_button6","iconStyle":"image","title":"","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":0,"forumId":0,"moduleId":6,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":1,"filterId":0,"talkId":0,"filter":"","orderby":"","order":0,"redirect":"","listTitleLength":40,"listSummaryLength":40,"listImagePosition":2,"subListStyle":"","subDetailViewStyle":"","listBoardNameState":0},"id":"c39","componentList":[]}],"leftTopbars":[],"type":"subnav","componentList":[{"px":0,"type":"forumlist","style":"boardSplit","icon":"","iconStyle":"image","title":"版块","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":0,"forumId":0,"moduleId":6,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"","orderby":"","order":0,"redirect":"","listTitleLength":40,"listSummaryLength":0,"listImagePosition":2,"subListStyle":"neteaseNews","subDetailViewStyle":"flat","listBoardNameState":0},"id":"c30","componentList":[]},{"px":0,"type":"topiclistSimple","style":"neteaseNews","icon":"","iconStyle":"image","title":"最新","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":0,"forumId":0,"moduleId":6,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"typeid","orderby":"new","order":0,"redirect":"","listTitleLength":40,"listSummaryLength":0,"listImagePosition":2,"subListStyle":"","subDetailViewStyle":"flat","listBoardNameState":1},"id":"c31","componentList":[]},{"px":0,"type":"topiclistSimple","style":"neteaseNews","icon":"","iconStyle":"image","title":"精华","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":0,"forumId":0,"moduleId":6,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"typeid","orderby":"marrow","order":0,"redirect":"","listTitleLength":40,"listSummaryLength":0,"listImagePosition":2,"subListStyle":"","subDetailViewStyle":"flat","listBoardNameState":1},"id":"c32","componentList":[]}]},{"id":6,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"首页","extParams":{"padding":""},"style":"flat","rightTopbars":[],"leftTopbars":[],"type":"custom","versionNum":"1.0","componentList":[]},{"id":8,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"发现","extParams":{"padding":""},"style":"flat","rightTopbars":[],"leftTopbars":[],"type":"subnav","versionNum":"1.0","componentList":[{"px":0,"type":"newslist","style":"image","icon":"","iconStyle":"image","title":"视界","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":1,"forumId":0,"moduleId":6,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"","orderby":"","order":0,"redirect":"","listTitleLength":40,"listSummaryLength":0,"listImagePosition":1,"subListStyle":"","subDetailViewStyle":"flat","listBoardNameState":1},"id":"c79","componentList":[]},{"px":0,"type":"newslist","style":"imageSudoku","icon":"","iconStyle":"image","title":"慈善","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":2,"forumId":0,"moduleId":6,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"","orderby":"","order":0,"redirect":"http://139.196.180.160:4567/?from=singlemessage&isappinstalled=0","listTitleLength":40,"listSummaryLength":0,"listImagePosition":1,"subListStyle":"","subDetailViewStyle":"flat","listBoardNameState":0},"id":"c80","componentList":[]},{"px":0,"type":"newslist","style":"tieba","icon":"","iconStyle":"image","title":"动漫","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":3,"forumId":0,"moduleId":6,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"","orderby":"","order":0,"redirect":"http://139.196.180.160:4567/?from=singlemessage&isappinstalled=0","listTitleLength":60,"listSummaryLength":0,"listImagePosition":2,"subListStyle":"","subDetailViewStyle":"flat","listBoardNameState":1},"id":"c81","componentList":[]}]},{"id":9,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"测试","extParams":{"padding":""},"style":"subnavTopbar","rightTopbars":[],"leftTopbars":[],"type":"custom","versionNum":"1.0","componentList":[]},{"id":10,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"网络直播","extParams":{"padding":""},"style":"flat","rightTopbars":[],"leftTopbars":[],"type":"custom","versionNum":"1.0","componentList":[]},{"id":11,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"龙泉闻思修总目录","extParams":{"padding":""},"style":"subnavTopbar","rightTopbars":[],"leftTopbars":[],"type":"custom","versionNum":"1.0","componentList":[]},{"id":12,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"闻思修感悟人生","extParams":{"padding":""},"style":"flat","rightTopbars":[],"leftTopbars":[],"type":"custom","versionNum":"1.0","componentList":[]},{"id":13,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"广论第一期目录","extParams":{"padding":""},"style":"flat","rightTopbars":[],"leftTopbars":[],"type":"custom","versionNum":"1.0","componentList":[]},{"id":14,"icon":"http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png","title":"龙泉闻思修","extParams":{"padding":""},"style":"card","rightTopbars":[],"leftTopbars":[],"type":"subnav","versionNum":"1.0","componentList":[{"px":0,"type":"webapp","style":"flat","icon":"","iconStyle":"image","title":"每日听闻","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":0,"forumId":0,"moduleId":12,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"","orderby":"","order":0,"redirect":"http://forum.longquanzs.org/forum.php?mod=viewthread&tid=52635","listTitleLength":40,"listSummaryLength":0,"listImagePosition":2,"subListStyle":"","subDetailViewStyle":"","listBoardNameState":0},"id":"c203","componentList":[]},{"px":0,"type":"empty","style":"flat","icon":"","iconStyle":"image","title":"感悟人生目录","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":0,"forumId":0,"moduleId":13,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"","orderby":"","order":0,"redirect":"","listTitleLength":40,"listSummaryLength":0,"listImagePosition":2,"subListStyle":"","subDetailViewStyle":"","listBoardNameState":0},"id":"c204","componentList":[]},{"px":0,"type":"webapp","style":"flat","icon":"","iconStyle":"image","title":"广论目录","desc":"","extParams":{"dataId":0,"titlePosition":"left","newsModuleId":0,"forumId":0,"moduleId":13,"topicId":0,"articleId":0,"fastpostForumIds":[],"isShowTopicTitle":1,"isShowMessagelist":0,"filterId":0,"talkId":0,"filter":"","orderby":"","order":0,"redirect":"http://lq549.net/test2/glml.html?1&9&23&32&54&71","listTitleLength":40,"listSummaryLength":0,"listImagePosition":2,"subListStyle":"","subDetailViewStyle":"","listBoardNameState":0},"id":"c205","componentList":[]}]}]
     */

    private BodyBean body;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public List<NavItemListBean> getNaviList() {
        if (body == null) return Collections.EMPTY_LIST;
        List<NavItemListBean>  beanList = getBody().getNavigation().getNavItemList();
        return beanList;
    }

    public List<ComponentListBean> getSubComponentList(int pos) {
        int id = getNaviList().get(pos).getModuleId();
        for (ModuleListBean bean : getBody().getModuleList()) {
            if (bean.getId() == id) {
                return bean.getComponentList();
            }
        }
        return Collections.EMPTY_LIST;
    }


    public static class BodyBean {
        /**
         * type : bottom
         * navItemList : [{"icon":"mc_forum_main_bar_button1","title":"首页","moduleId":6},{"icon":"mc_forum_main_bar_button29","title":"论坛","moduleId":4},{"icon":"mc_forum_main_bar_button17","title":"发帖","moduleId":2},{"icon":"mc_forum_main_bar_button5","title":"发现","moduleId":8},{"icon":"mc_forum_main_bar_button26","title":"我的","moduleId":1}]
         */

        private NavigationBean navigation;
        /**
         * id : 1
         * icon : http://forum.longquanzs.org/mobcent/app/web/images/admin/module-default.png
         * title : 我的
         * extParams : {"padding":""}
         * style : flat
         * rightTopbars : []
         * leftTopbars : []
         * type : full
         * versionNum : 1.0
         * componentList : [{"id":"c10","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"discover","componentList":[{"id":"c5","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"discoverSlider","type":"layout","componentList":[]},{"id":"c8","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"discoverDefault","type":"layout","componentList":[{"id":"c6","iconStyle":"image","icon":"mc_forum_squre_icon9","title":"个人中心","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"isHidden":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"userinfo","componentList":[]},{"id":"c7","iconStyle":"image","icon":"mc_forum_squre_icon7","title":"设置","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"isHidden":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"setting","componentList":[]}]},{"id":"c9","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"discoverCustom","type":"layout","componentList":[]}]}]
         */

        private List<ModuleListBean> moduleList;

        public NavigationBean getNavigation() {
            return navigation;
        }

        public void setNavigation(NavigationBean navigation) {
            this.navigation = navigation;
        }

        public List<ModuleListBean> getModuleList() {
            return moduleList;
        }

        public void setModuleList(List<ModuleListBean> moduleList) {
            this.moduleList = moduleList;
        }

    }

    public static class NavigationBean {
        private String type;
        /**
         * icon : mc_forum_main_bar_button1
         * title : 首页
         * moduleId : 6
         */

        private List<NavItemListBean> navItemList;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<NavItemListBean> getNavItemList() {
            return navItemList;
        }

        public void setNavItemList(List<NavItemListBean> navItemList) {
            this.navItemList = navItemList;
        }

    }

    public static class NavItemListBean {
        private String icon;
        private String title;
        private int moduleId;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getModuleId() {
            return moduleId;
        }

        public void setModuleId(int moduleId) {
            this.moduleId = moduleId;
        }
    }

    public static class ModuleListBean {
        private int id;
        private String icon;
        private String title;
        /**
         * padding :
         */

        private ExtParamsBean extParams;
        private String style;
        private String type;
        private String versionNum;
        /**
         * id : c10
         * iconStyle : image
         * icon :
         * title :
         * desc :
         * px : 0
         * extParams : {"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""}
         * style : flat
         * type : discover
         * componentList : [{"id":"c5","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"discoverSlider","type":"layout","componentList":[]},{"id":"c8","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"discoverDefault","type":"layout","componentList":[{"id":"c6","iconStyle":"image","icon":"mc_forum_squre_icon9","title":"个人中心","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"isHidden":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"userinfo","componentList":[]},{"id":"c7","iconStyle":"image","icon":"mc_forum_squre_icon7","title":"设置","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"isHidden":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"flat","type":"setting","componentList":[]}]},{"id":"c9","iconStyle":"image","icon":"","title":"","desc":"","px":0,"extParams":{"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""},"style":"discoverCustom","type":"layout","componentList":[]}]
         */

        private List<ComponentListBean> componentList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public ExtParamsBean getExtParams() {
            return extParams;
        }

        public void setExtParams(ExtParamsBean extParams) {
            this.extParams = extParams;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVersionNum() {
            return versionNum;
        }

        public void setVersionNum(String versionNum) {
            this.versionNum = versionNum;
        }

        public List<ComponentListBean> getComponentList() {
            return componentList;
        }

        public void setComponentList(List<ComponentListBean> componentList) {
            this.componentList = componentList;
        }

        public static class ExtParamsBean {
        }

    }

    public static class ComponentListBean {
        private String id;
        private String iconStyle;
        private String icon;
        private String title;
        private String desc;
        private int px;
        /**
         * fastpostForumIds : []
         * moduleId : 0
         * dataId : 0
         * titlePosition : left
         * subListStyle : flat
         * listTitleLength : 40
         * listSummaryLength : 40
         * newsModuleId : 0
         * articleId : 0
         * subDetailViewStyle : flat
         * order : 0
         * filterId : 0
         * forumId : 0
         * pageTitle :
         * topicId : 0
         * redirect :
         * orderby :
         * isShowTopicTitle : 1
         * isShowMessagelist : 0
         * listImagePosition : 2
         * filter :
         */

        private ExtParamsBean extParams;
        private String style;
        private String type;
        /**
         * id : c5
         * iconStyle : image
         * icon :
         * title :
         * desc :
         * px : 0
         * extParams : {"fastpostForumIds":[],"moduleId":0,"dataId":0,"titlePosition":"left","subListStyle":"flat","listTitleLength":40,"listSummaryLength":40,"newsModuleId":0,"articleId":0,"subDetailViewStyle":"flat","order":0,"filterId":0,"forumId":0,"pageTitle":"","topicId":0,"redirect":"","orderby":"","isShowTopicTitle":1,"isShowMessagelist":0,"listImagePosition":2,"filter":""}
         * style : discoverSlider
         * type : layout
         * componentList : []
         */

        private List<ComponentListBean> componentList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIconStyle() {
            return iconStyle;
        }

        public void setIconStyle(String iconStyle) {
            this.iconStyle = iconStyle;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getPx() {
            return px;
        }

        public void setPx(int px) {
            this.px = px;
        }

        public ExtParamsBean getExtParams() {
            return extParams;
        }

        public void setExtParams(ExtParamsBean extParams) {
            this.extParams = extParams;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ComponentListBean> getComponentList() {
            return componentList;
        }

        public void setComponentList(List<ComponentListBean> componentList) {
            this.componentList = componentList;
        }

        public static class ExtParamsBean {
            private int moduleId;
            private int dataId;
            private String titlePosition;
            private String subListStyle;
            private int listTitleLength;
            private int listSummaryLength;
            private int newsModuleId;
            private int articleId;
            private String subDetailViewStyle;
            private int order;
            private int filterId;
            private int forumId;
            private String pageTitle;
            private int topicId;
            private String redirect;
            private String orderby;
            private int isShowTopicTitle;
            private int isShowMessagelist;
            private int listImagePosition;
            private String filter;
            private List<?> fastpostForumIds;

            public int getModuleId() {
                return moduleId;
            }

            public void setModuleId(int moduleId) {
                this.moduleId = moduleId;
            }

            public int getDataId() {
                return dataId;
            }

            public void setDataId(int dataId) {
                this.dataId = dataId;
            }

            public String getTitlePosition() {
                return titlePosition;
            }

            public void setTitlePosition(String titlePosition) {
                this.titlePosition = titlePosition;
            }

            public String getSubListStyle() {
                return subListStyle;
            }

            public void setSubListStyle(String subListStyle) {
                this.subListStyle = subListStyle;
            }

            public int getListTitleLength() {
                return listTitleLength;
            }

            public void setListTitleLength(int listTitleLength) {
                this.listTitleLength = listTitleLength;
            }

            public int getListSummaryLength() {
                return listSummaryLength;
            }

            public void setListSummaryLength(int listSummaryLength) {
                this.listSummaryLength = listSummaryLength;
            }

            public int getNewsModuleId() {
                return newsModuleId;
            }

            public void setNewsModuleId(int newsModuleId) {
                this.newsModuleId = newsModuleId;
            }

            public int getArticleId() {
                return articleId;
            }

            public void setArticleId(int articleId) {
                this.articleId = articleId;
            }

            public String getSubDetailViewStyle() {
                return subDetailViewStyle;
            }

            public void setSubDetailViewStyle(String subDetailViewStyle) {
                this.subDetailViewStyle = subDetailViewStyle;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getFilterId() {
                return filterId;
            }

            public void setFilterId(int filterId) {
                this.filterId = filterId;
            }

            public int getForumId() {
                return forumId;
            }

            public void setForumId(int forumId) {
                this.forumId = forumId;
            }

            public String getPageTitle() {
                return pageTitle;
            }

            public void setPageTitle(String pageTitle) {
                this.pageTitle = pageTitle;
            }

            public int getTopicId() {
                return topicId;
            }

            public void setTopicId(int topicId) {
                this.topicId = topicId;
            }

            public String getRedirect() {
                return redirect;
            }

            public void setRedirect(String redirect) {
                this.redirect = redirect;
            }

            public String getOrderby() {
                return orderby;
            }

            public void setOrderby(String orderby) {
                this.orderby = orderby;
            }

            public int getIsShowTopicTitle() {
                return isShowTopicTitle;
            }

            public void setIsShowTopicTitle(int isShowTopicTitle) {
                this.isShowTopicTitle = isShowTopicTitle;
            }

            public int getIsShowMessagelist() {
                return isShowMessagelist;
            }

            public void setIsShowMessagelist(int isShowMessagelist) {
                this.isShowMessagelist = isShowMessagelist;
            }

            public int getListImagePosition() {
                return listImagePosition;
            }

            public void setListImagePosition(int listImagePosition) {
                this.listImagePosition = listImagePosition;
            }

            public String getFilter() {
                return filter;
            }

            public void setFilter(String filter) {
                this.filter = filter;
            }

            public List<?> getFastpostForumIds() {
                return fastpostForumIds;
            }

            public void setFastpostForumIds(List<?> fastpostForumIds) {
                this.fastpostForumIds = fastpostForumIds;
            }
        }

//                public static class ComponentListBean {
//                    private String id;
//                    private String iconStyle;
//                    private String icon;
//                    private String title;
//                    private String desc;
//                    private int px;
//                    /**
//                     * fastpostForumIds : []
//                     * moduleId : 0
//                     * dataId : 0
//                     * titlePosition : left
//                     * subListStyle : flat
//                     * listTitleLength : 40
//                     * listSummaryLength : 40
//                     * newsModuleId : 0
//                     * articleId : 0
//                     * subDetailViewStyle : flat
//                     * order : 0
//                     * filterId : 0
//                     * forumId : 0
//                     * pageTitle :
//                     * topicId : 0
//                     * redirect :
//                     * orderby :
//                     * isShowTopicTitle : 1
//                     * isShowMessagelist : 0
//                     * listImagePosition : 2
//                     * filter :
//                     */
//
//                    private ExtParamsBean extParams;
//                    private String style;
//                    private String type;
//
//                    public String getId() {
//                        return id;
//                    }
//
//                    public void setId(String id) {
//                        this.id = id;
//                    }
//
//                    public String getIconStyle() {
//                        return iconStyle;
//                    }
//
//                    public void setIconStyle(String iconStyle) {
//                        this.iconStyle = iconStyle;
//                    }
//
//                    public String getIcon() {
//                        return icon;
//                    }
//
//                    public void setIcon(String icon) {
//                        this.icon = icon;
//                    }
//
//                    public String getTitle() {
//                        return title;
//                    }
//
//                    public void setTitle(String title) {
//                        this.title = title;
//                    }
//
//                    public String getDesc() {
//                        return desc;
//                    }
//
//                    public void setDesc(String desc) {
//                        this.desc = desc;
//                    }
//
//                    public int getPx() {
//                        return px;
//                    }
//
//                    public void setPx(int px) {
//                        this.px = px;
//                    }
//
//                    public ExtParamsBean getExtParams() {
//                        return extParams;
//                    }
//
//                    public void setExtParams(ExtParamsBean extParams) {
//                        this.extParams = extParams;
//                    }
//
//                    public String getStyle() {
//                        return style;
//                    }
//
//                    public void setStyle(String style) {
//                        this.style = style;
//                    }
//
//                    public String getType() {
//                        return type;
//                    }
//
//                    public void setType(String type) {
//                        this.type = type;
//                    }
//
//                    public static class ExtParamsBean {
//                        private int moduleId;
//                        private int dataId;
//                        private String titlePosition;
//                        private String subListStyle;
//                        private int listTitleLength;
//                        private int listSummaryLength;
//                        private int newsModuleId;
//                        private int articleId;
//                        private String subDetailViewStyle;
//                        private int order;
//                        private int filterId;
//                        private int forumId;
//                        private String pageTitle;
//                        private int topicId;
//                        private String redirect;
//                        private String orderby;
//                        private int isShowTopicTitle;
//                        private int isShowMessagelist;
//                        private int listImagePosition;
//                        private String filter;
//                        private List<?> fastpostForumIds;
//
//                        public int getModuleId() {
//                            return moduleId;
//                        }
//
//                        public void setModuleId(int moduleId) {
//                            this.moduleId = moduleId;
//                        }
//
//                        public int getDataId() {
//                            return dataId;
//                        }
//
//                        public void setDataId(int dataId) {
//                            this.dataId = dataId;
//                        }
//
//                        public String getTitlePosition() {
//                            return titlePosition;
//                        }
//
//                        public void setTitlePosition(String titlePosition) {
//                            this.titlePosition = titlePosition;
//                        }
//
//                        public String getSubListStyle() {
//                            return subListStyle;
//                        }
//
//                        public void setSubListStyle(String subListStyle) {
//                            this.subListStyle = subListStyle;
//                        }
//
//                        public int getListTitleLength() {
//                            return listTitleLength;
//                        }
//
//                        public void setListTitleLength(int listTitleLength) {
//                            this.listTitleLength = listTitleLength;
//                        }
//
//                        public int getListSummaryLength() {
//                            return listSummaryLength;
//                        }
//
//                        public void setListSummaryLength(int listSummaryLength) {
//                            this.listSummaryLength = listSummaryLength;
//                        }
//
//                        public int getNewsModuleId() {
//                            return newsModuleId;
//                        }
//
//                        public void setNewsModuleId(int newsModuleId) {
//                            this.newsModuleId = newsModuleId;
//                        }
//
//                        public int getArticleId() {
//                            return articleId;
//                        }
//
//                        public void setArticleId(int articleId) {
//                            this.articleId = articleId;
//                        }
//
//                        public String getSubDetailViewStyle() {
//                            return subDetailViewStyle;
//                        }
//
//                        public void setSubDetailViewStyle(String subDetailViewStyle) {
//                            this.subDetailViewStyle = subDetailViewStyle;
//                        }
//
//                        public int getOrder() {
//                            return order;
//                        }
//
//                        public void setOrder(int order) {
//                            this.order = order;
//                        }
//
//                        public int getFilterId() {
//                            return filterId;
//                        }
//
//                        public void setFilterId(int filterId) {
//                            this.filterId = filterId;
//                        }
//
//                        public int getForumId() {
//                            return forumId;
//                        }
//
//                        public void setForumId(int forumId) {
//                            this.forumId = forumId;
//                        }
//
//                        public String getPageTitle() {
//                            return pageTitle;
//                        }
//
//                        public void setPageTitle(String pageTitle) {
//                            this.pageTitle = pageTitle;
//                        }
//
//                        public int getTopicId() {
//                            return topicId;
//                        }
//
//                        public void setTopicId(int topicId) {
//                            this.topicId = topicId;
//                        }
//
//                        public String getRedirect() {
//                            return redirect;
//                        }
//
//                        public void setRedirect(String redirect) {
//                            this.redirect = redirect;
//                        }
//
//                        public String getOrderby() {
//                            return orderby;
//                        }
//
//                        public void setOrderby(String orderby) {
//                            this.orderby = orderby;
//                        }
//
//                        public int getIsShowTopicTitle() {
//                            return isShowTopicTitle;
//                        }
//
//                        public void setIsShowTopicTitle(int isShowTopicTitle) {
//                            this.isShowTopicTitle = isShowTopicTitle;
//                        }
//
//                        public int getIsShowMessagelist() {
//                            return isShowMessagelist;
//                        }
//
//                        public void setIsShowMessagelist(int isShowMessagelist) {
//                            this.isShowMessagelist = isShowMessagelist;
//                        }
//
//                        public int getListImagePosition() {
//                            return listImagePosition;
//                        }
//
//                        public void setListImagePosition(int listImagePosition) {
//                            this.listImagePosition = listImagePosition;
//                        }
//
//                        public String getFilter() {
//                            return filter;
//                        }
//
//                        public void setFilter(String filter) {
//                            this.filter = filter;
//                        }
//
//                        public List<?> getFastpostForumIds() {
//                            return fastpostForumIds;
//                        }
//
//                        public void setFastpostForumIds(List<?> fastpostForumIds) {
//                            this.fastpostForumIds = fastpostForumIds;
//                        }
//                    }
//                }
    }
}
