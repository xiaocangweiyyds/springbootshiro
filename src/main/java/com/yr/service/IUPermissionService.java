package com.yr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yr.entity.UPermission;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author heireng
 * @since 2021-12-03
 */
public interface IUPermissionService extends IService<UPermission> {

    void add(UPermission uPermission);

    void delete(int id);

    void update(UPermission uPermission);

    UPermission getQueryById(int id);

    List<UPermission> selectPage(int currentPage, int dataNumber);

    int selectCount(int pageNo);

}
