package com.lee.mybatis1.entity;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liboar on 2019/5/29.
 */
public interface OrderMapper {
    @Select("select * from orders")
    @Results({
            @Result(property = "id" , column = "id"),
            @Result(property = "orderItems" , javaType = List.class,column = "id" ,many = @Many(select = "com.lee.mybatis1.entity.OrderItemMapper.listByOrder"))
    })
    public List<Order> listOrder();
}
