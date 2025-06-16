package com.xidan.stu_management_sys.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairInfo {
    private Long repairId;

    private Long userId;
    private Long labId;

    private LocalDateTime repairTime;

    private Integer status; // 1-待处理，2-处理中，3-已完成

    private Long adminId;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
