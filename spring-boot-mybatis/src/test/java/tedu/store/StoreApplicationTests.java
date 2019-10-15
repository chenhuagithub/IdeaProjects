package tedu.store;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

    @Autowired
    public DataSource dataSource;

    @Test
    public void contextLoads() {
        //数据库连接
        try {
            Connection conn = dataSource.getConnection();
            System.err.println(conn);


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
