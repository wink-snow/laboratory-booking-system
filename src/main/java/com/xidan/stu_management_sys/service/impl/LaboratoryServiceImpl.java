package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.Laboratory;

import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.mapper.LaboratoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xidan.stu_management_sys.service.LaboratoryService;

import java.util.List;



@Service
public class LaboratoryServiceImpl implements LaboratoryService {
    @Autowired
    private LaboratoryMapper laboratoryMapper;

    @Override
    public List<Laboratory> findAll() {
        return laboratoryMapper.findAllLaboratories();
    }
    @Override
    public List<Laboratory> findAvailable() {
        return laboratoryMapper.findAvailableLaboratories();
    }

    @Override
    public Result createLab(Laboratory lab) {
        int rows = laboratoryMapper.insertLaboratory(lab);
        if (rows > 0) {
            return Result.success("实验室创建成功");
        } else {
            return Result.fail("实验室创建失败");
        }
    }

    @Override
    public Result updateLab(Long id, Laboratory lab) {
        lab.setLabId(id); // 设置 ID，用于 WHERE 条件
        int rows = laboratoryMapper.updateLaboratory(lab);
        if (rows > 0) {
            return Result.success("实验室更新成功");
        } else {
            return Result.fail("实验室更新失败");
        }
    }

    @Override
    public Result deleteLab(Long id) {
        int rows = laboratoryMapper.deleteLaboratory(id);
        if (rows > 0) {
            return Result.success("实验室删除成功");
        } else {
            return Result.fail("实验室删除失败");
        }
    }

    @Override
    public Laboratory getLaboratoryById(Long id) {
        return laboratoryMapper.getLaboratoryById(id);
    }
}
