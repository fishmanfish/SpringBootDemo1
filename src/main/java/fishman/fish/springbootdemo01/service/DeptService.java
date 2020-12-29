package fishman.fish.springbootdemo01.service;

import fishman.fish.springbootdemo01.beans.Dept;
import fishman.fish.springbootdemo01.beans.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.service
 * @date 2020/12/23 9:42
 * @Copyright
 */
public interface DeptService {

  Dept getDeptByID(int deptID);

  List<Dept> getAll();

  void addDept(Dept dept);

  void updDept(Dept dept);

  void delDept(int deptID);

}
