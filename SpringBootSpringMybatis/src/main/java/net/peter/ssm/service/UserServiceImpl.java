package net.peter.ssm.service;
/*
 * @Author: Haoran
 * @Date: 2021/3/7 9:42
 * @Description:
 */

import net.peter.ssm.dao.UserMapper;
import net.peter.ssm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {

        userMapper.save(user);

        return 1;
    }
}
