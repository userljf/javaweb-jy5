package com.itdr.dao;

import com.itdr.pojo.User;
import com.itdr.utils.PoolUTil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    //查找所有用户
    public List<User> selectAll(String pageSize, String pageNum) {
        /* ComboPooledDataSource co = PoolUTil.getCom();*/
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "select * from users";
        List<User> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //根据用户名和密码查找一个用户
    public User selectOne(String username, String password) {
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "select * from users where uname = ? and pwd = ?";
        User u = null;
        try {
            u = qr.query(sql,new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    //根据id查找一个用户
    public User selectOne(Integer uid) {
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "select * from users where id = ?";
        User u = null;
        try {
            u = qr.query(sql,new BeanHandler<User>(User.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    //根据id禁用一个用户
    public int updateByUid(Integer uid) {
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "update users set stats = 1 where id = ?";
        int row = 0;
        try {
            row = qr.update(sql,uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
