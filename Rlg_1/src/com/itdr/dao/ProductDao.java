package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

import static com.itdr.utils.PoolUtil.getCom;

public class ProductDao {
    public List<Product> selectAll ( String pageSize, String pageNum ) {
        //ComboPooledDataSource co=PoolUtil.getCom();
        QueryRunner qr=new QueryRunner(getCom());
        String sql="select * from product";
        List<Product> li=null;
        try {
            li= qr.query(sql,new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  li;

    }
   /* public Product selectOne( String username, String password ) {
        // ComboPooledDataSource co=getCom();
        QueryRunner qr=new QueryRunner(getCom());
        String sql;
        sql = "select * from users where name=? and password=?";
        Users u=null;
        try {
            u= qr.query(sql,new BeanHandler<Users>(Users.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;

    }*/

    public Product selectOne ( Integer id ) {
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());

        String sql = "select * from product where id=?";
        Product u=null;
        try {
            u= qr.query(sql,new BeanHandler<Product>(Product.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;

    }
   /* public int updateByid ( Integer id ) {
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());

        String sql = "update users set ststs=1 where id=?";
        int row=0;
        try {
            row= qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  row;

    }*/
}
