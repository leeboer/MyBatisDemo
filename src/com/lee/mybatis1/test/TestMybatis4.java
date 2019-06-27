package com.lee.mybatis1.test;

import com.lee.mybatis1.entity.Product;
import com.lee.mybatis1.entity.ProductMapper2;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by liboar on 2019/5/28.
 */
public class TestMybatis4 {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper2 mapper = sqlSession.getMapper(ProductMapper2.class);
        List<Product> list = mapper.listProduct();
        for (Product p:list) {
            System.out.println(p+"--"+p.getCategory().getId()+":"+p.getCategory().getName());
        }
    }
}
