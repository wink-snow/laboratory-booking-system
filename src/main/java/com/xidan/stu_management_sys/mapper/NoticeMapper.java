package com.xidan.stu_management_sys.mapper;

import com.xidan.stu_management_sys.Pojo.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Mapper
public interface NoticeMapper {
    @Select("SELECT * FROM notice")
    List<Notice> findAll();

    @Select("SELECT * FROM notice WHERE id = #{id}")
    Optional<Notice> findById(Long id);

    @Insert("INSERT INTO notice (title, content, created_time, creator) " +
            "VALUES (#{title}, #{content}, #{createdTime}, #{creator})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Notice notice);

    @Update("UPDATE notice SET title = #{title}, content = #{content}, created_time = #{createdTime}, creator = #{creator} WHERE id = #{id}")
    int update(Notice notice);

    @Delete("DELETE FROM notice WHERE id = #{id}")
    int deleteById(Long id);
}
