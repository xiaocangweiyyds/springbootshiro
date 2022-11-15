package com.yr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class UPermission implements Serializable {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	private String url;
	private String name;
	private String mark;
	private String type;

}