package com.yr.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yr.mapper.URoleMapper;
import com.yr.entity.URole;
import com.yr.service.IURoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author heireng
 * @since 2021-12-03
 */
@Service
public class URoleServiceImpl extends ServiceImpl<URoleMapper, URole> implements IURoleService {

    @Autowired
    private URoleMapper uRoleMapper;

    @Override
    public void add(URole uRole) {
        uRoleMapper.insert(uRole);
    }

    @Override
    public void delete(int id) {
        uRoleMapper.deleteById(id);
    }

    @Override
    public void update(URole uRole) {
        uRoleMapper.updateById(uRole);
    }

    @Override
    public URole getQueryById(int id) {
        return uRoleMapper.selectById(id);
    }

    @Override
    public List<URole> selectPage(int currentPage, int dataNumber) {
        Page<URole> page = new Page<>(currentPage, dataNumber);//参数一是当前页，参数二是每页个数
        return uRoleMapper.selectPage(page, null).getRecords();
    }

    @Override
    public int selectCount(int dataNumber) {
        int count = Math.toIntExact(uRoleMapper.selectCount(null));
        int pageCount = count / dataNumber;
        if (count % dataNumber != 0) { //没除断 就要多加1页
            pageCount = pageCount + 1;
        }
        if (pageCount == 0) {
            pageCount = 1;
        }
        return pageCount;
    }

}
