package com.xidan.stu_management_sys.controller;

import com.xidan.stu_management_sys.Pojo.LabStatusDTO;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.mapper.LaboratoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admin")
public class AdminStatsController {
    @Autowired
    private LaboratoryMapper labMapper;   // 只需提供一个分组统计查询

    /** 返回实验室状态统计 */
    @GetMapping("/lab-status")
    public Result labStatus() {
        // [{status:1, total:5}, {status:2, total:3}]
        List<LabStatusDTO> list = labMapper.countByStatus();

        // 转成前端更易用的数据结构
        Map<String, Object> data = new HashMap<>();
        data.put("空闲中", 0);  // 默认值
        data.put("使用中", 0);

        list.forEach(item -> {
            String key = item.getStatus() == 1 ? "空闲中" : "使用中";
            data.put(key, item.getTotal());
        });
        return Result.success(data);
    }
}
