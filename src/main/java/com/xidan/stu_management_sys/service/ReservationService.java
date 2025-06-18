package com.xidan.stu_management_sys.service;

import com.xidan.stu_management_sys.Pojo.ReservationInfo;
import com.xidan.stu_management_sys.Pojo.ReservationRecordDTO;
import com.xidan.stu_management_sys.Pojo.Result;

import java.util.List;

public interface ReservationService {
    List<ReservationRecordDTO> listAll();

}
