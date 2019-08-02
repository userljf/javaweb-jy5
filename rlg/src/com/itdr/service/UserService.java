package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.User;

import java.util.List;

public class UserService {
    private UserDao ud = new UserDao();
    public ResponseCode selectAll(String pageSize, String pageNum) {
        if(pageSize == null || pageSize.equals("")){
            pageSize = "10";
        }

        if(pageNum == null || pageNum.equals("")){
            pageNum = "1";
        }

        List<User> li = ud.selectAll(pageSize,pageNum);
        //如果集合元素是空呢？
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }

    //用户登录
    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs = new ResponseCode();
        if(username == null || username.equals("") || password == null || password.equals("")){
            rs.setStatus(1);
            rs.setMag("账号活密码错误");
            return rs;
        }
        //查找是否有这样一个用户
        User u = ud.selectOne(username,password);

        //如果用户不存在
        if(u == null){
            rs.setStatus(1);
            rs.setMag("账号活密码错误");
            return rs;
        }

        //用户权限
        if(u.getType() != 1){
            rs.setStatus(1);
            rs.setMag("没有操作权限");
            return rs;
        }

        rs.setStatus(0);
        rs.setData(u);
        return rs;
    }

    //用户禁用
    public ResponseCode selectOne(String uids) {
        ResponseCode rs = new ResponseCode();
        if(uids == null || uids.equals("") ){
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        //字符串转数值
        Integer uid = null;
        try{
            uid = Integer.parseInt(uids);
        }catch(Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }

        //查找是否有这样一个用户
        User u = ud.selectOne(uid);

        //如果用户不存在
        if(u == null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }

        //用户禁用情况
        if(u.getStats() == 1){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag(Const.USER_DISABLE_MSG);
            return rs;
        }

        //禁用用户
        int row = ud.updateByUid(uid);
        if(row <= 0){
            rs.setStatus(106);
            rs.setMag("用户禁用更新失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(row);
        return rs;
    }

}