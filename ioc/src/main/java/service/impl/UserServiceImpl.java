package service.impl;

import dao.UserDao;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private List list;
    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void out() {
//        System.out.println("userservice");
//        userDao.out();
//        System.out.println(list);
//        System.out.println(userList);



    }
}
