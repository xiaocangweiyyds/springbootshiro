package com.yr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yr.entity.UUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author heireng
 * @since 2021-12-07
 */
@Mapper
public interface UUserMapper extends BaseMapper<UUser> {

    UUser login(String name);

    List<String> queryRolesByName(String username);

    List<String> queryPermissionsByName(String username);

}
