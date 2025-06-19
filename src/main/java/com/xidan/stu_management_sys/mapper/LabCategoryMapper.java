package com.xidan.stu_management_sys.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LabCategoryMapper {
    @Select("""
    SELECT
        COALESCE(l.lab_type_id, 0)                                AS typeId,     -- 兜底为 0
        CASE COALESCE(l.lab_type_id, 0)
             WHEN 1 THEN '计算机实验室'
             WHEN 2 THEN '电子实验室'
             WHEN 3 THEN '化学实验室'
             ELSE       '其他实验室'
        END                                                       AS typeName,
        l.lab_id            AS labId,
        l.lab_name          AS labName,
        l.room_number       AS roomNumber,
        la.name             AS adminName
    FROM laboratory l
    LEFT JOIN lab_admin la ON l.lab_admin_id = la.lab_admin_id
    ORDER BY typeId, l.lab_id
""")
    List<Map<String, Object>> findCategoryFlat();
}
