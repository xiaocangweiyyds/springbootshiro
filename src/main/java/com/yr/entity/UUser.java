package com.yr.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author heireng
 * @since 2021-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UUser implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
	private Long id;
    private String nickname;
    private String email;
    private String pswd;
    private Long status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastLoginTime;


}