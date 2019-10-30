package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.mapper.UserMapper;
import sample.entity.User;

import java.util.List;

/**
 * @author umellow
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> list() {
        // 强制路由主库
        //HintManager.getInstance().setMasterRouteOnly();
        return userMapper.list();
    }

    public Long add(User user) {
        return userMapper.addUser(user);
    }
}
