package cn.jianml.mybatis.service.impl;

import cn.jianml.mybatis.entity.QueryRequest;
import cn.jianml.mybatis.entity.User;
import cn.jianml.mybatis.mapper.UserMapper;
import cn.jianml.mybatis.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wujian
 * @time 2020/1/9
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
        //return userMapper.selectById(1);
    }

    @Override
    public IPage<User> findUserDetailList(User user, QueryRequest request) {
        return null;
    }

    @Override
    public User findUserDetailList(String username) {
        return null;
    }

    @Override
    public void updateLoginTime(String username) {

    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUsers(String[] userIds) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void resetPassword(String[] usernames) {

    }

    @Override
    public void regist(String username, String password) {

    }

    @Override
    public void updatePassword(String password) {

    }
}
