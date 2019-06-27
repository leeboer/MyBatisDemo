package com.lee.mybatis1.test;

import com.lee.mybatis1.entity.Category;
import com.lee.mybatis1.entity.CategoryMapper2;
import com.lee.mybatis1.entity.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Created by liboar on 2019/5/28.
 */
public class TestMybatis3 {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CategoryMapper2 categoryMapper2 = sqlSession.getMapper(CategoryMapper2.class);
        List<Category> list = categoryMapper2.listCategory();
        for (Category c: list) {
            System.out.println(c.getId()+"-"+c.getName());;
//            for (Product p:c.getProducts()) {
//                System.out.println(p);
//            }
        }
    }
}
