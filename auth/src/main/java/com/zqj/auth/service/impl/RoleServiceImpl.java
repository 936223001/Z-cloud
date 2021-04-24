package com.zqj.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqj.auth.mapper.RoleMapper;
import com.zqj.auth.service.RoleService;
import com.zqj.common.entity.sys.Role;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
