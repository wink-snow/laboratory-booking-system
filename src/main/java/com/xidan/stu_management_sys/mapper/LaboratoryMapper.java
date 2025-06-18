package com.xidan.stu_management_sys.mapper;


import com.xidan.stu_management_sys.Pojo.LabStatusDTO;
import com.xidan.stu_management_sys.Pojo.Laboratory;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface LaboratoryMapper {

    @Select("SELECT * FROM laboratory")
    List<Laboratory> findAllLaboratories();
    
    @Select("SELECT * FROM laboratory WHERE status = 1")
    List<Laboratory> findAvailableLaboratories();

    @Insert("INSERT INTO laboratory (lab_admin_id, lab_type_id, lab_name, description, room_number, start_time, end_time, status, created_at, updated_at) " +
            "VALUES (#{labAdminId}, #{labTypeId}, #{labName}, #{description}, #{roomNumber}, #{startTime}, #{endTime}, #{status}, NOW(), NOW())")
    int insertLaboratory(Laboratory lab);


    @Update("UPDATE laboratory SET lab_admin_id=#{labAdminId}, lab_type_id=#{labTypeId}, lab_name=#{labName}, description=#{description}, " +
            "room_number=#{roomNumber}, start_time=#{startTime}, end_time=#{endTime}, status=#{status}, updated_at=NOW() WHERE lab_id=#{labId}")
    int updateLaboratory(Laboratory lab);

    @Select("SELECT * FROM laboratory WHERE lab_id = #{id}")
    Laboratory getLaboratoryById(Long id);


    @Delete("DELETE FROM laboratory WHERE lab_id = #{id}")
    int deleteLaboratory(Long id);

    @Select("SELECT status, COUNT(*) AS total FROM laboratory GROUP BY status")
    List<LabStatusDTO> countByStatus();
}
