package com.lee.mybatis1.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * Mybatis使用C3P0有点怪怪的，需要自己写个类继承UnpooledDataSourceFactory，然后指定dataSource 为ComboPooledDataSource。
 这个ComboPooledDataSource就是c3p0的数据源。
 */
public class C3P0DataSourceFactory extends UnpooledDataSourceFactory{
    public C3P0DataSourceFactory(){
        this.dataSource =new ComboPooledDataSource();
    }
}
