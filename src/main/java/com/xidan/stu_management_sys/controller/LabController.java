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

@RestController
@RequestMapping("/labs")
public class LabController {

    @Autowired
    private LabService labService2;


    @GetMapping
    public List<LabDTO> listLabs() {
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
