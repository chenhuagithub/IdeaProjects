package tedu.store.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {

    @Autowired
    public UserMapper mapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("root");
        user.setPassword("1234");
        Integer rows = mapper.insert(user);
        System.err.println("rows=" + rows);
    }
}
