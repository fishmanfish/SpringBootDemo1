package fishman.fish.springbootdemo01;

import fishman.fish.springbootdemo01.beans.Demo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootDemo01ApplicationTests {

  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  ApplicationContext context;

  @Test
  void test1(){
    logger.trace("这是TRACE级别的日志记录,跟踪某些信息");
    logger.debug("这是DEBUG级别的日志记录,应用调试信息");
    logger.info("这是INFO级别的日志记录,自定义日志信息");
    logger.warn("这是WARN级别的日志记录,警告的日志信息");
    logger.error("这是ERROR级别的日志记录,错误日志信息");
  }

  @Test
  void test2() {
    Demo d = (Demo) context.getBean("demo");
    logger.info(d.toString());
  }

}
