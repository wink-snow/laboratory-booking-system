package com.xidan.stu_management_sys.controller;

import com.xidan.stu_management_sys.Pojo.ReservationInfo;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reserve")
public class ReserveController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<ReservationInfo> getAllReservations() {
        return reservationService.findAll();
    }

    @PostMapping
    public Result createReservation(@RequestBody ReservationInfo reservationInfo) {
        return reservationService.create(reservationInfo);
    }

    @PutMapping("/{id}")
    public Result updateReservation(@PathVariable Long id, @RequestBody ReservationInfo reservationInfo) {
        return reservationService.update(id, reservationInfo);
    }

    @DeleteMapping("/{id}")
    public Result deleteReservation(@PathVariable Long id) {
        return reservationService.delete(id);
    }
}
