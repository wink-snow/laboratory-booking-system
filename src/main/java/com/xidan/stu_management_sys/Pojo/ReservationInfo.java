package com.xidan.stu_management_sys.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationInfo {

    private Long reservationId;

    private Long userId;

    private Long labId;

    private LocalDateTime operationTime;

    private Integer status; // 1-待处理，2-已批准，3-已拒绝

    private String equipmentStatus;

    private Long labAdminId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
