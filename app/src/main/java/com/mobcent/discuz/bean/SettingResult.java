package com.mobcent.discuz.bean;

import java.util.List;

/**
 * Created by sun on 2016/9/14.
 * 全局设置
 */

public class SettingResult extends BaseResult{

    /**
     * postInfo : [{"fid":516,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":107,"classificationType_name":"早斋开示"},{"classificationType_id":160,"classificationType_name":"感悟人生"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":259,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":51,"classificationType_name":"仁爱慈善"},{"classificationType_id":52,"classificationType_name":"老年关怀"},{"classificationType_id":53,"classificationType_name":"仁爱心栈"},{"classificationType_id":54,"classificationType_name":"仁爱助学"},{"classificationType_id":137,"classificationType_name":"倾听热线"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":301,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":147,"classificationType_name":"学修心得"},{"classificationType_id":148,"classificationType_name":"定课统计"},{"classificationType_id":149,"classificationType_name":"观功念恩日记"},{"classificationType_id":150,"classificationType_name":"承担心得"},{"classificationType_id":151,"classificationType_name":"小组活动"},{"classificationType_id":154,"classificationType_name":"佛学知识"},{"classificationType_id":155,"classificationType_name":"原创天地"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":536,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":171,"classificationType_name":"素食心得"},{"classificationType_id":172,"classificationType_name":"健康食谱"},{"classificationType_id":173,"classificationType_name":"知识连载"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":319,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":73,"classificationType_name":"妙音艺术"},{"classificationType_id":74,"classificationType_name":"网络电台"},{"classificationType_id":75,"classificationType_name":"音乐欣赏"},{"classificationType_id":76,"classificationType_name":"其他"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":320,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":65,"classificationType_name":"菩提印象"},{"classificationType_id":66,"classificationType_name":"手机摄影"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":518,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":348,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":20,"classificationType_name":"原创"},{"classificationType_id":21,"classificationType_name":"转载"},{"classificationType_id":86,"classificationType_name":"问题求助"},{"classificationType_id":90,"classificationType_name":"听师父话日记"},{"classificationType_id":29,"classificationType_name":"家庭职场"},{"classificationType_id":30,"classificationType_name":"佛化生活"},{"classificationType_id":32,"classificationType_name":"素食与护生"},{"classificationType_id":33,"classificationType_name":"万缘茶棚"},{"classificationType_id":28,"classificationType_name":"比丘记事"},{"classificationType_id":22,"classificationType_name":"其他"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":352,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":84,"classificationType_name":"义工"},{"classificationType_id":83,"classificationType_name":"活动"},{"classificationType_id":85,"classificationType_name":"精彩分享"},{"classificationType_id":93,"classificationType_name":"其他"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":368,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":506,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":510,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":142,"classificationType_name":"4G龙泉"},{"classificationType_id":175,"classificationType_name":"直播吧"},{"classificationType_id":176,"classificationType_name":"法会活动"}],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":394,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":81,"classificationType_name":"学诚法师答疑"},{"classificationType_id":1,"classificationType_name":"师父微博法语"},{"classificationType_id":27,"classificationType_name":"师父博客留言"},{"classificationType_id":140,"classificationType_name":"解惑集"},{"classificationType_id":89,"classificationType_name":"提问"},{"classificationType_id":82,"classificationType_name":"其他"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":504,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":157,"classificationType_name":"新书资讯"},{"classificationType_id":156,"classificationType_name":"读书笔记"},{"classificationType_id":158,"classificationType_name":"龙泉书评"},{"classificationType_id":159,"classificationType_name":"好书推荐"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":407,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":492,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":112,"classificationType_name":"善行日记"}],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":416,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":141,"classificationType_name":"观功念恩"}],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":454,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":449,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":428,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":44,"classificationType_name":"贤二动漫"},{"classificationType_id":45,"classificationType_name":"贤二出版"},{"classificationType_id":46,"classificationType_name":"贤二机器僧"},{"classificationType_id":115,"classificationType_name":"贤二禅艺"},{"classificationType_id":116,"classificationType_name":"贤二招募"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":434,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":47,"classificationType_name":"学诚大和尚佛法国际化理念"},{"classificationType_id":48,"classificationType_name":"多语种翻译"},{"classificationType_id":49,"classificationType_name":"多语种法会"},{"classificationType_id":50,"classificationType_name":"多语种教育"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":520,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":130,"classificationType_name":"藏经公告"},{"classificationType_id":131,"classificationType_name":"藏经资讯"},{"classificationType_id":132,"classificationType_name":"活动培训"},{"classificationType_id":133,"classificationType_name":"互动答疑"},{"classificationType_id":134,"classificationType_name":"总结分享"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":447,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":453,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":467,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":468,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":469,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":470,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":471,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":472,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":473,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":474,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":475,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":476,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":478,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":479,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":521,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":128,"classificationType_name":"感悟人生"},{"classificationType_id":129,"classificationType_name":"广论第一单元"},{"classificationType_id":177,"classificationType_name":"广论第二单元"},{"classificationType_id":178,"classificationType_name":"广论第三单元"},{"classificationType_id":179,"classificationType_name":"广论第四单元"},{"classificationType_id":180,"classificationType_name":"广论第五单元"},{"classificationType_id":181,"classificationType_name":"广论第六单元"},{"classificationType_id":182,"classificationType_name":"广论第七单元"},{"classificationType_id":183,"classificationType_name":"广论第八单元"},{"classificationType_id":184,"classificationType_name":"广论第九单元"}],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":509,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":512,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":503,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":113,"classificationType_name":"教化部骨干义工"},{"classificationType_id":11,"classificationType_name":"总结分享"},{"classificationType_id":12,"classificationType_name":"其他"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":489,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":77,"classificationType_name":"意见建议"},{"classificationType_id":78,"classificationType_name":"通知公告"},{"classificationType_id":79,"classificationType_name":"新手上路"},{"classificationType_id":80,"classificationType_name":"其他"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":490,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":496,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":70,"classificationType_name":"在线作业"},{"classificationType_id":71,"classificationType_name":"在线共修"},{"classificationType_id":69,"classificationType_name":"课程表"},{"classificationType_id":87,"classificationType_name":"学员共修分享"},{"classificationType_id":92,"classificationType_name":"其他"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":505,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":511,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":164,"classificationType_name":"莆田广化寺"},{"classificationType_id":135,"classificationType_name":"大德故事"},{"classificationType_id":136,"classificationType_name":"资讯"},{"classificationType_id":165,"classificationType_name":"仙游极乐寺"},{"classificationType_id":166,"classificationType_name":"莆田南少林寺"},{"classificationType_id":167,"classificationType_name":"扶风法门寺"},{"classificationType_id":168,"classificationType_name":"福清崇恩禅寺"},{"classificationType_id":169,"classificationType_name":"荷兰龙泉大悲寺"},{"classificationType_id":170,"classificationType_name":"博茨瓦纳博华寺"}],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":502,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":34,"classificationType_name":"文化部"},{"classificationType_id":35,"classificationType_name":"慈善部"},{"classificationType_id":36,"classificationType_name":"工程部"},{"classificationType_id":37,"classificationType_name":"教化部"},{"classificationType_id":38,"classificationType_name":"客堂"},{"classificationType_id":39,"classificationType_name":"信息中心"},{"classificationType_id":40,"classificationType_name":"图书馆"},{"classificationType_id":41,"classificationType_name":"弘宣部"},{"classificationType_id":42,"classificationType_name":"翻译中心"},{"classificationType_id":43,"classificationType_name":"法会之窗"},{"classificationType_id":127,"classificationType_name":"藏经办"},{"classificationType_id":126,"classificationType_name":"动漫中心"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":513,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":185,"classificationType_name":"三宝物"},{"classificationType_id":186,"classificationType_name":"生活用品"},{"classificationType_id":187,"classificationType_name":"电子产品"},{"classificationType_id":188,"classificationType_name":"交通工具"},{"classificationType_id":189,"classificationType_name":"健身器材"},{"classificationType_id":190,"classificationType_name":"服装箱包"},{"classificationType_id":191,"classificationType_name":"图书音像"}],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":523,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":524,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":94,"classificationType_name":"禅兴法师"},{"classificationType_id":95,"classificationType_name":"贤书法师"},{"classificationType_id":96,"classificationType_name":"贤启法师"},{"classificationType_id":97,"classificationType_name":"贤清法师"},{"classificationType_id":98,"classificationType_name":"贤双法师"},{"classificationType_id":99,"classificationType_name":"贤颂法师"},{"classificationType_id":100,"classificationType_name":"悟光法师"},{"classificationType_id":101,"classificationType_name":"贤立法师"},{"classificationType_id":102,"classificationType_name":"贤健法师"},{"classificationType_id":103,"classificationType_name":"贤因法师"},{"classificationType_id":104,"classificationType_name":"其他开示"},{"classificationType_id":105,"classificationType_name":"贤睦法师"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":527,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":534,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":138,"classificationType_name":"善行分享接龙"},{"classificationType_id":139,"classificationType_name":"贤瓜善行漫画"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":535,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":537,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":143,"classificationType_name":"活动采风"},{"classificationType_id":144,"classificationType_name":"心得故事"},{"classificationType_id":145,"classificationType_name":"网络共修"},{"classificationType_id":146,"classificationType_name":"善行分享"},{"classificationType_id":161,"classificationType_name":"京外参访"}],"isOnlyTopicType":1},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}},{"fid":538,"topic":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":162,"classificationType_name":"见闻觉知 同师共学"},{"classificationType_id":174,"classificationType_name":"师父动态"}],"isOnlyTopicType":0},"post":{"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}}]
     * serverTime : 1473853707000
     * misc : {"weather":{"allowUsage":0,"allowCityQuery":0}}
     * plugin : {"qqconnect":1,"dsu_paulsign":0,"wxconnect":0,"isMobileRegisterValidation":0,"isInviteActivity":0,"activityId":0,"isFastRegister":0,"isCustomUserSetting":0,"userSettingUrl":"","isCloseEmail":0,"aboutUrl":"","threadTemplate":[{"id":127,"url":"http://forum.longquanzs.org/forum.php?mod=viewthread&tid={tid}"}],"foundUrl":"","webviewTopbarMore":1,"gotye":0,"changeMobile":0,"privacyUrl":"","isQQSdk":0}
     * forum : {"isSummaryShow":1,"isTodayPostCount":1,"postlistOrderby":0,"postAudioLimit":-1,"isShowLocationTopic":0,"isShowLocationPost":0}
     * portal : {"isSummaryShow":1}
     * user : {"allowAt":0,"allowRegister":1,"wapRegisterUrl":"","maxSignSize":280,"shareActivity":{"status":0},"search":{"topic":1,"portal":0,"user":1},"verify":0}
     * message : {"pmAudioLimit":-1,"allowPostImage":1}
     * moduleList : [{"moduleId":6,"moduleName":"测试"},{"moduleId":8,"moduleName":"ceshi"},{"moduleId":9,"moduleName":"聚焦龙泉&银杏树下"},{"moduleId":1,"moduleName":"龙泉视界"},{"moduleId":2,"moduleName":"仁爱慈善"},{"moduleId":3,"moduleName":"龙泉动漫"}]
     * topicVerify : 0
     * hideTpcTitle : 0
     */

