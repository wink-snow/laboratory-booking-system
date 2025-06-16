package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.ReservationInfo;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.mapper.ReservationMapper;
import com.xidan.stu_management_sys.service.RepairService;
import com.xidan.stu_management_sys.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public List<ReservationInfo> findAll() {
        return reservationMapper.findAll();
    }

    @Override
    public Result create(ReservationInfo reservationInfo) {
        // 默认预约状态
        if (reservationInfo.getStatus() == null) {
            reservationInfo.setStatus(1);
        }
        // 外键验证
        if (reservationMapper.countUserById(reservationInfo.getUserId()) == 0) {
            return Result.fail("用户不存在，无法创建预约");
        }
        if (reservationMapper.countLabById(reservationInfo.getLabId()) == 0) {
            return Result.fail("实验室不存在，无法创建预约");
        }
        int rows = reservationMapper.insert(reservationInfo);
        return rows > 0 ? Result.success("预约创建成功") : Result.fail("预约创建失败");
    }

    @Override
    public Result update(Long id, ReservationInfo reservationInfo) {
        reservationInfo.setReservationId(id);
        int rows = reservationMapper.update(reservationInfo);
        return rows > 0 ? Result.success("预约更新成功") : Result.fail("预约更新失败");
    }

    @Override
    public Result delete(Long id) {
        int rows = reservationMapper.delete(id);
        return rows > 0 ? Result.success("预约删除成功") : Result.fail("预约删除失败");
    }

}
