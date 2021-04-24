package com.zqj.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqj.auth.mapper.RoleMenuMapper;
import com.zqj.auth.service.RoleMenuService;
import com.zqj.common.entity.sys.RoleMenu;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}
