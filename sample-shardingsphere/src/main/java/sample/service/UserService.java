package sample.service;

import sample.entity.User;

import java.util.List;

/**
 * @author umellow
 */
public interface UserService {

    List<User> list();

    Long add(User user);
}
