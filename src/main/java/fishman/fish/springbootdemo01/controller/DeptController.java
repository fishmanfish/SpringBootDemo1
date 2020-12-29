package fishman.fish.springbootdemo01.controller;

import fishman.fish.springbootdemo01.beans.Dept;
import fishman.fish.springbootdemo01.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.controller
 * @date 2020/12/23 9:34
 * @Copyright
 */
@Controller
@RequestMapping("/dept")
public class DeptController {


  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private DeptService service;

  @GetMapping("/dept/{id}")
  public String getDeptByID(@PathVariable("id") int id){

    return "";
  }

  @GetMapping("/depts")
  public String getAll(HttpSession session){

    List<Dept> depts = service.getAll();
    logger.info("所有部门信息：" + depts.toString());
    session.setAttribute("depts", depts);
    return "list";
  }
}
