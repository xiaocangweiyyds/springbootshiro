package com.yr.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yr.mapper.UPermissionMapper;
import com.yr.entity.UPermission;
import com.yr.service.IUPermissionService;
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
public class UPermissionServiceImpl extends ServiceImpl<UPermissionMapper, UPermission> implements IUPermissionService {

    @Autowired
    private UPermissionMapper uPermissionMapper;

    @Override
    public void add(UPermission uPermission) {
        uPermissionMapper.insert(uPermission);
    }

    @Override
    public void delete(int id) {
        uPermissionMapper.deleteById(id);
    }

    @Override
    public void update(UPermission uPermission) {
        uPermissionMapper.updateById(uPermission);
    }

    @Override
    public UPermission getQueryById(int id) {
        return uPermissionMapper.selectById(id);
    }

    @Override
    public List<UPermission> selectPage(int currentPage, int dataNumber) {
        Page<UPermission> page = new Page<>(currentPage, dataNumber);//参数一是当前页，参数二是每页个数
        return uPermissionMapper.selectPage(page, null).getRecords();
    }

    @Override
    public int selectCount(int dataNumber) {
        int count = Math.toIntExact(uPermissionMapper.selectCount(null));
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
