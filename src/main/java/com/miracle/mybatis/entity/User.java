package com.miracle.mybatis.entity;

import com.miracle.mybatis.base.BaseEntity;

import java.time.LocalDateTime;

/**
 * @author : sungm
 * @date : 2021-01-20 16:37
 */
public class User extends BaseEntity {

    private Long userId;
    private String userName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String remarks;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
