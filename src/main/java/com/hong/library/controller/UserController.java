package com.hong.library.controller;

import com.hong.library.domain.Result;
import com.hong.library.domain.User;
import com.hong.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        User loginUser = userService.login(user);
        if (loginUser == null) {
            return new Result<>().error();
        }
        session.setAttribute("user", loginUser);
        return new Result<User>().success(loginUser);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        System.out.println("上传的参数为:" + user.toString());
        String username = HtmlUtils.htmlEscape(user.getUsername());
        user.setUsername(username);
        return userService.register(user);
    }
}
