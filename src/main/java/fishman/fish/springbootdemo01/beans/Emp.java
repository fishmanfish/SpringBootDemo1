package fishman.fish.springbootdemo01.beans;

import lombok.Data;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.beans
 * @date 2020/12/22 14:08
 * @Copyright
 */
@Data
public class Emp {
  private int empID;
  private String empName;
  private String empImg;
  private int gender;
  private double money;
  private int deptID;
  private Dept dept;
}
