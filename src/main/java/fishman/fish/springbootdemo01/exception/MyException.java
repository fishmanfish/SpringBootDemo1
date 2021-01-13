package fishman.fish.springbootdemo01.exception;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.exception
 * @date 2021/1/13 11:36
 * @Copyright
 */

public class MyException extends RuntimeException{

  public MyException(){
    super("发生未知错误，请联系曾哥前来解决！");
  }
}
