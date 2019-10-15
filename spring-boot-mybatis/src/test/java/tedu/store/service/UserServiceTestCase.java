package tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {

    @Autowired
    public IUserService service;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("mybatis");
            user.setPassword("1234");
            user.setGender(1);
            user.setPhone("13800138006");
            user.setEmail("mybatis@tedu.cn");
            user.setAvatar("http://www.tedu.cn/mybatis.png");
            service.reg(user);
            System.err.println("OK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
