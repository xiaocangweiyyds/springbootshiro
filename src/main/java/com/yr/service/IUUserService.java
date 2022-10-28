package com.yr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yr.entity.UUser;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author heireng
 * @since 2021-12-03
 */
public interface IUUserService extends IService<UUser> {

    void add(UUser uUser);

    void delete(int id);

    void update(UUser uUser);

    UUser getQueryById(int id);

    List<UUser> selectPage(int currentPage, int dataNumber);

    int selectCount(int pageNo);

}
