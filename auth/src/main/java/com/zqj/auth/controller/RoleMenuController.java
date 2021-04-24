package com.zqj.auth.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqj.auth.service.RoleMenuService;
import com.zqj.common.entity.sys.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色和菜单关联表 前端控制器
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {


    @Autowired
    private RoleMenuService roleMenuService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<RoleMenu>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<RoleMenu> aPage = roleMenuService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleMenu> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(roleMenuService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody RoleMenu params) {
        roleMenuService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        roleMenuService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> delete(@RequestBody RoleMenu params) {
        roleMenuService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
