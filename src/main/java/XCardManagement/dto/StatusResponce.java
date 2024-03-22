package XCardManagement.dto;

public class StatusResponce {

    private int statusCode;
    private String msg ;

    private String status;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

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

    public StatusResponce(int statusCode, String msg, String status) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.status = status;
    }
}
