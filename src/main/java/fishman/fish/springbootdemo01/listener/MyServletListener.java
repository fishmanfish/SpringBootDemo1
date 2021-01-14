package fishman.fish.springbootdemo01.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.listener
 * @date 2021/1/14 10:32
 * @Copyright
 */
public class MyServletListener implements ServletContextListener {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    logger.info("-------------------ServletContext STARTING-----------------");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
}
