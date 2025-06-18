package com.xidan.stu_management_sys.service;

import com.xidan.stu_management_sys.Pojo.Notice;

import java.util.List;
import java.util.Optional;

public interface noticeService {
    List<Notice> findAll();
    Optional<Notice> findById(Long id);
    Notice save(Notice notice);
    void deleteById(Long id);
}
