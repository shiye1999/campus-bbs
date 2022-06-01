package com.csp.back.controller;

import com.csp.back.entity.Notice;

import com.csp.back.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author csp
 * @since 2022-05-05
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private INoticeService noticeService;

    //新增或修改
    @PostMapping
    public boolean save(@RequestBody Notice notice) {
            return noticeService.saveOrUpdate(notice);
    }

    //获取列表
    @GetMapping
    public List<Notice> findAll() {
            return noticeService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
            return noticeService.removeById(id);
    }

}
