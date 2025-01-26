package sn.api.gestionauchanspring.web.dto.response;

public class Response {
    private String status;
    private String type;
    private Object data;

    public Response(String status, String type, Object data) {
        this.status = status;
        this.type = type;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
