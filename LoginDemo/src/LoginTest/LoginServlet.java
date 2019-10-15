package LoginTest;
import Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet控制台
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("UTF-8");
        //2.获取用户名密码
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
       // System.out.println("loginName:" + loginName + "  " + "loginPwd:" + loginPwd);
        //2.创建user对象并赋值
        User user = new User();
        user.setLoginName(loginName);
        user.setLoginPwd(loginPwd);

       System.out.println(loginName);

        //3.创建UserDao对象，调用登陆方法并传入user对象 判断返回值是否为空
        UserDao ud = new UserDao();

        User us = ud.login(user);
        if(us != null){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
