package fishman.fish.springbootdemo01.controller;

import fishman.fish.springbootdemo01.beans.Dept;
import fishman.fish.springbootdemo01.beans.Emp;
import fishman.fish.springbootdemo01.config.FileType;
import fishman.fish.springbootdemo01.exception.MyException;
import fishman.fish.springbootdemo01.service.DeptService;
import fishman.fish.springbootdemo01.service.EmpService;
import fishman.fish.springbootdemo01.util.StrEncryUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.controller
 * @date 2020/12/23 9:34
 * @Copyright
 */
@Controller
@RequestMapping("/emp")
public class EmpController {


  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private FileType fileType;
  @Autowired
  private EmpService empService;
  @Autowired
  private DeptService deptService;

  @GetMapping("/add")
  public String addEmp(Map<String, Object> map, HttpSession session){
    List<Dept> depts = deptService.getAll();
    logger.info("所有部门信息：" + depts.toString());
    map.put("depts", depts);
    map.put("optype", "add");
    session.setAttribute("token", StrEncryUtil.MD5());
    return "/emp/empinfo";
  }

  @GetMapping("/upd/{id}")
  public String editEmp(@PathVariable("id") int id, Map<String, Object> map, HttpSession session){
    Emp emp = empService.getEmpByID(id);
    List<Dept> depts = deptService.getAll();
    logger.info("所有部门信息：" + depts.toString());
    logger.info("当前编辑的员工信息：" + emp.toString());
    map.put("depts", depts);
    map.put("emp", emp);
    map.put("empImgs", StringUtils.hasLength(emp.getEmpImg()) ? emp.getEmpImg().split(";") : "");
    map.put("optype", "edit");
    session.setAttribute("token", StrEncryUtil.MD5());
    return "/emp/empinfo";
  }

  @GetMapping("/check/{id}")
  public String checkEmp(@PathVariable("id") int id, Map<String, Object> map){
    Emp emp = empService.getEmpByID(id);
    List<Dept> depts = deptService.getAll();
    logger.info("所有部门信息：" + depts.toString());
    map.put("depts", depts);
    map.put("emp", emp);
    map.put("empImgs", StringUtils.hasLength(emp.getEmpImg()) ? emp.getEmpImg().split(";") : "");
    map.put("optype", "check");
    return "/emp/empinfo";
  }

  @PostMapping("/saveEmp")
  public String addEmp(Emp emp, String token, HttpSession session){
    logger.info("表单提交的token：" + token);
    String tokenSession = (String) session.getAttribute("token");
    logger.info("session中的token：" + tokenSession);
    if(tokenSession != null && tokenSession.equals(token)) {
      if (emp != null) {  //新增
        if (emp.getEmpID() == 0) {
          logger.info("新增的员工信息：" + emp.toString());
          empService.addEmp(emp);
        } else {//更新
          logger.info("修改的员工信息：" + emp.toString());
          empService.updEmp(emp);
        }
        session.removeAttribute("token"); //移除token
      }
    }

    return "redirect:/emp/emps";
  }

  @PutMapping("/saveEmp")
  public String updEmp(Emp emp, String token, HttpSession session){
    logger.info("表单提交的token：" + token);
    String tokenSession = (String) session.getAttribute("token");
    logger.info("session中的token：" + tokenSession);
    if(tokenSession != null && tokenSession.equals(token)) {
      if (emp != null) {  //新增
        if (emp.getEmpID() == 0) {
          logger.info("新增的员工信息：" + emp.toString());
          empService.addEmp(emp);
        } else {//更新
          logger.info("修改的员工信息：" + emp.toString());
          empService.updEmp(emp);
        }
        session.removeAttribute("token"); //移除token
      }
    }

    return "redirect:/emp/emps";
  }

  @GetMapping("/delEmpByID/{id}")
  public String delEmpByID(@PathVariable("id") int id){
    String empImgPath = fileType.getAbsolutePath() + empService.getEmpByID(id).getEmpImg();
    empService.delEmp(id);
    File file = new File(empImgPath);
    if(file.exists() && file.isFile()){
      file.delete();
    }
    return "redirect:/emp/emps";
  }

  @GetMapping("/emps")
  public String getAll(HttpSession session){
    List<Emp> emps = empService.getAll();
    if(emps != null){
      throw new MyException();
    }
    logger.info("所有员工信息：" + emps.toString());
    session.setAttribute("emps", emps);
    return "emp/list";
  }
}
