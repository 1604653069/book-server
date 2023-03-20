package com.hong.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hong.library.domain.Result;
import com.hong.library.domain.User;

public interface UserService extends IService<User> {

    User login(User user);

     Result register(User user);
}
