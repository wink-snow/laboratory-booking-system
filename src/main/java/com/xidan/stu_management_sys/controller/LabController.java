package com.xidan.stu_management_sys.controller;

import com.xidan.stu_management_sys.Pojo.Laboratory;
import com.xidan.stu_management_sys.Pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xidan.stu_management_sys.service.LaboratoryService;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/labs")
public class LabController {

    @Autowired
    private LaboratoryService labService;

    @GetMapping("/all")
    public List<Laboratory> getAllLabs() {
        return labService.findAll();
    }
    

    @GetMapping
    public List<Laboratory> getAllAvailableLabs() {
        return labService.findAvailable();
    }

    @GetMapping("/{id}")
    public Laboratory getLabByID (@PathVariable Long id) {
        return labService.getLaboratoryById(id);
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
