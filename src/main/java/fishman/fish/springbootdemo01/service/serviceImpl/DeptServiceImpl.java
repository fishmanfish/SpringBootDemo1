package fishman.fish.springbootdemo01.service.serviceImpl;

import fishman.fish.springbootdemo01.beans.Dept;
import fishman.fish.springbootdemo01.beans.Emp;
import fishman.fish.springbootdemo01.mapper.DeptMapper;
import fishman.fish.springbootdemo01.mapper.EmpMapper;
import fishman.fish.springbootdemo01.service.DeptService;
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
public class DeptServiceImpl implements DeptService {

  @Autowired
  DeptMapper mapper;

  @Override
  public Dept getDeptByID(int id) {
    return mapper.getDeptByID(id);
  }

  @Override
  public List<Dept> getAll() {
    return mapper.getAll();
  }

  @Override
  public void addDept(Dept dept) {
    mapper.addDept(dept);
  }

  @Override
  public void updDept(Dept dept) {
    mapper.updDept(dept);

  }

  @Override
  public void delDept(int deptID) {
    mapper.delDept(deptID);

  }
}
