package com.zqj.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqj.auth.mapper.UserRoleMapper;
import com.zqj.auth.service.UserRoleService;
import com.zqj.common.entity.sys.UserRole;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
