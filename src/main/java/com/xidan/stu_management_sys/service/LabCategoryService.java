package com.xidan.stu_management_sys.service;


import com.xidan.stu_management_sys.Pojo.LabCategoryDTO;

import java.util.List;

public interface LabCategoryService {
    List<LabCategoryDTO> listCategoriesWithLabs();
}
