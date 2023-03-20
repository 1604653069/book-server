package com.hong.library.service.impl;

import ch.qos.logback.core.net.ssl.SecureRandomFactoryBean;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hong.library.domain.Result;
import com.hong.library.domain.User;
import com.hong.library.mapper.UserMapper;
import com.hong.library.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername()).eq("password", user
                .getPassword());
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Result register(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", user.getUsername());
        User dbUser = baseMapper.selectOne(queryWrapper);
        if (dbUser != null) {
            return new Result().error("注册失败,用户名已被注册");
        }
        int insert = baseMapper.insert(user);
        if (insert > 0) {
            return new Result().success(null);
        } else {
            return new Result().error("注册失败,无法添加用户");
        }
    }
}
