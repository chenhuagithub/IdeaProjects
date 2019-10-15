package tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tedu.store.entity.User;
import tedu.store.service.IUserService;
import tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;


    @PostMapping("/reg")
    public ResponseResult<Void> reg(User user) {
        ResponseResult<Void> rr
                = new ResponseResult<Void>();


        try {
            userService.reg(user);
            rr.setState(200);
        } catch (Exception e) {
            rr.setState(100);
            rr.setMessage(e.getMessage());
        }
        return rr;


    }

    @PostMapping("/login")
    public ResponseResult<User> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session) throws Exception {
        ResponseResult<User> rr
                = new ResponseResult<User>();
        // 执行登录验证
        User data = userService.login(username, password);

        System.err.println(data.getUid());
        System.err.println(username);

        // 向Session中封装用户信息
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        try {
            User uu = userService.login(username, password);
            if (uu != null)
                rr.setState(200);
        } catch (Exception e) {
            rr.setState(100);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }

    @RequestMapping("/change_password")
    public ResponseResult<Void> changePassword(
            @RequestParam("old_password") String oldPassword,
            @RequestParam("new_password") String newPassword,
            HttpSession session) throws Exception {
        ResponseResult<Void> rr
                = new ResponseResult<Void>();
        // 从session中获取uid和username

        Integer uid = getUidFromSession(session);
        String username = session.getAttribute("username").toString();

        userService.changePassword(uid, username, oldPassword, newPassword);

        rr.setState(200);

        return rr;
    }

    @RequestMapping("/change_info")
    public ResponseResult<Void> changeInfo(User user, HttpSession session) throws Exception {
        // 封装uid
        Integer uid = getUidFromSession(session);
        user.setUid(uid);
        System.out.println(user);
        // 执行修改个人资料
        System.out.println(uid);
        userService.changeInfo(user);
        // 返回

        return new ResponseResult<>(SUCCESS);
    }

    @GetMapping("/info")
    public ResponseResult<User> getByUid(
            HttpSession session) throws Exception {
        // 获取uid
        Integer uid = getUidFromSession(session);
        // 查询用户数据
        User data = userService.getByUid(uid);
        // 返回
        return new ResponseResult<>(SUCCESS, data);
    }


}
