package com.zqj.auth.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zqj.common.entity.sys.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过名称查找用户信息
     * @param username
     * @return
     */
    User findByUsername(@Param("username")String username);

}
