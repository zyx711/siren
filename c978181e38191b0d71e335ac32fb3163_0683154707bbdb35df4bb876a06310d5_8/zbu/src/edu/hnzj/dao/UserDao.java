package edu.hnzj.dao;

import edu.hnzj.pojo.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    int isLogin(User user);
}
