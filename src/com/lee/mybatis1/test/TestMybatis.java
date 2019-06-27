package com.lee.mybatis1.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.mybatis1.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 测试
 */
public class TestMybatis {


    public static void main(String[] args) throws Exception {
        //根据配置文件mybatis-config.xml得到sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //然后根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //最后通过session的selectList方法，调用id名为listCategory的sql语句（这个语句就在Category.xml文件中）
        //执行完成后返回一个Category集合
//        List<Product> list = sqlSession.selectList("listProduct");
//        //注：session.selectList("listCategory")也可写成session.selectList("com.lee.mybatis1.CategorySpace.listCategory")
//        //前缀就是Category.xml中设置的命名表空间名字
//        for (Product c:list) {
//            System.out.println(c.getId()+":"+c.getName()+":"+c.getPrice()+":"+c.getGroups());
//        }
//
//        System.out.println("----------------------------------增---------------------------------------");
//        for (int i = 0; i < 100; i++) {
//            Category category = new Category();
//            category.setId(1);
//            category.setName("小波波"+i);
//            sqlSession.insert("addCategory100",category);
//        }
//        sqlSession.commit();
//        System.out.println("----------------------------------分页-xml方式---------------------------------------");
        //xmlWay(sqlSession,0,5);
//        System.out.println("----------------------------------分页-annotation方式---------------------------------------");
        //annotationWay(sqlSession,0,5);
//        System.out.println("----------------------------------分页-PageHelper方式---------------------------------------");
//        //该分页工具使用十分简单，只需要再查询之前调用该语句即可
//        PageHelper.offsetPage(0, 5);
//        List<Category> list = sqlSession.selectList("com.lee.mybatis1.CategorySpace.listCategory");
//
//        for(Category c:list){
//            System.out.println(c.getName());
//        }
//        PageInfo pageInfo = new PageInfo(list);
//        System.out.println("获取总数："+pageInfo.getTotal());
//        selectAll(sqlSession);
//
//        System.out.println("----------------------------------一级缓存---------------------------------------");
        Category category = sqlSession.selectOne("getCategoryOne",1);
        System.out.println(category.getName());
        //sqlSession.commit();
        Category category1 = sqlSessionFactory.openSession().selectOne("getCategoryOne",1);
        System.out.println(category1.getName());
//        System.out.println("----------------------------------删---------------------------------------");
//        sqlSession.delete("deleteProduct",1);
//        selectAll(sqlSession);
//
//
//        System.out.println("----------------------------------改---------------------------------------");
//        Product p2 = new Product(2,"雷军",8889,2);
//        sqlSession.update("updateProduct",p2);
//        selectAll(sqlSession);
//
//
//        System.out.println("----------------------------------查---------------------------------------");
//        Product p3 = sqlSession.selectOne("getProductById",4);
//        System.out.println(p3.getId()+":"+p3.getName()+":"+p3.getPrice()+":"+p3.getGroups());
//
//
//        System.out.println("----------------------------------模糊查询---------------------------------------");
//        List<Product> list1 = sqlSession.selectList("listProductByName","橘");
//        for (Product c:list1) {
//            System.out.println(c.getId()+":"+c.getName()+":"+c.getPrice()+":"+c.getGroups());
//        }
//        System.out.println("----------------------------------多条件查询---------------------------------------");
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("id",4);
//        map.put("name","橘");
//        List<Product> list2 = sqlSession.selectList("listProductByNameAndId",map);
//        for (Product c: list2) {
//            System.out.println(c.getId()+":"+c.getName()+":"+c.getPrice()+":"+c.getGroups());
//        }
//        System.out.println("----------------------------------一对多---------------------------------------");
//        List<Category> list4 = sqlSession.selectList("listCategory");
//        for (Category c:list4) {
//            System.out.println(c);
//            for (Product p:c.getProducts()) {
//                System.out.println("\t"+p);
//            }
//        }
//        System.out.println("----------------------------------多对一---------------------------------------");
//        List<Product> list5 =  sqlSession.selectList("listProduct2");
//        for (Product p:list5) {
//            System.out.println(p+":::::::"+p.getCategory());
//        }
//        System.out.println("----------------------------------多对多---------------------------------------");
//        List<Order> os = sqlSession.selectList("listOrder");
//        for (Order o : os) {
//            System.out.println(o.getCode());
//            List<OrderItem> ois= o.getOrderItems();
//            for (OrderItem oi : ois) {
//                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());}}
//        System.out.println("----------------------------------多对多 增加---------------------------------------");
//        Order o1 = sqlSession.selectOne("getOrder", 1);
//        Product p6 = sqlSession.selectOne("getProduct", 5);
//        OrderItem oi = new OrderItem();
//        oi.setProduct(p6);
//        oi.setOrder(o1);
//        oi.setNumber(200);
//        sqlSession.insert("addOrderItem", oi);
//        System.out.println("----------------------------------测试动态SQL where---------------------------------------");
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","手");
//        map.put("price",50);
//        List<Product> list6 = sqlSession.selectList("listProductChoose",map);
//        for(Product p:list6){
//            System.out.println(p.getName()+":"+p.getId());
//        }
    }
    public static void selectAll(SqlSession sqlSession) {
        List<Product> list = sqlSession.selectList("listProduct");
        //注：session.selectList("listCategory")也可写成session.selectList("com.lee.mybatis1.CategorySpace.listCategory")
        //前缀就是Category.xml中设置的命名表空间名字
        for (Product c : list) {
            System.out.println(c.getId() + ":" + c.getName() + ":" + c.getPrice() + ":" + c.getGroups());
        }
    }

    public static void xmlWay(SqlSession sqlSession,int start,int count){
        Map<String,Object> map = new HashMap<>();
        //从第几个开始
        map.put("start",start);
        //每页展示几个
        map.put("count",count);
        List<Category> list = sqlSession.selectList("listCategory100",map);
        for(Category c:list){
            System.out.println(c.getName());
        }
    }

    public static void annotationWay(SqlSession sqlSession,int start,int count){
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        List<Category> list = categoryMapper.listCategory100(start,count);
        for(Category c:list){
            System.out.println(c.getName());
        }
    }

}

