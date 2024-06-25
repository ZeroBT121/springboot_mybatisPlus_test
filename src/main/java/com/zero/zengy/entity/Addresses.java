package com.zero.zengy.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author zengy
 * @since 2024-06-24
 */
@Getter
@Setter
@TableName("addresses")
@ApiModel(value = "Addresses对象", description = "")
public class Addresses implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("address_id")
    private Integer addressId;

    @TableField("user_id")
    private Integer userId;

    @TableField("street_address")
    private String streetAddress;

    @TableField("city")
    private String city;

    @TableField("state")
    private String state;

    @TableField("postal_code")
    private String postalCode;

    @TableField("country")
    private String country;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    @TableField("deleted")
    @TableLogic
    private Integer deleted;

}
