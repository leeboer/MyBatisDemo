package com.lee.mybatis1.test;

import com.lee.mybatis1.entity.Order;
import com.lee.mybatis1.entity.OrderItem;
import com.lee.mybatis1.entity.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by liboar on 2019/5/29.
 */
public class TestMybatis5 {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.listOrder();
        for(Order o:list){
            System.out.println(o.getCode());
            for(OrderItem oi:o.getOrderItems()){
                System.out.println(oi.getProduct().getName()+":"+oi.getProduct().getPrice()+":"+oi.getNumber());
            }
        }
    }
}
