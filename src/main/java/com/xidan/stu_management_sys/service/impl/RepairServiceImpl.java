package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.RepairInfo;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.mapper.RepairMapper;
import com.xidan.stu_management_sys.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;


    @Override
    public List<RepairInfo> listAllRepairs() {
        return repairMapper.selectAll();
    }
}
