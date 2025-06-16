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
    public List<RepairInfo> getAllRepairs() {
        return repairService.findAll();
    }

    @PostMapping
    public Result reportRepair(@RequestBody RepairInfo repairInfo) {
        return repairService.createRepair(repairInfo);
    }

    @PutMapping("/{id}")
    public Result updateRepair(@PathVariable Long id, @RequestBody RepairInfo repairInfo) {
        return repairService.updateRepair(id, repairInfo);
    }

    @DeleteMapping("/{id}")
    public Result deleteRepair(@PathVariable Long id) {
        return repairService.deleteRepair(id);
    }
}
