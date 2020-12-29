package fishman.fish.springbootdemo01.mapper;

import fishman.fish.springbootdemo01.beans.Dept;
import fishman.fish.springbootdemo01.beans.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.mapper
 * @date 2020/12/23 9:44
 * @Copyright
 */
public interface DeptMapper {

  Dept getDeptByID(@Param("deptID") int deptID);

  List<Dept> getAll();

  void addDept(Dept dept);

  void updDept(Dept dept);

  void delDept(@Param("deptID") int deptID);

}
