package cn.jianml.mybatis.controller;

import cn.jianml.mybatis.entity.QueryRequest;
import cn.jianml.mybatis.entity.User;
import cn.jianml.mybatis.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wujian
 * @time 2020/1/9
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("{username}")
    public User getUser(@PathVariable String username) {
        return this.userService.findByName(username);
    }

    @GetMapping("check/{username}")
    public boolean checkUserName(@PathVariable String username, String userId) {
        return this.userService.findByName(username) == null || StringUtils.isNotBlank(userId);
    }

//    @GetMapping("list")
//    public FebsResponse userList(User user, QueryRequest request) {
//        Map<String, Object> dataTable = getDataTable(this.userService.findUserDetailList(user, request));
//        return new FebsResponse().success().data(dataTable);
//    }

    @PostMapping
    public void addUser(User user) {
        this.userService.createUser(user);
    }

    @GetMapping("delete/{userIds}")
    public void deleteUsers(@PathVariable String userIds) {
        String[] ids = userIds.split(",");
    }

    @PostMapping("update")
    public void updateUser(User user) {
        this.userService.updateUser(user);
    }

    @PostMapping("password/reset/{usernames}")
    public void resetPassword(@PathVariable String usernames) {
        String[] usernameArr = usernames.split(",");
        this.userService.resetPassword(usernameArr);
    }

    @PutMapping("password")
    public void updatePassword(String password) {
        userService.updatePassword(password);
    }

}
