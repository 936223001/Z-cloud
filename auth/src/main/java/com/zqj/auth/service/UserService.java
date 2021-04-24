package com.zqj.auth.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zqj.common.entity.sys.User;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
public interface UserService extends IService<User> {


    User findByName(String username);

    String findUserPermissions(String username);

}