    private BodyBean body;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        private String serverTime;
        /**
         * isSummaryShow : 1
         * isTodayPostCount : 1
         * postlistOrderby : 0
         * postAudioLimit : -1
         * isShowLocationTopic : 0
         * isShowLocationPost : 0
         */

        private ForumBean forum;
        private int topicVerify;
        /**
         * fid : 516
         * topic : {"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1,"newTopicPanel":[{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}],"classificationType_list":[{"classificationType_id":107,"classificationType_name":"早斋开示"},{"classificationType_id":160,"classificationType_name":"感悟人生"}],"isOnlyTopicType":1}
         * post : {"isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"allowPostAttachment":1,"allowPostImage":1}
         */

        private List<PostInfoBean> postInfo;

        public String getServerTime() {
            return serverTime;
        }

        public void setServerTime(String serverTime) {
            this.serverTime = serverTime;
        }

        public ForumBean getForum() {
            return forum;
        }

        public void setForum(ForumBean forum) {
            this.forum = forum;
        }

        public int getTopicVerify() {
            return topicVerify;
        }

        public void setTopicVerify(int topicVerify) {
            this.topicVerify = topicVerify;
        }

        public List<PostInfoBean> getPostInfo() {
            return postInfo;
        }

        public void setPostInfo(List<PostInfoBean> postInfo) {
            this.postInfo = postInfo;
        }

