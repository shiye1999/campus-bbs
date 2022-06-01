package com.csp.back.service.impl;

import com.csp.back.entity.Post;
import com.csp.back.mapper.PostMapper;
import com.csp.back.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author csp
 * @since 2022-06-01
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
