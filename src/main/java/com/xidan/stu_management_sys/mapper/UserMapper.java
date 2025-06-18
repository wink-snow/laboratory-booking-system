package com.xidan.stu_management_sys.mapper;

import com.xidan.stu_management_sys.Pojo.UserInfo;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user_info")
    List<UserInfo> findAll();

    @Insert("INSERT INTO user_info (username, password, name, phone, email, points, role, avatar, created_at, updated_at) " +
            "VALUES (#{username}, #{password}, #{name}, #{phone}, #{email}, #{points}, #{role}, #{avatar}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUser(UserInfo user);


    @Select("SELECT * FROM user_info WHERE role = 2")
    List<UserInfo> findSystemAdmins();

    @Update("UPDATE user_info SET username=#{username}, password=#{password}, name=#{name}, phone=#{phone}, email=#{email}, " +
            "points=#{points}, role=#{role}, avatar=#{avatar}, updated_at=NOW() WHERE user_id=#{userId}")
    int updateUser(UserInfo user);

    @Delete("DELETE FROM user_info WHERE user_id = #{id}")
    int deleteUser(Long id);


    @Select("""
    SELECT u.*, la.lab_admin_id
                      FROM user_info u
                      LEFT JOIN lab_admin la ON u.user_id = la.user_id
                      WHERE u.role = 3
""")
    @Results({
            @Result(property = "labAdminId", column = "lab_admin_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "points", column = "points"),
            @Result(property = "role", column = "role"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at")
    })
    List<UserInfo> findLabAdmins();

    // ✅ 新增：学生（role = 1）
    @Select("SELECT * FROM user_info WHERE role = 1")
    List<UserInfo> findStudents();







}
