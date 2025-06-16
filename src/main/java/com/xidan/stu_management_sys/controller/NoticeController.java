package com.xidan.stu_management_sys.controller;


import com.xidan.stu_management_sys.Pojo.Notice;
import com.xidan.stu_management_sys.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private noticeService noticeService;

    @GetMapping
    public List<Notice> getAllNotices() {
        return noticeService.findAll();
    }

    @PostMapping
    public Notice createNotice(@RequestBody Notice notice) {
        return noticeService.save(notice);
    }

    @PutMapping("/{id}")
    public Notice updateNotice(@PathVariable Long id, @RequestBody Notice updated) {
        return noticeService.findById(id)
                .map(n -> {
                    n.setTitle(updated.getTitle());
                    n.setContent(updated.getContent());
                    n.setCreatedTime(updated.getCreatedTime());
                    n.setCreator(updated.getCreator());
                    return noticeService.save(n);
                })
                .orElseThrow(() -> new RuntimeException("公告未找到"));
    }

    @DeleteMapping("/{id}")
    public void deleteNotice(@PathVariable Long id) {
        noticeService.deleteById(id);
    }


}
