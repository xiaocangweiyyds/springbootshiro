package com.yr.util;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        String name = (String) getFieldValByName("name", metaObject);
        this.strictInsertFill(metaObject, "state", Integer.class, 1);
        this.strictInsertFill(metaObject, "creator", String.class, name);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object name = getFieldValByName("name", metaObject);
        this.setFieldValByName("updater", name, metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);

    }


}