        public static class ForumBean {
        }

        public static class PostInfoBean {
            private int fid;
            /**
             * isHidden : 0
             * isAnonymous : 0
             * isOnlyAuthor : 0
             * allowPostAttachment : 1
             * allowPostImage : 1
             * newTopicPanel : [{"type":"normal","action":"","title":"发表帖子"},{"type":"vote","action":"","title":"发起投票"}]
             * classificationType_list : [{"classificationType_id":107,"classificationType_name":"早斋开示"},{"classificationType_id":160,"classificationType_name":"感悟人生"}]
             * isOnlyTopicType : 1
             */

            private TopicBean topic;
            /**
             * isHidden : 0
             * isAnonymous : 0
             * isOnlyAuthor : 0
             * allowPostAttachment : 1
             * allowPostImage : 1
             */

            private PostBean post;

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public TopicBean getTopic() {
                return topic;
            }

            public void setTopic(TopicBean topic) {
                this.topic = topic;
            }

            public PostBean getPost() {
                return post;
            }

            public void setPost(PostBean post) {
                this.post = post;
            }


        }
    }

    public static class PostBean {
        private int isHidden;
        private int isAnonymous;
        private int isOnlyAuthor;
        private int allowPostAttachment;
        private int allowPostImage;

        public int getIsHidden() {
            return isHidden;
        }

        public void setIsHidden(int isHidden) {
            this.isHidden = isHidden;
        }

        public int getIsAnonymous() {
            return isAnonymous;
        }

        public void setIsAnonymous(int isAnonymous) {
            this.isAnonymous = isAnonymous;
        }

        public int getIsOnlyAuthor() {
            return isOnlyAuthor;
        }

        public void setIsOnlyAuthor(int isOnlyAuthor) {
            this.isOnlyAuthor = isOnlyAuthor;
        }

        public int getAllowPostAttachment() {
            return allowPostAttachment;
        }

        public void setAllowPostAttachment(int allowPostAttachment) {
            this.allowPostAttachment = allowPostAttachment;
        }

        public int getAllowPostImage() {
            return allowPostImage;
        }

        public void setAllowPostImage(int allowPostImage) {
            this.allowPostImage = allowPostImage;
        }
    }

    public static class TopicBean {
        private int isHidden;
        private int isAnonymous;
        private int isOnlyAuthor;
        private int allowPostAttachment;
        private int allowPostImage;
        private int isOnlyTopicType;
        /**
         * type : normal
         * action :
         * title : 发表帖子
         */

        private List<NewTopicPanelBean> newTopicPanel;
        /**
         * classificationType_id : 107
         * classificationType_name : 早斋开示
         */

        private List<ClassificationTypeListBean> classificationType_list;

        public int getIsHidden() {
            return isHidden;
        }

        public void setIsHidden(int isHidden) {
            this.isHidden = isHidden;
        }

        public int getIsAnonymous() {
            return isAnonymous;
        }

        public void setIsAnonymous(int isAnonymous) {
            this.isAnonymous = isAnonymous;
        }

        public int getIsOnlyAuthor() {
            return isOnlyAuthor;
        }

        public void setIsOnlyAuthor(int isOnlyAuthor) {
            this.isOnlyAuthor = isOnlyAuthor;
        }

        public int getAllowPostAttachment() {
            return allowPostAttachment;
        }

        public void setAllowPostAttachment(int allowPostAttachment) {
            this.allowPostAttachment = allowPostAttachment;
        }

        public int getAllowPostImage() {
            return allowPostImage;
        }

        public void setAllowPostImage(int allowPostImage) {
            this.allowPostImage = allowPostImage;
        }

        public int getIsOnlyTopicType() {
            return isOnlyTopicType;
        }

        public void setIsOnlyTopicType(int isOnlyTopicType) {
            this.isOnlyTopicType = isOnlyTopicType;
        }

        public List<NewTopicPanelBean> getNewTopicPanel() {
            return newTopicPanel;
        }

        public void setNewTopicPanel(List<NewTopicPanelBean> newTopicPanel) {
            this.newTopicPanel = newTopicPanel;
        }

        public List<ClassificationTypeListBean> getClassificationType_list() {
            return classificationType_list;
        }

        public void setClassificationType_list(List<ClassificationTypeListBean> classificationType_list) {
            this.classificationType_list = classificationType_list;
        }

        public static class NewTopicPanelBean {
            private String type;
            private String action;
            private String title;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }

}
