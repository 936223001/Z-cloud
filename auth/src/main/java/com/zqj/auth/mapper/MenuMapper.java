package com.zqj.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zqj.common.entity.sys.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户名称查找菜单列表
     * @param username
     * @return
     */
    List<Menu> findByUsername(@Param("username") String username);

}
