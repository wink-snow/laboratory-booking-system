package com.xidan.stu_management_sys.mapper;

import com.xidan.stu_management_sys.Pojo.RepairInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RepairMapper {
    @Select("SELECT * FROM repair_info ORDER BY repair_id ASC")
    List<RepairInfo> selectAll();
}
