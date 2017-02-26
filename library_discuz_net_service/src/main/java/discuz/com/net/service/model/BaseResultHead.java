package discuz.com.net.service.model;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class BaseResultHead {

    private String errCode;
    private String errInfo;
    private String version;
    private Integer alert;
    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrInfo() {
        return errInfo;
    }

    public void setErrInfo(String errInfo) {
        this.errInfo = errInfo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getAlert() {
        return alert;
    }

    public void setAlert(Integer alert) {
        this.alert = alert;
    }
}
