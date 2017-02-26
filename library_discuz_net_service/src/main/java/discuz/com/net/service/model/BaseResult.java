package discuz.com.net.service.model;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class BaseResult<T> {

    //以下四类是通用的返回结果,body代表返回的对象
    //如果有其他的返回结果,请继承BaseResult<T>重新写一个返回类
    private Integer rs;
    private String errCode;
    private BaseResultHead head;
    private T body;

    public Integer getRs() {
        return rs;
    }

    public void setRs(Integer rs) {
        this.rs = rs;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public BaseResultHead getHead() {
        return head;
    }

    public void setHead(BaseResultHead head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
