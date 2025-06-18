package com.xidan.stu_management_sys.mapper;


import com.xidan.stu_management_sys.Pojo.LabStatusDTO;
import com.xidan.stu_management_sys.Pojo.Laboratory;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface LaboratoryMapper {

    @Select("SELECT * FROM laboratory WHERE status = 1")
    List<Laboratory> findAvailableLaboratories();

    @Insert("INSERT INTO laboratory (lab_admin_id, lab_type_id, lab_name, description, room_number, start_time, end_time, status, created_at, updated_at) " +
            "VALUES (#{labAdminId}, #{labTypeId}, #{labName}, #{description}, #{roomNumber}, #{startTime}, #{endTime}, #{status}, NOW(), NOW())")
    int insertLaboratory(Laboratory lab);


    @Update("UPDATE laboratory SET lab_admin_id=#{labAdminId}, lab_type_id=#{labTypeId}, lab_name=#{labName}, description=#{description}, " +
            "room_number=#{roomNumber}, start_time=#{startTime}, end_time=#{endTime}, status=#{status}, updated_at=NOW() WHERE lab_id=#{labId}")
    int updateLaboratory(Laboratory lab);


    @Delete("DELETE FROM laboratory WHERE lab_id = #{id}")
    int deleteLaboratory(Long id);

    @Select("SELECT status, COUNT(*) AS total FROM laboratory GROUP BY status")
    List<LabStatusDTO> countByStatus();

    @Select("SELECT * FROM laboratory")
    @Results({
        @Result(property = "labId", column = "lab_id"),
        @Result(property = "labAdminId", column = "lab_admin_id"),
        @Result(property = "labTypeId", column = "lab_type_id"),
        @Result(property = "labName", column = "lab_name"),
        @Result(property = "roomNumber", column = "room_number"),
        @Result(property = "startTime", column = "start_time"),
        @Result(property = "endTime", column = "end_time"),
        @Result(property = "createdAt", column = "created_at"),
        @Result(property = "updatedAt", column = "updated_at")
    })
    List<Laboratory> getAllLabs();

    @Select("SELECT 1 FROM DUAL")
    Integer testDbConnection();

    @Update("UPDATE laboratory SET lab_admin_id=#{labAdminId}, lab_type_id=#{labTypeId}, lab_name=#{labName}, description=#{description}, room_number=#{roomNumber}, start_time=#{startTime}, end_time=#{endTime}, status=#{status}, updated_at=NOW() WHERE lab_id=#{labId}")
    int updateLab(Laboratory lab);

    @Insert("INSERT INTO laboratory (lab_admin_id, lab_type_id, lab_name, description, room_number, start_time, end_time, status, created_at, updated_at) VALUES (#{labAdminId}, #{labTypeId}, #{labName}, #{description}, #{roomNumber}, #{startTime}, #{endTime}, #{status}, NOW(), NOW())")
    int addLab(Laboratory lab);

    @Delete("DELETE FROM laboratory WHERE lab_id = #{id}")
    int deleteLab(Long id);
}
