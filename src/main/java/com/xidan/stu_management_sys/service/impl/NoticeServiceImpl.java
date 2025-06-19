package com.xidan.stu_management_sys.service.impl;

import com.xidan.stu_management_sys.Pojo.Notice;
import com.xidan.stu_management_sys.mapper.NoticeMapper;
import com.xidan.stu_management_sys.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NoticeServiceImpl implements noticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> findAll() {
        return noticeMapper.findAll();
    }

    @Override
    public Optional<Notice> findById(Long id) {
        return noticeMapper.findById(id);
    }

    @Override
    public Notice save(Notice notice) {
        if (notice.getId() == null) {
            noticeMapper.insert(notice);
        } else {
            noticeMapper.update(notice);
        }
        return notice;
    }

    @Override
    public void deleteById(Long id) {
        noticeMapper.deleteById(id);
    }
}
