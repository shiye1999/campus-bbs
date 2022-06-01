package com.csp.back.entity;

import java.io.Serializable;

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
 * @since 2022-05-05
 */
@Getter
@Setter
@ApiModel(value = "Notice对象", description = "")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer publisherId;

    private Integer subscriberId;

    private Integer sectionId;

    private Integer postId;

    private Integer commentId;


}
