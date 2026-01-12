package edu.hnzj.service.impl;

import edu.hnzj.dao.UserDao;
import edu.hnzj.dao.impl.UserDaoImpl;
import edu.hnzj.pojo.User;
import edu.hnzj.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int isLogin(User user) {
        return userDao.isLogin(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
