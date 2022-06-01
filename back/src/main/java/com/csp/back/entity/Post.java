package com.csp.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author csp
 * @since 2022-06-01
 */
@Getter
@Setter
@ApiModel(value = "Post对象", description = "")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String postName;

    private Integer sectionId;

    private Integer creatorId;

    private Integer clickNum;

    private LocalDateTime lastTime;

    private LocalDateTime createTime;

    private Integer isStar;


}
