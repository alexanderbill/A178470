package com.mobcent.discuz.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2016/10/14.
 * 回复时添加图片，上传返回结果
 */

public class UploadPicResult extends BaseResult {

    private BodyBean body;

    public BodyBean getBody() {
        return body;
    }

    public List<String> getImgUrls() {
        final List<String> imgs = new ArrayList<>();
        List<AttachmentBean> beanList = getBody().getAttachment();
        if (beanList != null) {
            for (AttachmentBean bean : beanList) {
                imgs.add(bean.getUrlName());
            }
        }
        return imgs;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * id : 156869
         * urlName : http://forum.longquanzs.org/data/attachment//forum/201610/14/125735kt4goboyr67aorco.jpg
         */

        private List<AttachmentBean> attachment;

        public List<AttachmentBean> getAttachment() {
            return attachment;
        }

        public void setAttachment(List<AttachmentBean> attachment) {
            this.attachment = attachment;
        }

    }

    public static class AttachmentBean {
        private int id;
        private String urlName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrlName() {
            return urlName;
        }

        public void setUrlName(String urlName) {
            this.urlName = urlName;
        }
    }
}
