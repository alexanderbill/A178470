package com.mobcent.discuz.bean;

/**
 * Created by sun on 2016/9/14.
 * 版块 分类
 */
public class ClassificationTypeListBean {
    private int classificationType_id;
    private String classificationType_name;

    public static ClassificationTypeListBean init() {
        ClassificationTypeListBean bean = new ClassificationTypeListBean();
        bean.classificationType_id = 0;
        bean.classificationType_name = "全部";
        return bean;
    }

    public int getClassificationType_id() {
        return classificationType_id;
    }

    public void setClassificationType_id(int classificationType_id) {
        this.classificationType_id = classificationType_id;
    }

    public String getClassificationType_name() {
        return classificationType_name;
    }

    public void setClassificationType_name(String classificationType_name) {
        this.classificationType_name = classificationType_name;
    }
}
