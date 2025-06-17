package com.xidan.stu_management_sys.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LabCategoryMapper {
    @Select("""
        SELECT
            l.lab_type_id                                                               AS typeId,
            /* 根据 id 映射中文名称；新增分类时别忘了同步下面的 CASE */
            CASE l.lab_type_id
                 WHEN 1 THEN '计算机实验室'
                 WHEN 2 THEN '电子实验室'
                 WHEN 3 THEN '化学实验室'
                 ELSE        '其他实验室'
            END                                                                         AS typeName,

            l.lab_id        AS labId,
            l.lab_name      AS labName,
            l.room_number   AS roomNumber,
            la.name         AS adminName
        FROM laboratory l
        LEFT JOIN lab_admin la ON l.lab_admin_id = la.lab_admin_id

        ORDER BY l.lab_type_id, l.lab_id
    """)
    List<Map<String, Object>> findCategoryFlat();
}
