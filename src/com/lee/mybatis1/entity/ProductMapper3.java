package com.lee.mybatis1.entity;

import org.apache.ibatis.annotations.Select;

/**
 * Created by liboar on 2019/5/29.
 */
public interface ProductMapper3 {

    @Select("select * from product where id = #{id}")
    public Product getProductById(int id);
}
