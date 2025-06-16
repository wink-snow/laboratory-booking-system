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
    public List<RepairInfo> findAll() {
        return repairMapper.findAll();
    }

    @Override
    public Result createRepair(RepairInfo repairInfo) {
        // 默认状态：待处理
        if (repairInfo.getStatus() == null) {
            repairInfo.setStatus(1);
        }
        int rows = repairMapper.insertRepair(repairInfo);
        return rows > 0 ? Result.success("报修提交成功") : Result.fail("报修提交失败");
    }

    @Override
    public Result updateRepair(Long id, RepairInfo repairInfo) {
        repairInfo.setRepairId(id);
        int rows = repairMapper.updateRepair(repairInfo);
        return rows > 0 ? Result.success("报修更新成功") : Result.fail("报修更新失败");
    }

    @Override
    public Result deleteRepair(Long id) {
        int rows = repairMapper.deleteRepair(id);
        return rows > 0 ? Result.success("报修删除成功") : Result.fail("报修删除失败");
    }
}
