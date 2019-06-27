package com.lee.mybatis1.entity;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 这个类就相当于Category.xml，都是一样的
 * 要想使用这个类也需要在mybatis-config.xml中配置
 */
public interface CategoryMapper {

    //@Insert("insert into category (name) values (#{name})")
    @InsertProvider(type = CategoryDynaSqlProvider.class, method = "add")
    public int addCategory(Category category);

    //@Delete("delete from category where id = #{id}")
    @DeleteProvider(type = CategoryDynaSqlProvider.class, method = "delete")
    public void deleteCategory(int i);

    //@Select("select * from category where id = #{id}")
    @SelectProvider(type = CategoryDynaSqlProvider.class, method = "get")
    public Category getCategory(int id);

    //@Update("update category set name = #{name} where id = #{id}")
    @UpdateProvider(type = CategoryDynaSqlProvider.class, method = "update")
    public int updateCategory(Category category);

    //@Select("select * from category")
    @SelectProvider(type = CategoryDynaSqlProvider.class, method = "list")
    public List<Category> listCategory();

    @Select(" select * from category limit #{start},#{count}")
    public List<Category> listCategory100(@Param("start") int start,@Param("count") int count);

}
