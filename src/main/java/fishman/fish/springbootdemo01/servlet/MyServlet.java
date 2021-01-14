package fishman.fish.springbootdemo01.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.servlet
 * @date 2021/1/14 10:19
 * @Copyright
 */
public class MyServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    logger.info("---------MyServlet STARTING---------");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    doGet(request, response);
  }
}
