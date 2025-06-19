package com.xidan.stu_management_sys.controller;

import com.xidan.stu_management_sys.Pojo.*;
import com.xidan.stu_management_sys.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @Autowired
    private LabService labService2;


    @GetMapping("/all")
    public List<Laboratory> getAllLabs() {
        return labService.findAll();
    }
    

    @GetMapping("/available")
    public List<Laboratory> getAllAvailableLabs() {
        return labService.findAvailable();
    }

    @GetMapping("/{id}")
    public Laboratory getLabByID (@PathVariable Long id) {
        return labService.getLaboratoryById(id);
    }
    

    // @PostMapping
    // public Result addLab(@RequestBody Laboratory lab) {
    //     return labService.createLab(lab);
    // }

    @GetMapping
    public List<LabDTO> listlabs() {
        return labService2.listAllLabs();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLab(@PathVariable Long id,
                                          @RequestBody @Validated LabUpdateRequest req) {
        labService2.updateLab(id, req);
        return ResponseEntity.noContent().build();   // 204
    }


    @PostMapping
    public ResponseEntity<Void> createLab(@RequestBody @Validated LabCreateRequest req) {
        labService2.createLab(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLab(@PathVariable Long id) {
        labService2.deleteLab(id);
        return ResponseEntity.noContent().build(); // 204 无内容
    }



}
