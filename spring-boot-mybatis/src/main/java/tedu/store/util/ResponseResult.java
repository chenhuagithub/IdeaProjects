package tedu.store.util;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -5368505763231357265L;

    private int state;
    private String message;
    private T data;

    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer state) {
        super();
        this.state = state;
    }

    public ResponseResult(Integer state, T data) {
        super();
        this.state = state;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
    }

    // SET/GET

}