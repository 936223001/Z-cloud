package com.zqj.auth.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqj.auth.service.UserRoleService;
import com.zqj.common.entity.sys.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户和角色关联表 前端控制器
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {


    @Autowired
    private UserRoleService userRoleService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<UserRole>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<UserRole> aPage = userRoleService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserRole> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(userRoleService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody UserRole params) {
        userRoleService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        userRoleService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> delete(@RequestBody UserRole params) {
        userRoleService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
