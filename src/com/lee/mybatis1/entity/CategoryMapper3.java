package com.lee.mybatis1.entity;

import org.apache.ibatis.annotations.Select;

/**
 * Created by liboar on 2019/5/28.
 */
public interface CategoryMapper3 {

    @Select("select * from category where id = #{id}")
    public Category getCategory(int id);
}
