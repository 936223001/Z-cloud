package com.zqj.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqj.auth.mapper.MenuMapper;
import com.zqj.auth.service.MenuService;
import com.zqj.common.entity.sys.Menu;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
