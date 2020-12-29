package fishman.fish.springbootdemo01.service.serviceImpl;

import fishman.fish.springbootdemo01.beans.Emp;
import fishman.fish.springbootdemo01.beans.User;
import fishman.fish.springbootdemo01.mapper.EmpMapper;
import fishman.fish.springbootdemo01.mapper.UserMapper;
import fishman.fish.springbootdemo01.service.EmpService;
import fishman.fish.springbootdemo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.service.serviceImpl
 * @date 2020/12/23 9:43
 * @Copyright
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserMapper mapper;

  @Override
  public User getUserByID(int id) {
    return mapper.getUserByID(id);
  }

  @Override
  public List<User> getAll() {
    return mapper.getAll();
  }

  @Override
  public void addUser(User user) {
    mapper.addUser(user);
  }

  @Override
  public void updUser(User user) {
    mapper.updUser(user);
  }

  @Override
  public void delUser(int userID) {
    mapper.delUser(userID);
  }

  @Override
  public String checkUser(String username, String password) {
    return mapper.checkUser(username, password);
  }
}
