package tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;


import tedu.store.util.ResponseResult;

/**
 * 控制器类的基类
 */
public abstract class BaseController {

    /**
     * 响应结果的状态：成功
     */
    public static final Integer SUCCESS = 200;

    /**
     * 从Session获取当前登录的用户id
     *
     * @param session HttpSession对象
     * @return 当前登录的用户id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 统一处理异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResponseResult<Void> handleException(Throwable e) {
        ResponseResult<Void> rr
                = new ResponseResult<>();
        rr.setMessage(e.getMessage());


        return rr;
    }

}
