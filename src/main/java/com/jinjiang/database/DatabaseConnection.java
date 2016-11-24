package com.jinjiang.database;

import com.mysql.jdbc.ConnectionGroupManager;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by jerry.zhang on 2016/11/24.
 */
public class DatabaseConnection {
    private Connection conn;

    public DatabaseConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/spring4_mybatis3?characterEncoding=utf8&useSSL=true", "root", "Jj123456");
        }
        catch(Exception e){}
        finally{

        }
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConn(){
        try {
            System.out.println("数据库连接已关闭");
            conn.close();
        }catch(Exception e)
        {}
    }
}
