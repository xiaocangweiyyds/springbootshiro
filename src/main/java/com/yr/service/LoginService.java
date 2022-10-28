package com.yr.service;

import com.yr.entity.UUser;

import java.util.List;

public interface LoginService {

    UUser login(String name);

    List<String> queryRolesByName(String username);

    List<String> queryPermissionsByName(String username);

}
