package com.cat_back;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisConnectionTest {
    public static void main(String[] args) {
        String resource = "mybatis-conf.xml"; // 确保配置文件在 classpath 下的此路径
        try {
            // 加载 MyBatis 配置文件
            Reader reader = Resources.getResourceAsReader(resource);
            // 构建 SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            // 打开一个 SqlSession（会自动测试数据库连接及配置加载）
            try (SqlSession session = sqlSessionFactory.openSession()) {
                System.out.println("MyBatis connection successful!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("MyBatis connection failed: " + e.getMessage());
        }
    }
}
