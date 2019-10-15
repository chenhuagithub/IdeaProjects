package tedu.store.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import tedu.store.entity.User;

public interface UserMapper {

    Integer insert(User user);

    User findByUsername(String username);

    User findByUid(Integer uid);

    Integer updatePassword(
            @Param("uid") Integer uid,
            @Param("password") String password,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    Integer updateInfo(User user);

}
