package fishman.fish.springbootdemo01.service.serviceImpl;

import fishman.fish.springbootdemo01.beans.Emp;
import fishman.fish.springbootdemo01.mapper.EmpMapper;
import fishman.fish.springbootdemo01.service.EmpService;
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
public class EmpServiceImpl implements EmpService {

  @Autowired
  EmpMapper mapper;

  @Override
  public Emp getEmpByID(int id) {
    return mapper.getEmpByID(id);
  }

  @Override
  public List<Emp> getAll() {
    return mapper.getAll();
  }

  @Override
  public void addEmp(Emp emp) {
    mapper.addEmp(emp);
  }

  @Override
  public void updEmp(Emp emp) {
    mapper.updEmp(emp);
  }

  @Override
  public void delEmp(int empID) {
    mapper.delEmp(empID);
  }
}
