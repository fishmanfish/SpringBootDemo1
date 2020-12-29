package fishman.fish.springbootdemo01.controller;

import fishman.fish.springbootdemo01.beans.Emp;
import fishman.fish.springbootdemo01.beans.User;
import fishman.fish.springbootdemo01.service.EmpService;
import fishman.fish.springbootdemo01.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.controller
 * @date 2020/12/23 9:34
 * @Copyright
 */
@Controller
@RequestMapping("/user")
public class UserController {


  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserService service;

  @PostMapping("/login")
  public String login(String username, String password, String lang, HttpSession session) {

    if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
      String sname = service.checkUser(username, password);
      if (sname == null) {
        session.setAttribute("msg", "用户名或密码错误");
        return "redirect:/index.html";
      } else {
        session.setAttribute("sname", sname);
        session.getServletContext().setAttribute("lang", lang);
        return "redirect:/emp/emps";
      }
    } else if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
      session.setAttribute("msg", "用户名或密码不能为空");
      return "redirect:/index.html";
    }
    return "redirect:/index.html";
  }

  @GetMapping("/loginout")
  public String loginout(HttpSession session) {
    //清除Session
    session.setMaxInactiveInterval(0);
    session.invalidate();
    return "redirect:/index.html";
  }

  @GetMapping("/user/{id}")
  public String getUserByID(@PathVariable("id") int id) {

    return "";
  }

  @GetMapping("/users")
  public String getAll(HttpSession session) {

    List<User> users = service.getAll();
    logger.info("所有用户信息：" + users.toString());
    session.setAttribute("users", users);
    return "list";
  }
}
