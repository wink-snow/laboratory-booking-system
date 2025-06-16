package com.xidan.stu_management_sys.mapper;

import com.xidan.stu_management_sys.Pojo.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper {
    @Select("SELECT * FROM user_info WHERE username = #{username} AND password = #{password} AND role = #{role}")
    UserInfo findByUsernamePasswordAndRole(@Param("username") String username,
                                           @Param("password") String password,
                                           @Param("role") int role);

    /** 根据用户名查重 */
    @Select("SELECT * FROM user_info WHERE username = #{username}")
    UserInfo findByUsername(@Param("username") String username);

    @Insert("INSERT INTO user_info (username, password, name, phone, email, points, role, avatar, created_at, updated_at) " +
            "VALUES (#{username}, #{password}, #{name}, #{phone}, #{email}, #{points}, #{role}, #{avatar}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUser(UserInfo user);


}
