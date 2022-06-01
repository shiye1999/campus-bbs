package com.csp.back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csp.back.common.Result;
import com.csp.back.entity.Post;
import com.csp.back.entity.Section;

import com.csp.back.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author csp
 * @since 2022-05-06
 */
@RestController
@RequestMapping("/section")
public class SectionController {
    @Autowired
    private ISectionService sectionService;

    //新增或修改
    @PostMapping
    public boolean save(@RequestBody Section section) {
            return sectionService.saveOrUpdate(section);
    }

    //获取列表
    @GetMapping("/{sectionName}")
    public Result findByName(@PathVariable String sectionName) {
        QueryWrapper<Section> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("section_name",sectionName);
        return Result.success(sectionService.getOne(queryWrapper));
    }


    @GetMapping
    public List<Section> findAll() {
        return sectionService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
            return sectionService.removeById(id);
    }

}
