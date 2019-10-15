package Test;

import Dao.JDBCUtils;
import Dao.UserDao;
import LoginTest.User;

import javax.sql.DataSource;

public class LoginTest1 {
    public static void main(String[] args) {
        User user = new User();
        UserDao ud = new UserDao();
        user.setLoginName("liangzhiying");
        user.setLoginPwd("222");
        User user1 = ud.login(user);
        if(user1 != null){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }
}
