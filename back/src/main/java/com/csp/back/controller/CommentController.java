package com.csp.back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csp.back.entity.Comment;

import com.csp.back.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author csp
 * @since 2022-05-25
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    //新增或修改
    @PostMapping
    public boolean save(@RequestBody Comment comment) {
            return commentService.saveOrUpdate(comment);
    }

    //获取列表
    @GetMapping
    public List<Comment> findAll() {
            return commentService.list();
    }

    //获取列表
    @GetMapping("/commentNumber/{id}")
    public Integer findCommentNumber(@PathVariable Integer id) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("creator_id",id);
        return commentService.list(queryWrapper).size();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
            return commentService.removeById(id);
    }

}
