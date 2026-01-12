package edu.hnzj.service;

import edu.hnzj.pojo.User;

import java.util.List;

public interface UserService {
    int insertUser(User user);
    int updateUser(User user);
    int isLogin(User user);

    User getUserById(int id);
    List<User> getAllUsers();
    int deleteUser(User user);


}
