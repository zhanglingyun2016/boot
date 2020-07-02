package maker.service.impl;

import maker.mapper.UserMapper;
import maker.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public User getUserById(int i) {
        return userMapper.getUserByid(i);
    }
}
