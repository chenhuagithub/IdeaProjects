package tedu.store.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tedu.store.entity.User;
import tedu.store.mapper.UserMapper;
import tedu.store.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) throws Exception {

        String username = user.getUsername();
        User result = userMapper.findByUsername(username);
        if (result == null) {
            // 设置is_delete
            user.setIsDelete(0);

            // 设置4项日志
            Date now = new Date();
            user.setCreatedUser(username);
            user.setCreatedTime(now);
            user.setModifiedUser(username);
            user.setModifiedTime(now);
            user.setUsername(username);


            // TODO 密码加密

            // 执行注册
            userMapper.insert(user);
        } else {
            // 已占用：抛出UsernameDuplicateException
            throw new Exception("注册失败");
        }
    }

    @Override
    public User login(String username, String password) throws Exception {
        // 根据参数username查询用户：User findByUsername(String username)
        User result = userMapper.findByUsername(username);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new Exception(
                    "登录失败！尝试登录的用户不存在！");
        }

        // 判断is_delete是否标记为已删除：isDelete属性值是否为1
        if (result.getIsDelete().equals(1)) {
            // 是：抛出UserNotFoundException
            throw new Exception(
                    "登录失败！尝试登录的用户不存在！");
        }


        if (result.getPassword().equals(password)) {
            // 是：准备返回结果，先去除部分不需要对外使用的数据
            result.setPassword(null);
            result.setSalt(null);
            result.setIsDelete(null);
            // 返回查询结果
            return result;
        } else {
            // 否：抛出PasswordNotMatchException
            throw new Exception(
                    "登录失败！密码错误！");
        }
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword)
            throws Exception {
        // 根据uid查询用户数据
        User result = userMapper.findByUid(uid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new Exception(
                    "修改密码失败！");//尝试访问的用户不存在！
        }

        // 判断查询结果中isDelete是否为1
        if (result.getIsDelete().equals(1)) {
            // 是：抛出UserNotFoundException
            throw new Exception(
                    "修改密码失败！尝试访问的用户不存在！");
        }

        Date now = new Date();
        // 执行修改密码：updatePassword(uid, newMd5Password, username, now)
        userMapper.updatePassword(uid, newPassword, username, now);

    }

    @Override
    public User getByUid(Integer uid) throws Exception {
        // 根据uid查询用户数据
        User result = userMapper.findByUid(uid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new Exception(
                    "获取用户信息失败！尝试访问的用户不存在！");
        }

        // 判断查询结果中isDelete是否为1
        if (result.getIsDelete().equals(1)) {
            // 是：抛出UserNotFoundException
            throw new Exception(
                    "获取用户信息失败！尝试访问的用户不存在！");
        }

        // 在返回之前隐藏不向外提供的数据
        result.setPassword(null);
        result.setSalt(null);
        result.setIsDelete(null);

        // 执行返回
        return result;
    }

    /**
     * 更新个人资料
     *
     * @param user 个人资料数据
     * @throws Exception
     */
    private void updateInfo(User user) throws Exception {
        Integer rows = userMapper.updateInfo(user);
        if (rows != 1) {
            throw new Exception(
                    "修改用户数据时出现未知错误！");
        }
    }

    /*@Override
    public void changeInfo(User user) {
        // TODO Auto-generated method stub

    }*/
    @Override
    public void changeInfo(User user) throws Exception {
        // 根据uid查询用户数据
        User result = userMapper.findByUid(user.getUid());
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new Exception(
                    "修改密码失败！尝试访问的用户不存在！");
        }

        // 判断查询结果中isDelete是否为1
        if (result.getIsDelete().equals(1)) {
            // 是：抛出UserNotFoundException
            throw new Exception(
                    "修改密码失败！尝试访问的用户不存在！");
        }
        // 向user中封装modifiedUser和modifiedTime
        user.setModifiedUser(result.getUsername());
        user.setModifiedTime(new Date());
        // 执行更新
        updateInfo(user);
    }
}
	     


