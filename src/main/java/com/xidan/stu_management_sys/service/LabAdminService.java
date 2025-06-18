package com.xidan.stu_management_sys.service;

import com.xidan.stu_management_sys.Pojo.Laboratory;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.Pojo.ReservationInfo;

import java.util.List;

public interface LabAdminService {
    // 预约记录管理
    List<ReservationInfo> getReservationRecords();
    Result toggleReservationStatus(Long id);
    Result cancelReservation(Long id);

    // 实验室信息管理
    List<Laboratory> getLabs();
    Result updateLab(Laboratory lab);
    Result addLab(Laboratory lab);
    Result deleteLab(Long id);

    // 实验室信息表单
    Result submitLabInfo(Object labInfo);
}