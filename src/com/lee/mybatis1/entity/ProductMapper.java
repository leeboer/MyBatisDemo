package com.lee.mybatis1.entity;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liboar on 2019/5/28.
 */
public interface ProductMapper {

    @Select("select * from Product where groups = #{cid}")
    public List<Product> listByCategory(int cid);
}
