package JDBC.template;

import JDBC.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * JDBCTemplate入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        JdbcTemplateDemo1 jt = new JdbcTemplateDemo1();
        //jt.test2();
        //jt.test3();
        //jt.test4();
        //jt.test5();
        //jt.test5_2();
        //jt.test6();
        //jt.test6_2();// 6.2查询所有记录，将其封装为User对象的List集合
        //jt.test7();
    }
    //1.导入jar包
    //2.创建JdbcTemplate对象
    public static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 1.修改
     */
    protected void test1(){
        //3.调用方法
        String sql = "update t_user set realName = '黄佩仪' where loginName = ?";
        int count = template.update(sql,"liangzhiying");
        System.out.println(count);
    }
    /**
     * 2.添加
     */
    public void test2(){
        String sql = "insert into t_user values(null,?,?,?)";
        int count = template.update(sql,"liangzhiying",123,"梁智盈");
        System.out.println(count);
    }
    /**
     * 3.删除刚才的记录
     */
    public void test3(){
        String sql = "delete from t_user where loginName = ?";
        int count = template.update(sql,"liangzhiying");
        System.out.println(count);
    }
    /**
     * 4.查询登录名为liangzhiying的记录，将其封装为Map集合
     * tip:Map存放只能有一条返回值
     * map = {标识=9, loginName=liangzhiying, loginPwd=111, realName=梁智盈}
     */
    public void test4(){
        String sql = "select * from t_user where loginName = ?";
        Map<String,Object> map = template.queryForMap(sql,"liangzhiying");
        System.out.println(map);
    }

    /**
     * 5.查询所有记录，将其封装为List
     */
    public void test5(){
        String sql = "select * from t_user";
        List<Map<String,Object>> list = template.queryForList(sql);
        for (Map<String,Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }
    public void test5_2(){
        String sql = "select * from t_user";
        List list = template.queryForList(sql);
        for (Object obj: list) {
            System.out.println(obj);
        }
    }
    /**
     * 6.查询所有记录，将其封装为User对象的List集合
     * RowMapper的作用未清楚
     * 该方法未起到简便的作用
     */
    public void test6(){
        String sql = "select * from t_user";
        List<User> list = template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                Integer id = rs.getInt("id");
                String loginName = rs.getString("loginName");
                String loginPwd = rs.getString("loginPwd");
                String realName = rs.getString("realName");

                user.setId(id);
                user.setLoginName(loginName);
                user.setLoginPwd(loginPwd);
                user.setRealName(realName);
                return user;
            }
        });
        for (User user : list) {
            System.out.println(user);
        }
    }
    /**
     * 6.2查询所有记录，将其封装为User对象的List集合
     */
    public void test6_2(){
        String sql = "select * from t_user";
        List<User> list = template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        for(User user : list){
            System.out.println(user);
        }
    }
    /**
     * 7.
     */
    public void test7(){
        String sql = "select count(id) from t_user";
        Long total = template.queryForObject(sql,Long.class);
        System.out.println(total);
    }
}
