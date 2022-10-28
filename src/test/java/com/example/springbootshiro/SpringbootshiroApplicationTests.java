package com.example.springbootshiro;

import com.yr.service.IUUserService;
import com.yr.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootshiroApplicationTests {

    @Autowired
    private LoginService loginService;

    @Test
    void contextLoads() {
//        System.out.println(iuUserService.login("root"));
//        System.out.println(loginService.queryRolesByName("admin"));
//        System.out.println(loginService.queryPermissionsByName("admin"));
    }

}
