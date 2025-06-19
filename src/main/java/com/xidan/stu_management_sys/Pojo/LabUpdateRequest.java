package com.xidan.stu_management_sys.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabUpdateRequest {
    private String labName;

    private String description;
    private String roomNumber;

    /** “HH:mm” 字符串，例如 08:00 */
    private String startTime;

    /** “HH:mm” 字符串，例如 18:00 */
    private String endTime;


    private Integer status;


}
