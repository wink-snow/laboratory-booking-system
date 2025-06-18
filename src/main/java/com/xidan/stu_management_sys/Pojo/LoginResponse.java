package com.xidan.stu_management_sys.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private Long userId;
    private String name;
    private String email;
    private String role; // 角色名字符串
    private String avatar;
    private String token;
}
