package com.zero.zengy.service;

import com.zero.zengy.entity.User;
import com.zero.zengy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    public User getUserById(long id) {
        return userMapper.selectById(id);
    }

    // 新增用户
    public boolean addUser(User user) {
        // 去掉id字段
        user.setId(null);
        // 去掉创建时间字段
        user.setCreatedAt(null);
        return userMapper.insert(user) > 0;
    }

    // 根据id删除用户
    public boolean deleteUserById(long id) {
        return userMapper.deleteById(id) > 0;
    }
}
