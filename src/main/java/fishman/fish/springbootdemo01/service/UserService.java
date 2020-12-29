package fishman.fish.springbootdemo01.service;

import fishman.fish.springbootdemo01.beans.Emp;
import fishman.fish.springbootdemo01.beans.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.service
 * @date 2020/12/23 9:42
 * @Copyright
 */
public interface UserService {
  User getUserByID(int userID);

  List<User> getAll();

  void addUser(User user);

  void updUser(User user);

  void delUser(int userID);

  String checkUser(String username, String password);

}
