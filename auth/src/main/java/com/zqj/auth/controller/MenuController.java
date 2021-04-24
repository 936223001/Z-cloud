package com.zqj.auth.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zqj.auth.service.MenuService;
import com.zqj.common.entity.sys.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author zqj
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<Menu>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<Menu> aPage = menuService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Menu> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(menuService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Menu params) {
        menuService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        menuService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> delete(@RequestBody Menu params) {
        menuService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
