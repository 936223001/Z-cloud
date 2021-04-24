package com.zqj.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqj.auth.mapper.MenuMapper;
import com.zqj.auth.mapper.UserMapper;
import com.zqj.auth.service.UserService;
import com.zqj.common.entity.sys.Menu;
import com.zqj.common.entity.sys.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private MenuMapper menuMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findByUsername(username);
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }

}
