package com.xidan.stu_management_sys.service;

import com.xidan.stu_management_sys.Pojo.RepairInfo;
import com.xidan.stu_management_sys.Pojo.Result;

import java.util.List;

public interface RepairService {
    List<RepairInfo> listAllRepairs();
}
