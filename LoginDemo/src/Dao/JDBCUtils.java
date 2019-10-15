package Dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类
 * 作用：获取连接
 *       获取连接池
 *       回收资源
 */
public class JDBCUtils {
    //1.定义成员变量
    private static DataSource ds;
    static{
        //2.加载配置文件
        Properties pro = new Properties();
        try {
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("file/druid.properties"));
            //3.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 静态代码块获取连接
     * @return Connection
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(ResultSet rs, Statement stmt,Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 释放资源：重载方法
     */
    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);
    }

    /**
     * 获取连接池
     */
    public static DataSource getDs(){
        return ds;
    }
}
