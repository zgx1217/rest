package aaa.tenancy.common;

/**
 * 默认的返回结果
 */
public class DefaultMsg {

    private Integer success=1;
    private String error=null;

    public DefaultMsg(Integer success, String error){
        this.success=success;
        this.error=error;
    }
    public DefaultMsg(String error){
        this.success=0;
        this.error=error;
    }

    public DefaultMsg(){}

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
