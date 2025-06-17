package com.xidan.stu_management_sys.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabCategoryDTO {
    private Long                typeId;
    private String              typeName;
    private List<LabBriefDTO> labs = new ArrayList<>();
}
