package fishman.fish.springbootdemo01.beans;

import lombok.Data;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.beans
 * @date 2020/12/23 15:47
 * @Copyright
 */
@Data
public class User {
  private int userID;
  private String sname;
  private String username;
  private String password;
  private int empID;
}
