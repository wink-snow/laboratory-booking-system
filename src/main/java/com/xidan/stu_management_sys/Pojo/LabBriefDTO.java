package com.xidan.stu_management_sys.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabBriefDTO {
    private Long   labId;
    private String labName;
    private String adminName;
    private String roomNumber;
}
