package com.research.service;

import com.research.pojo.User;

import java.util.List;

public interface UserService {
    //根据用户名查询用户
    User findByUserName(String username);

    //注册
    void register(String username, String password);

    //更新
    void update(User user);

    //更新头像
    void updateAvatar(String avatarUrl);

    //更新密码
    void updatePwd(String newPwd);

    //修改用户权限
    void updateForce(Integer ID);

    //获取用户列表
    List<User> list();
}
