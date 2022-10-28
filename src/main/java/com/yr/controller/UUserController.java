package com.yr.controller;

import com.yr.entity.Page;
import com.yr.entity.UUser;
import com.yr.service.IUUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author heireng
 * @since 2021-12-03
 */
@Controller
@RequestMapping("user")
public class UUserController {

    @Autowired
    private IUUserService iuUserService;

    //添加
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String add(UUser uUser) {
        uUser.setPswd(new SimpleHash("MD5", uUser.getPswd(), new Md5Hash(uUser.getNickname()), 1024).toString());
        iuUserService.add(uUser);
        System.out.println(uUser + "------------------");
        return "redirect:/user/list";
    }

    //from标签需要
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        map.put("user", new UUser());
        return "user/compile";
    }

    //删除
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        System.out.println("----------------delete");
        iuUserService.delete(id);
        return "redirect:/user/list";
    }

    //修改
    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public String update(@ModelAttribute UUser uUser) {
        uUser.setPswd(new SimpleHash("MD5", uUser.getPswd(), new Md5Hash(uUser.getNickname()), 1024).toString());
        iuUserService.update(uUser);
        return "list";
    }

    //修改回显
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String getUpdate(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("user", iuUserService.getQueryById(id));
        return "user/compile";
    }

    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        if (id != null) {
            map.put("user", iuUserService.getQueryById(id));
        }
    }

    //查询
    @RequestMapping(value = "list")
    public String select() {
        return "user/list";
    }

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Page<UUser> listPage(String pn) {
        int currentPage = 1;
        int dataNumber = 5;

        try {
            currentPage = Integer.parseInt(pn);
        } catch (Exception e) {
        }

        Page<UUser> page = new Page<>();
        page.setCurrentPage(currentPage);
        page.setTotalPage(iuUserService.selectCount(dataNumber));
        page.setList(iuUserService.selectPage(currentPage, dataNumber));
        System.out.println(page);
        return page;
    }

}

