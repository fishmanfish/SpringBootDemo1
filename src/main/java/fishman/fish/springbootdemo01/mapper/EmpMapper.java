package fishman.fish.springbootdemo01.mapper;

import fishman.fish.springbootdemo01.beans.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.mapper
 * @date 2020/12/23 9:44
 * @Copyright
 */
public interface EmpMapper {

  Emp getEmpByID(@Param("empID") int empID);

  List<Emp> getAll();

  void addEmp(Emp emp);

  void updEmp(Emp emp);

  void delEmp(@Param("empID") int empID);

}
