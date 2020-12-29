package fishman.fish.springbootdemo01.mapper;

import fishman.fish.springbootdemo01.beans.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.mapper
 * @date 2020/12/23 9:44
 * @Copyright
 */
public interface UserMapper {

  User getUserByID(@Param("userID") int userID);

  List<User> getAll();

  void addUser(User user);

  void updUser(User user);

  void delUser(@Param("userID") int userID);

  String checkUser(@Param("username") String username, @Param("password") String password);

}
