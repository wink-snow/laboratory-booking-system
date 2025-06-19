package com.xidan.stu_management_sys.controller;

import com.xidan.stu_management_sys.Pojo.RepairInfo;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    @GetMapping
    public List<RepairInfo> listRepairs() {
        return repairService.listAllRepairs();
    }
}
