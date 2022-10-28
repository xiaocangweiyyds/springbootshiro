package com.yr.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Page<T> {

    private Integer totalPage;  //总页数
    private Integer currentPage; //当前页
    private List<T> list = new ArrayList<>();

}