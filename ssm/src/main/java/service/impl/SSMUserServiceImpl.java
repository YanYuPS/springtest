package service.impl;

import mapper.UserMapper;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SSMUserService;

import java.util.List;

@Service("ssmUserService")
public class SSMUserServiceImpl implements SSMUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void findAll() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }

    @Override
    public void test() {
        System.out.println("service test");
    }
}
