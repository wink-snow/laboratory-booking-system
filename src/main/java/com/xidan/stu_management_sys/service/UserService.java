package com.xidan.stu_management_sys.service;

import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.Pojo.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> findAll();
    Result createUser(UserInfo user);
    Result updateUser(Long id, UserInfo user);
    Result deleteUser(Long id);
    List<UserInfo> findSystemAdmins();
    List<UserInfo> findLabAdmins();
    List<UserInfo> findStudents();
}
