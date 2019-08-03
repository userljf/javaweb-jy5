package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Product;
import com.itdr.pojo.Users;

import java.util.List;

public class ProductService {
    private ProductDao pd =new ProductDao();
    private  UserDao ud =new UserDao();
    public ResponseCode selectAll( String pageSize, String pageNum ) {
        if(pageSize==null||pageSize.equals("")){
            pageSize="10";
        }
        if(pageNum==null||pageNum.equals("")){
            pageNum="1";
        }


        List<Product> li=pd.selectAll(pageSize,pageNum);
        ResponseCode rs=new ResponseCode();
        rs.setData(li);
        return  rs;
    }
    public ResponseCode selectOne ( String username, String password ){
        ResponseCode rs =new ResponseCode();
        if(username==null||username.equals("")||password==null||password.equals("")){
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return rs;
        }
        Users u= ud.selectOne(username,password);
        if(u==null){
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return  rs;
        }

        rs.setStatus(0);
        rs.setData(u);

        return rs;
    }


}
