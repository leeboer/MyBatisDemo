package com.lee.mybatis1.entity;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liboar on 2019/5/28.
 */
public interface CategoryMapper2 {

    @Select("select * from category")
    @Results({
            //column表示数据库字段名，property表示成员变量名，javaType表示成员变量类型，基本类型不用特别标注
            //如果一个字段多次使用，必须标注每次查询要传递给哪个字段，这个例子就是第一行和第三行各用了一次id，如果不标注，就会查询出null
            //像name字段名和成员变量名相同，也只用了一次，就不用特别标注，框架会自动入参
            @Result(property = "id" , column = "id"),
            @Result(property = "name" , column = "name"),
            //@Results 通过@Result和@Many中调用ProductMapper.listByCategory()方法相结合，来获取一对多关系
            @Result(property = "products" , javaType = List.class , column = "id" , many = @Many(select =
                    "com.lee.mybatis1.entity.ProductMapper.listByCategory"))
    })
    public List<Category> listCategory();
}
