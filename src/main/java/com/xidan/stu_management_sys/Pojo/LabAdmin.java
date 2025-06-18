package com.xidan.stu_management_sys.Pojo;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LabAdmin {
    private Long labAdminId;

    private Long userId;

    private String name;

    private String phone;

    private String email;

    private String avatar;

    private Integer roleMarker; // 固定为 3

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
