package com.xidan.stu_management_sys.mapper;

import com.xidan.stu_management_sys.Pojo.ReservationInfo;
import com.xidan.stu_management_sys.Pojo.ReservationRecordDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReservationMapper {
    @Select("SELECT * FROM reservation_info")
    List<ReservationInfo> findAll();

    @Insert("INSERT INTO reservation_info (user_id, lab_id, operation_time, status, equipment_status, lab_admin_id, created_at, updated_at) " +
            "VALUES (#{userId}, #{labId}, #{operationTime}, #{status}, #{equipmentStatus}, #{labAdminId}, NOW(), NOW())")
    int insert(ReservationInfo reservationInfo);

    @Select("""
        SELECT
            r.reservation_id                              AS reservationId,
            u.name                                         AS userName,
            l.lab_name                                     AS labName,
            DATE_FORMAT(r.operation_time,'%Y-%m-%d %H:%i:%s') AS operationTime,
            r.status                                       AS status,
            r.equipment_status                             AS equipmentStatus,
            DATE_FORMAT(r.created_at,'%Y-%m-%d %H:%i:%s')  AS createdAt
        FROM reservation_info r
        JOIN user_info     u ON r.user_id = u.user_id
        JOIN laboratory    l ON r.lab_id  = l.lab_id
        ORDER BY r.user_id ASC
        """)
    List<ReservationRecordDTO> findAllRecords();

    @Update("UPDATE reservation_info SET user_id=#{userId}, lab_id=#{labId}, operation_time=#{operationTime}, " +
        "status=#{status}, equipment_status=#{equipmentStatus}, lab_admin_id=#{labAdminId}, updated_at=NOW() WHERE reservation_id=#{reservationId}")
    int update(ReservationInfo reservationInfo);

    @Delete("DELETE FROM reservation_info WHERE reservation_id = #{id}")
    int delete(Long id);


    @Select("SELECT COUNT(*) FROM user_info WHERE user_id = #{userId}")
    int countUserById(Long userId);

    @Select("SELECT COUNT(*) FROM laboratory WHERE lab_id = #{labId}")
    int countLabById(Long labId);

    @Select("SELECT r.*, u.name as studentName, l.lab_name as labName, l.room_number as roomNumber FROM reservation_info r JOIN user_info u ON r.user_id = u.user_id JOIN laboratory l ON r.lab_id = l.lab_id")
    List<ReservationInfo> getAllReservationRecords();

    @Update("UPDATE reservation_info SET status = CASE WHEN status = 1 THEN 2 ELSE 1 END WHERE reservation_id = #{id}")
    int toggleStatus(Long id);

    @Update("UPDATE reservation_info SET status = 3 WHERE reservation_id = #{id}")
    int cancelReservation(Long id);
}
