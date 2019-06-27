package log4jTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {
    //基于类对象获取日志对象
    static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) throws Exception {
        //指定配置文件路径
        //与上一个例子不同，这里采用指定配置文件
        PropertyConfigurator.configure("D:\\leeGit\\MyBatisDemo\\src\\log4j.properties");
        //输出格式有变化，会输出哪个类，第几行
        //还会把输出信息打印到D:\leeGit\MyBatisDemo\example.log 这个位置
        for (int i = 0; i < 5000; i++) {
            logger.trace("跟踪信息");
            logger.debug("调试信息");
            logger.info("输出信息");
            logger.warn("警告信息");
            logger.error("错误信息");
            logger.fatal("致命信息");
        }
    }
}
