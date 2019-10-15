package LoginTest;
import Dao.UserDao;
public class test {
    public static void main(String[] args) {
        String loginName = "liangzhiying";
        String loginPwd = "112";
        User user = new User();
        user.setLoginName(loginName);
        user.setLoginPwd(loginPwd);
        System.out.println(user);
        //3.创建UserDao对象，调用登陆方法并传入user对象 判断返回值是否为空
        UserDao ud = new UserDao();

        User us = ud.login(user);
        if(us != null){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }
}
