package com.lee.mybatis1.entity;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liboar on 2019/5/29.
 */
public interface OrderItemMapper {

    @Select("select * from order_item where oid = #{oid}")
    @Results({
            //这里没有标注order成员变量的赋值，因为用不到，所以为null
            @Result(property = "product" , column = "pid" , one = @One(select = "com.lee.mybatis1.entity.ProductMapper3.getProductById"))
    })
    public List<OrderItem> listByOrder(int oid);
}
