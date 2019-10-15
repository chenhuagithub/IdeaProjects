package Dao;
import LoginTest.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * 对数据库操作的类
 */
public class UserDao {
    /**
     * 传一个带有用户名及密码的User对象
     * 判断返回值是否为空
     *      非空：登陆成功
     *        空：登陆失败
     * @param user
     * @return user
     */
    public static User login(User user) {
        try {
            System.out.println("我进来了！");
            //1.通过DataSource获取JdbcTemplate对象
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
            //2.定义sql
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";
            System.out.println("我进来了！");
            //3.给?赋值并执行
            //template.queryForObject(sql,new BeanPropertyRowMapper<User>
            //                (User.class),user.getLoginName(),user.getLoginPwd());期望返回值是1，
            //                                                                     若返回值为0则发生异常
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>
                    (User.class), user.getLoginName(), user.getLoginPwd());

            return user;
        }catch(Exception e){
            return null;
    }

    }
}
