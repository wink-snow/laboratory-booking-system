package com.xidan.stu_management_sys.Pojo;

import lombok.Data;

@Data
public class LabStatusDTO {
    private Integer status; // 1=空闲中 2=使用中
    private Integer total;
}
