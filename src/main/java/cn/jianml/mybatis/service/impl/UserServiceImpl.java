package cn.jianml.mybatis.service.impl;

import cn.jianml.mybatis.entity.QueryRequest;
import cn.jianml.mybatis.entity.User;
import cn.jianml.mybatis.mapper.UserMapper;
import cn.jianml.mybatis.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    }

    @Override
    public IPage<User> findUserDetailList(User user, QueryRequest request) {
        Page<User> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.baseMapper.findUserDetailPage(page, user);
    }

    @Override
    public void createUser(User user) {
        user.setCreateTime(new Date());
        this.save(user);
    }

    @Override
    public void deleteUsers(String[] userIds) {
        List<String> list = Arrays.asList(userIds);
        this.removeByIds(list);
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(null);
        user.setUsername(null);
        user.setModifyTime(new Date());

        this.updateById(user);
    }

    @Override
    public void resetPassword(String[] usernames) {
        Arrays.stream(usernames).forEach(username -> {
            User user = new User();
            user.setPassword("123456");
            this.userMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        });
    }

    @Override
    public void updatePassword(String username, String password) {
        User user = new User();
        user.setPassword(password);
        user.setModifyTime(new Date());
        this.userMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }
}
