package cn.jianml.mybatis.controller;

import cn.jianml.mybatis.entity.QueryRequest;
import cn.jianml.mybatis.entity.User;
import cn.jianml.mybatis.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wujian
 * @time 2020/1/9
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("{username}")
    public User getUser(@PathVariable String username) {
        return this.userService.findByName(username);
    }

    @GetMapping("list")
    public IPage<User> userList(User user, QueryRequest request) {
        return this.userService.findUserDetailList(user, request);
    }

    @PostMapping
    public void addUser(User user) {
        this.userService.createUser(user);
    }

    @DeleteMapping("/{userIds}")
    public void deleteUsers(@PathVariable String userIds) {
        String[] ids = userIds.split(",");
        this.userService.deleteUsers(ids);
    }

    @PutMapping
    public void updateUser(User user) {
        this.userService.updateUser(user);
    }

    @PutMapping("password/reset")
    public void resetPassword(String usernames) {
        String[] usernameArr = usernames.split(",");
        this.userService.resetPassword(usernameArr);
    }

    @PutMapping("password")
    public void updatePassword(String password) {
        String username = "admin"; // 项目中这里应该是获取当前用户
        userService.updatePassword(username, password);
    }

}
