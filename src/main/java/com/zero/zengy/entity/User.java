package com.zero.zengy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sys_users")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private String uuid;
    private String username;
    private String password;
    private String nickName;
    private String sideMode;
    private String headerImg;
    private String baseColor;
    private String activeColor;
    private Long authorityId;
    private String phone;
    private String email;
    private Long enable;
}
