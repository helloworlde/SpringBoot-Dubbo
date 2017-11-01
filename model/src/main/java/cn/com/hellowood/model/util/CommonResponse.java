package cn.com.hellowood.model.util;

/**
 * @author HelloWood
 **/
public class CommonResponse {
    private int code;

    private String message;

    private Object data;

    public int getCode() {
        return code;
    }

    public CommonResponse setCode(HttpStatus status) {
        this.code = status.code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonResponse setData(Object data) {
        this.data = data;
        return this;
    }
}
