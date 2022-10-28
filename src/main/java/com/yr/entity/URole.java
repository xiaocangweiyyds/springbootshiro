package com.yr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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
public class URole  implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String type;
    private List<UPermission> permissions = new LinkedList<>();

}