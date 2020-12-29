package fishman.fish.springbootdemo01.service;

import fishman.fish.springbootdemo01.beans.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.service
 * @date 2020/12/23 9:42
 * @Copyright
 */
public interface EmpService {
  Emp getEmpByID(int id);

  List<Emp> getAll();

  void addEmp(Emp emp);

  void updEmp(Emp emp);

  void delEmp(int empID);
}
