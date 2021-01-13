package fishman.fish.springbootdemo01.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.exception
 * @date 2021/1/13 11:38
 * @Copyright
 */

@ControllerAdvice   //配置全局异常处理机制
public class MyExceptionHandler {

  @ExceptionHandler(MyException.class)
  public String handlerException(Exception e, HttpServletRequest request){

    request.setAttribute("javax.servlet.error.status_code", 500);
    request.setAttribute("code", "error001");
    request.setAttribute("msg", "发生未知错误，请联系曾哥解决！");
    return "forward:/error";
  }
}
