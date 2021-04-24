package com.zqj.common.entity.sys;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author zqj
 * @since 2021-04-20
 */
@Data
@TableName("sys_user_role")
public class UserRole {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

}
