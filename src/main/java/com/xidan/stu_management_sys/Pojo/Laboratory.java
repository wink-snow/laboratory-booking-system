package com.xidan.stu_management_sys.Pojo;



import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Laboratory {
    private Long labId;

    private Long labAdminId;

    private Long labTypeId;

    private String labName;

    private String description;

    private String roomNumber;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer status; // 1-可用，2-不可用

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}

