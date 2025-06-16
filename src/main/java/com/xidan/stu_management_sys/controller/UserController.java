package com.xidan.stu_management_sys.controller;


import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.Pojo.UserInfo;
import com.xidan.stu_management_sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserInfo> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/admins")
    public List<UserInfo> getAdmins() {
        return userService.findSystemAdmins();
    }

    @PostMapping
    public Result createUser(@RequestBody UserInfo userInfo) {
        return userService.createUser(userInfo);
    }

    @PutMapping("/{id}")
    public Result updateUser(@PathVariable Long id, @RequestBody UserInfo userInfo) {
        return userService.updateUser(id, userInfo);
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/lab-admins")        // ✅ 新增
    public List<UserInfo> getLabAdmins() {
        return userService.findLabAdmins();
    }

    @GetMapping("/students")
    public List<UserInfo> getStudents() {
        return userService.findStudents();
    }



}
