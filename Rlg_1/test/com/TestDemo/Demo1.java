package com.TestDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo1 {
    @Test
    public  void  test1() throws SQLException {
        ComboPooledDataSource cs=new ComboPooledDataSource();
        Connection conn=cs.getConnection();
        String sql="Select * from users";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs= ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(2));
        }

    }
}
