package com.xidan.stu_management_sys.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabCreateRequest {
    private String labName;         // 实验室名称
    private String description;     // 实验室介绍
    private String roomNumber;      // 房间号
    private String startTime;       // 开放开始时间，格式如 "08:00"
    private String endTime;         // 关闭时间，格式如 "18:00"
    private Integer status;         // 状态：1=可用，2=不可用
    private Long labAdminId;        // 实验室管理员ID
    private Long labTypeId;         // 实验室分类ID（新增）
}
