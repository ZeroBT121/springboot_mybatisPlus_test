package com.zero.zengy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author zengy
 * @since 2024-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Users对象", description = "")
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String password;

    private String email;

    private String phone;

    private Integer addressId;

    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Integer getId() {
        return this.userId;
    }


//    @Override
//    protected Serializable pkVal() {
//        return this.userId;
//    }

}
