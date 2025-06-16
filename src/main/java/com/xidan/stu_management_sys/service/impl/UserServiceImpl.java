package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.Pojo.UserInfo;
import com.xidan.stu_management_sys.mapper.UserMapper;
import com.xidan.stu_management_sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Result createUser(UserInfo user) {
        try {
            int rows = userMapper.insertUser(user);
            return rows > 0 ? Result.success("用户创建成功") : Result.fail("用户创建失败");
        } catch (Exception e) {
            return Result.fail("创建失败：" + e.getMessage());
        }
    }

    @Override
    public Result updateUser(Long id, UserInfo user) {
        user.setUserId(id);
        int rows = userMapper.updateUser(user);
        return rows > 0 ? Result.success("用户更新成功") : Result.fail("用户更新失败");
    }

    @Override
    public Result deleteUser(Long id) {
        int rows = userMapper.deleteUser(id);
        return rows > 0 ? Result.success("用户删除成功") : Result.fail("用户删除失败");
    }


    @Override
    public List<UserInfo> findSystemAdmins() {
        return userMapper.findSystemAdmins();
    }

    @Override
    public List<UserInfo> findLabAdmins() {
        return userMapper.findLabAdmins();
    }

    @Override
    public List<UserInfo> findStudents() {
        return userMapper.findStudents();
    }
}
