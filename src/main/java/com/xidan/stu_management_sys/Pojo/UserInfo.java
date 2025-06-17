package com.xidan.stu_management_sys.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Long labAdminId;
    private Long userId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private Integer points;
    private Integer role;
    private String avatar;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
