package com.xidan.stu_management_sys.service;

import com.xidan.stu_management_sys.Pojo.LoginRequest;
import com.xidan.stu_management_sys.Pojo.RegisterRequest;
import com.xidan.stu_management_sys.Pojo.Result;

public interface AuthService {

    Result login(LoginRequest loginRequest);

    Result register(RegisterRequest request);

}
