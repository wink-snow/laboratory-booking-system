package com.xidan.stu_management_sys.controller;


import com.xidan.stu_management_sys.Pojo.LabCategoryDTO;
import com.xidan.stu_management_sys.service.LabCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class LabCategoryController {
    @Autowired
    private LabCategoryService labCategoryService;
    @GetMapping
    public List<LabCategoryDTO> listCategories() {
        return labCategoryService.listCategoriesWithLabs();
    }
}
