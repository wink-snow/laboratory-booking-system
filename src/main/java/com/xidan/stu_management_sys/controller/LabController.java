package com.xidan.stu_management_sys.controller;

import com.xidan.stu_management_sys.Pojo.Laboratory;
import com.xidan.stu_management_sys.Pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xidan.stu_management_sys.service.LaboratoryService;

import java.util.List;

@RestController
@RequestMapping("/labs")
public class LabController {

    @Autowired
    private LaboratoryService labService;

    @GetMapping
    public List<Laboratory> getAllLabs() {
        return labService.findAvailable();
    }

    @PostMapping
    public Result addLab(@RequestBody Laboratory lab) {
        return labService.createLab(lab);
    }

    @PutMapping("/{id}")
    public Result updateLab(@PathVariable Long id, @RequestBody Laboratory lab) {
        return labService.updateLab(id, lab);
    }

    @DeleteMapping("/{id}")
    public Result deleteLab(@PathVariable Long id) {
        return labService.deleteLab(id);
    }

}
