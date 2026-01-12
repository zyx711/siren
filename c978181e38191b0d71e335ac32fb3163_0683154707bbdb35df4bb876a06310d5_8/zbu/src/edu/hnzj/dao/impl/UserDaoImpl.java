package edu.hnzj.dao.impl;

import edu.hnzj.dao.UserDao;
import edu.hnzj.pojo.User;
import edu.hnzj.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public int insertUser(User user) {
        int id=user.getId();
        String password=user.getPassword();
        String name=user.getName();
        String sql="insert into user(password,name) values("+password+",'"+name+"')";
        int result= DBUtil.update(sql);
        if(result>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        int id = user.getId();
        String name = user.getName();
        String password = null;
        String sql = "update user set name='" + name + "',password='" + password + "' where id=" + id;
        password = user.getPassword();
        int result = DBUtil.update(sql);
        if (result > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteUser(User user) {
        int id=user.getId();
        String sql="delete from user where id="+id;
        int result= DBUtil.update(sql);
        return result;
    }

    @Override
    public User getUserById(int id) {
        String sql="select * from user where id="+id;
        User user=new User();
        ResultSet rs=DBUtil.query(sql);
        try {
            if(rs.next()){
                int id1=rs.getInt("id");
                String name=rs.getString("name");
                user.setId(id1);
                user.setName(name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int isLogin(User user) {
        String sql="select * from User where name=? and password=?";
        ResultSet rs= DBUtil.query(sql);
        try{
            if(rs.next()){
                return 1;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<User>();
        String sql = "select * from user";
        ResultSet rs = DBUtil.query(sql);
        try {
            while (rs.next()) {

                User user1 = new User();
                user1.setId(rs.getInt("id"));
                user1.setName(rs.getString("name"));
                user1.setPassword(rs.getString("password"));

                list.add(user1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
