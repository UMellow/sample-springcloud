package sample.mapper;

import org.apache.ibatis.annotations.Mapper;
import sample.entity.User;

import java.util.List;

/**
 * @author umellow
 */
@Mapper
public interface UserMapper {

    Long addUser(User user);

    List<User> list();
}
