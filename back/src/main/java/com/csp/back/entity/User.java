package com.csp.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author csp
 * @since 2022-04-23
 */
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer authority;

    private String schoolNumber;

    private String username;

    private String password;

    private String avatar;

    private Integer commentNumber;

    private LocalDateTime lastTime;

    private LocalDateTime createTime;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public Integer getAuthority() {
        return authority;
    }

      public void setAuthority(Integer authority) {
          this.authority = authority;
      }
    
    public String getSchoolNumber() {
        return schoolNumber;
    }

      public void setSchoolNumber(String schoolNumber) {
          this.schoolNumber = schoolNumber;
      }
    
    public String getUsername() {
        return username;
    }

      public void setUsername(String username) {
          this.username = username;
      }
    
    public String getPassword() {
        return password;
    }

      public void setPassword(String password) {
          this.password = password;
      }
    
    public String getAvatar() {
        return avatar;
    }

      public void setAvatar(String avatar) {
          this.avatar = avatar;
      }
    
    public Integer getCommentNumber() {
        return commentNumber;
    }

      public void setCommentNumber(Integer commentNumber) {
          this.commentNumber = commentNumber;
      }
    
    public LocalDateTime getLastTime() {
        return lastTime;
    }

      public void setLastTime(LocalDateTime lastTime) {
          this.lastTime = lastTime;
      }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }

      public void setCreateTime(LocalDateTime createTime) {
          this.createTime = createTime;
      }

    @Override
    public String toString() {
        return "User{" +
              "id=" + id +
                  ", authority=" + authority +
                  ", schoolNumber=" + schoolNumber +
                  ", username=" + username +
                  ", password=" + password +
                  ", avatar=" + avatar +
                  ", commentNumber=" + commentNumber +
                  ", lastTime=" + lastTime +
                  ", createTime=" + createTime +
              "}";
    }
}
