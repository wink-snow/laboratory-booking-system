package com.xidan.stu_management_sys.controller;

import com.xidan.stu_management_sys.Pojo.Laboratory;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.Pojo.ReservationInfo;
import com.xidan.stu_management_sys.service.LabAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab-admin")
public class LabAdminApiController {
    @Autowired
    private LabAdminService labAdminService;

    // 预约记录管理
    @GetMapping("/reservation-records")
    public List<ReservationInfo> getReservationRecords() {
        return labAdminService.getReservationRecords();
    }

    @PutMapping("/reservation-records/{id}/toggle-status")
    public Result toggleReservationStatus(@PathVariable Long id) {
        return labAdminService.toggleReservationStatus(id);
    }

    @PutMapping("/reservation-records/{id}/cancel")
    public Result cancelReservation(@PathVariable Long id) {
        return labAdminService.cancelReservation(id);
    }

    // 实验室信息管理
    @GetMapping("/labs")
    public Result getLabs() {
        try {
            List<Laboratory> labs = labAdminService.getLabs();
            System.out.println("查询到实验室数量: " + labs.size());
            return Result.success(labs);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询实验室信息失败: " + e.getMessage());
        }
    }

    @PutMapping("/labs/{id}")
    public Result updateLab(@PathVariable Long id, @RequestBody Laboratory lab) {
        lab.setLabId(id);
        return labAdminService.updateLab(lab);
    }

    @PostMapping("/labs")
    public Result addLab(@RequestBody Laboratory lab) {
        return labAdminService.addLab(lab);
    }

    @DeleteMapping("/labs/{id}")
    public Result deleteLab(@PathVariable Long id) {
        return labAdminService.deleteLab(id);
    }

    // 实验室信息表单
    @PostMapping("/lab-info")
    public Result submitLabInfo(@RequestBody Object labInfo) {
        return labAdminService.submitLabInfo(labInfo);
    }
}