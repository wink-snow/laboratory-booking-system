package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.*;
import com.xidan.stu_management_sys.mapper.LoginMapper;
import com.xidan.stu_management_sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xidan.stu_management_sys.util.JwtUtils;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private LoginMapper userMapper;
    @Override
    public Result login(LoginRequest request) {
            UserInfo user = userMapper.findByUsernamePasswordAndRole(
                    request.getUsername(),
                    request.getPassword(),
                    request.getRole()
            );

            if (user == null) {
                return Result.fail("用户名或密码错误");
            }
        // 3. 生成 JWT
            String token = JwtUtils.generateJwt(user);

            String roleName = switch (user.getRole()) {
                case 1 -> "学生";
                case 2 -> "系统管理员";
                case 3 -> "实验室管理员";
                default -> "未知角色";
            };

            LoginResponse response = new LoginResponse(
                    user.getUserId(),
                    user.getName(),
                    user.getEmail(),
                    roleName,
                    user.getAvatar(),
                    token
            );

            return Result.success(response);
        }

    @Override
    public Result register(RegisterRequest request) {

        // 1. 用户名重复校验
        if (userMapper.findByUsername(request.getUsername()) != null) {
            return Result.fail("用户名已存在！");
        }

        // 2. 构造 UserInfo 实体
        UserInfo user = new UserInfo();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // 👉 建议这里做 BCrypt 加密
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());

        // 3. 保存
        int rows = userMapper.insertUser(user);
        return rows > 0 ? Result.success("注册成功") : Result.fail("注册失败");
    }



}

