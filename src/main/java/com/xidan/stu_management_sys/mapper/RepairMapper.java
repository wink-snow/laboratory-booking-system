package com.xidan.stu_management_sys.mapper;

import com.xidan.stu_management_sys.Pojo.RepairInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RepairMapper {
    /* 查询全部报修 */
    @Select("SELECT * FROM repair_info")
    List<RepairInfo> findAll();

    /* 新增报修 */
    @Insert("""
        INSERT INTO repair_info
          (user_id, lab_id, repair_time, status, admin_id, description, created_at, updated_at)
        VALUES
          (#{userId}, #{labId}, #{repairTime}, #{status}, #{adminId}, #{description}, NOW(), NOW())
        """)
    @Options(useGeneratedKeys = true, keyProperty = "repairId")
    int insertRepair(RepairInfo repairInfo);

    /* 更新报修 */
    @Update("""
        UPDATE repair_info SET
          user_id     = #{userId},
          lab_id      = #{labId},
          repair_time = #{repairTime},
          status      = #{status},
          admin_id    = #{adminId},
          description = #{description},
          updated_at  = NOW()
        WHERE repair_id = #{repairId}
        """)
    int updateRepair(RepairInfo repairInfo);

    /* 删除报修 */
    @Delete("DELETE FROM repair_info WHERE repair_id = #{id}")
    int deleteRepair(Long id);
}
