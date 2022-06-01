package com.csp.back.service.impl;

import com.csp.back.entity.Comment;
import com.csp.back.mapper.CommentMapper;
import com.csp.back.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author csp
 * @since 2022-05-25
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
