package com.zqj.auth.service.impl;

import com.zqj.auth.service.UserService;
import com.zqj.common.entity.AuthUser;
import com.zqj.common.entity.sys.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * @Description
 * @author zhuqijing
 * @date 2021/4/18
 * @Version 1.0
 **/
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User systemUser = userService.findByName(username);
        if (systemUser != null) {
            String permissions = userService.findUserPermissions(systemUser.getUsername());
            AuthUser authUser = new AuthUser(systemUser.getUsername(), systemUser.getPassword(), true, true, true, true,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
            BeanUtils.copyProperties(systemUser, authUser);
            log.debug("=====>>>: {}", authUser);
            return authUser;
        } else {
            throw new UsernameNotFoundException("");
        }
    }
}