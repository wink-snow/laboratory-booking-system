package com.xidan.stu_management_sys.mapper;

import com.xidan.stu_management_sys.Pojo.LabUpdateRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface LabMapper {

    @Select("""
    SELECT
        l.lab_id          AS labId,
        l.lab_name        AS labName,
        l.description     AS description,
        l.room_number     AS roomNumber,
        l.start_time      AS startTime,
        l.end_time        AS endTime,
        l.status          AS status,
        DATE_FORMAT(l.created_at, '%Y-%m-%d %H:%i:%s') AS createdAt,
        CASE l.lab_type_id
            WHEN 1 THEN '计算机实验室'
            WHEN 2 THEN '电子实验室'
            WHEN 3 THEN '化学实验室'
            ELSE '其他'
        END AS labTypeName,
        la.name           AS adminName,
        la.phone          AS adminPhone
    FROM laboratory l
    LEFT JOIN lab_admin la ON l.lab_admin_id = la.lab_admin_id
    ORDER BY l.lab_id
""")
    List<Map<String, Object>> findAllLabFlat();

    @Update("""
        UPDATE laboratory
        SET lab_name   = #{req.labName},
            description = #{req.description},
            room_number = #{req.roomNumber},
            start_time  = #{req.startTime},
            end_time    = #{req.endTime},
            status      = #{req.status}
        WHERE lab_id   = #{id}
    """)
    int updateLab(@Param("id") Long id,
                  @Param("req") LabUpdateRequest req);

    @Insert("""
        INSERT INTO laboratory (
            lab_name,
            description,
            room_number,
            start_time,
            end_time,
            status,
            lab_admin_id,
            lab_type_id,
            created_at
        ) VALUES (
            #{labName},
            #{description},
            #{roomNumber},
            #{startTime},
            #{endTime},
            #{status},
            #{labAdminId},
            #{labTypeId},
            NOW()
        )
    """)
    int insertLab(@Param("labName") String labName,
                  @Param("description") String description,
                  @Param("roomNumber") String roomNumber,
                  @Param("startTime") String startTime,
                  @Param("endTime") String endTime,
                  @Param("status") Integer status,
                  @Param("labAdminId") Long labAdminId,
                  @Param("labTypeId") Long labTypeId);

    @Delete("DELETE FROM laboratory WHERE lab_id = #{id}")
    int deleteLabById(Long id);


}

