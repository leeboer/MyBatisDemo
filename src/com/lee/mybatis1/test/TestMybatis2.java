package com.lee.mybatis1.test;


import com.lee.mybatis1.entity.Category;
import com.lee.mybatis1.entity.CategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by liboar on 2019/5/27.
 */
public class TestMybatis2 {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用注解方式在这里要加一行语句
        // sqlSession.getMapper(CategoryMapper.class)应该相当于根据接口方法和注解中的sql语句，使用Java反射生成一个封装好的实现类
        //内部实现了
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        //增加
        Category category = new Category();
        category.setName("公关部2");
        mapper.addCategory(category);
        sqlSession.commit();
        sqlSession.close();
//        //获取
//        Category category1 = mapper.getCategory(6);
//        System.out.println(category1);
//        //修改
//        Category category2 = new Category();
//        category2.setName("哈哈部");
//        category2.setId(6);
//        mapper.updateCategory(category2);
//        //删除
//        mapper.deleteCategory(6);
//        //获取list
//        List<Category> list = mapper.listCategory();
//        for (Category c : list) {
//            System.out.println(c);
//        }
    }
}
