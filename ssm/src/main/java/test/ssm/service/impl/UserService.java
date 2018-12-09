package test.ssm.service.impl;

import org.springframework.stereotype.*;
import test.ssm.dao.UserDao;
import test.ssm.model.User;
import test.ssm.service.IUserService;

import javax.annotation.Resource;

@Service("userService")
public class UserService implements IUserService {
    @Resource
    private UserDao userDao;
    @Override
    public User getUserByID(int id) {
        return userDao.selectByPrimaryKey(id);
    }
}
