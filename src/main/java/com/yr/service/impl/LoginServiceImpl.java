package com.yr.service.impl;

import com.yr.entity.UPermission;
import com.yr.entity.UUser;
import com.yr.mapper.UUserMapper;
import com.yr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UUserMapper uUserMapper;

    @Override
    public UUser login(String username) {
        return uUserMapper.login(username);
    }

    @Override
    public List<String> queryRolesByName(String username) {
        return uUserMapper.queryRolesByName(username);
    }

    @Override
    public List<UPermission> queryPermissionsByMark(String username) {
        return uUserMapper.queryPermissionsByMark(username);
    }

}
