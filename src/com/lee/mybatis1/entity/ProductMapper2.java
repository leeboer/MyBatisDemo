package com.lee.mybatis1.entity;

import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by liboar on 2019/5/28.
 */
public interface ProductMapper2 {

    @Select("select * from product")
    @Results({
            //其他成员变量名于数据库字段相同的都不用特别说明
            @Result(property="groups" , column = "groups"),
            @Result(property="category" , column="groups" ,one=@One(select="com.lee.mybatis1.entity.CategoryMapper3.getCategory"))
    })
    public List<Product> listProduct();
}
