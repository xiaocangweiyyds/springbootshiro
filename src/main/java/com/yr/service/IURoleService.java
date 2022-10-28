package com.yr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yr.entity.URole;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author heireng
 * @since 2021-12-03
 */
public interface IURoleService extends IService<URole> {

    void add(URole uRole);

    void delete(int id);

    void update(URole uRole);

    URole getQueryById(int id);

    List<URole> selectPage(int currentPage, int dataNumber);

    int selectCount(int pageNo);

}
