package com.cat_back;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/cat_proj?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8&allowMultiQueries=true";
        String user = "cat";
        String password = "cat0520";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("数据库连接成功！");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
