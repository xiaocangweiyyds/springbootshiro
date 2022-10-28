package com.yr.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yr.mapper.UUserMapper;
import com.yr.entity.UUser;
import com.yr.service.IUUserService;
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
public class UUserServiceImpl extends ServiceImpl<UUserMapper, UUser> implements IUUserService {

    @Autowired
    private UUserMapper uUserMapper;

    @Override
    public void add(UUser uUser) {
        uUserMapper.insert(uUser);
    }

    @Override
    public void delete(int id) {
        uUserMapper.deleteById(id);
    }

    @Override
    public void update(UUser uUser) {
        uUserMapper.updateById(uUser);
    }

    @Override
    public UUser getQueryById(int id) {
        return uUserMapper.selectById(id);
    }

    @Override
    public List<UUser> selectPage(int currentPage, int dataNumber) {
        Page<UUser> page = new Page<>(currentPage, dataNumber);//参数一是当前页，参数二是每页个数
        return uUserMapper.selectPage(page, null).getRecords();
    }

    @Override
    public int selectCount(int dataNumber) {
        int count = Math.toIntExact(uUserMapper.selectCount(null));
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
