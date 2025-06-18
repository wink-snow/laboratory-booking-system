package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.Laboratory;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.Pojo.ReservationInfo;
import com.xidan.stu_management_sys.mapper.LaboratoryMapper;
import com.xidan.stu_management_sys.mapper.ReservationMapper;
import com.xidan.stu_management_sys.service.LabAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabAdminServiceImpl implements LabAdminService {
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private LaboratoryMapper laboratoryMapper;

    // 预约记录管理
    @Override
    public List<ReservationInfo> getReservationRecords() {
        return reservationMapper.getAllReservationRecords();
    }

    @Override
    public Result toggleReservationStatus(Long id) {
        int rows = reservationMapper.toggleStatus(id);
        return rows > 0 ? Result.success("状态切换成功") : Result.error("状态切换失败");
    }

    @Override
    public Result cancelReservation(Long id) {
        int rows = reservationMapper.cancelReservation(id);
        return rows > 0 ? Result.success("预约取消成功") : Result.error("预约取消失败");
    }

    // 实验室信息管理
    @Override
    public List<Laboratory> getLabs() {
        // 测试数据库连接
        Integer connectionTest = laboratoryMapper.testDbConnection();
        System.out.println("数据库连接测试结果: " + (connectionTest != null ? "成功" : "失败"));
        
        List<Laboratory> labs = laboratoryMapper.getAllLabs();
        System.out.println("从数据库查询到的实验室数量: " + (labs != null ? labs.size() : 0));
        return labs;
    }

    @Override
    public Result updateLab(Laboratory lab) {
        int rows = laboratoryMapper.updateLab(lab);
        return rows > 0 ? Result.success("实验室信息更新成功") : Result.error("实验室信息更新失败");
    }

    @Override
    public Result addLab(Laboratory lab) {
        int rows = laboratoryMapper.addLab(lab);
        return rows > 0 ? Result.success("实验室添加成功") : Result.error("实验室添加失败");
    }

    @Override
    public Result deleteLab(Long id) {
        int rows = laboratoryMapper.deleteLab(id);
        return rows > 0 ? Result.success("实验室删除成功") : Result.error("实验室删除失败");
    }

    // 实验室信息表单
    @Override
    public Result submitLabInfo(Object labInfo) {
        // 这里可以添加具体的处理逻辑
        return Result.success("表单提交成功");
    }
}