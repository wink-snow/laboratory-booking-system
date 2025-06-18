package com.xidan.stu_management_sys.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabDTO {
    private Long   labId;
    private String labName;
    private String description;
    private String roomNumber;
    private String startTime;
    private String endTime;
    private Integer status;
    private String createdAt;

    private String labTypeName;

    private AdminInfo admin;      // 👈 关联管理员信息

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AdminInfo {
        private String name;
        private String phone;
    }
}
