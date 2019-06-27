package com.lee.mybatis1.test;

import com.lee.mybatis1.entity.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by liboar on 2019/5/30.
 */
public class TestMybatis6 {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        List<Category> cs =session.selectList("com.lee.mybatis1.CategorySpace.listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }

        session.close();
    }
}
