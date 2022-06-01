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
@ApiModel(value = "Relation对象", description = "")
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer publisherId;

    private Integer subscriberId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Integer subscriberId) {
        this.subscriberId = subscriberId;
    }
}
