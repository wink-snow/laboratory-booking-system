package com.xidan.stu_management_sys.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private Long id;

    private String title;

    private String content;

    private LocalDate createdTime;

    private String creator;
}
