package tedu.store.service;

import tedu.store.entity.User;

public interface IUserService {
    void reg(User user) throws Exception;

    User login(String username, String password) throws Exception;

    void changePassword(Integer uid, String username, String oldPassword, String newPassword) throws Exception;

    void changeInfo(User user) throws Exception;

    User getByUid(Integer uid) throws Exception;

}
