package com.zqj.common.entity.sys;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 角色菜单关联表
 * </p>
 *
 * @author zqj
 * @since 2021-04-20
 */
@Data
@TableName("sys_role_menu")
public class RoleMenu{

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long menuId;

}
