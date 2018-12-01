package com.itheima.jdbc;

import com.mysql.jdbc.NonRegisteringDriver;

import javax.annotation.Resources;
import java.sql.*;

/**
 * 演示解耦
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1获取驱动
      //  DriverManager.registerDriver ( new com.mysql.jdbc.Driver () );
        Class.forName ( "com.mysql.jdbc.Driver" );
        //2读取连接
        Connection conn = DriverManager.getConnection ( "jdbc:mysql://localhost:3306/eeys_jdbc","root","root" );
        //3.读取操作数据的预处理对象
        PreparedStatement statement = conn.prepareStatement ( "select * from account" );
        //4.执行sql，的到结果集
        ResultSet r = statement.executeQuery ();
        //5.遍历集合
        while (r.next ()){
            System.out.println (r.getString("name"));
        }
        //6.释放资源
        r.close ();
        statement.close ();
        conn.close ();
    }
}
