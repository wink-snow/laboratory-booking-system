package com.xidan.stu_management_sys.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRecordDTO {
    private Long reservationId;      // 预约 ID
    private String userName;         // 预约人
    private String labName;          // 实验室名称
    private String operationTime;    // 操作时间 (yyyy-MM-dd HH:mm:ss)
    private Integer status;          // 1 待处理 / 2 已批准 / 3 已拒绝
    private String equipmentStatus;  // 设备状态
    private String createdAt;        // 创建时间
}
