package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.ReservationInfo;
import com.xidan.stu_management_sys.Pojo.ReservationRecordDTO;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.mapper.ReservationMapper;
import com.xidan.stu_management_sys.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;


    public List<ReservationRecordDTO> listAll() {
        return reservationMapper.findAllRecords();
    }

}
