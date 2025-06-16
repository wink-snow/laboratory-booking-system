package com.xidan.stu_management_sys.service;

import com.xidan.stu_management_sys.Pojo.ReservationInfo;
import com.xidan.stu_management_sys.Pojo.Result;

import java.util.List;

public interface ReservationService {
    List<ReservationInfo> findAll();
    Result create(ReservationInfo reservationInfo);
    Result update(Long id, ReservationInfo reservationInfo);
    Result delete(Long id);
}
