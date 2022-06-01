package com.csp.back.controller;

import com.csp.back.entity.Post;

import com.csp.back.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author csp
 * @since 2022-06-01
 */
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    //新增或修改
    @PostMapping
    public boolean save(@RequestBody Post post) {
            return postService.saveOrUpdate(post);
    }

    //获取列表
    @GetMapping
    public List<Post> findAll() {
            return postService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
            return postService.removeById(id);
    }

}
