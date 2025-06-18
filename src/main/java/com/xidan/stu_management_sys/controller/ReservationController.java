package com.xidan.stu_management_sys.controller;

import com.xidan.stu_management_sys.Pojo.ReservationInfo;
import com.xidan.stu_management_sys.Pojo.ReservationRecordDTO;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /** 获取全部预约记录 */
    @GetMapping
    public List<ReservationRecordDTO> list() {
        return reservationService.listAll();
    }
}

