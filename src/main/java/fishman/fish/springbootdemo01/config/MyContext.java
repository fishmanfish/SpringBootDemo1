package fishman.fish.springbootdemo01.config;

import fishman.fish.springbootdemo01.listener.MyServletListener;
import fishman.fish.springbootdemo01.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Arrays;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.config
 * @date 2021/1/13 11:05
 * @Copyright
 */
@Configuration
public class MyContext {

  /**
   * 注册过滤器
   * @return
   */
  @Bean
  public FilterRegistrationBean filterRegistrationBean(){
    FilterRegistrationBean bean = new FilterRegistrationBean();
    bean.setFilter(new HiddenHttpMethodFilter());    //配置此过滤器配合发送PUT请求
    bean.setUrlPatterns(Arrays.asList("/*"));
    return bean;
  }


  /**
   * 注册Servlet
   */
  @Bean
  public ServletRegistrationBean servletRegistrationBean(){
    ServletRegistrationBean bean = new ServletRegistrationBean();
    return bean;
  }

  /**
   * 注册监听器
   */
  @Bean
  public ServletListenerRegistrationBean servletListenerRegistrationBean(){
    ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new MyServletListener());
    return bean;
  }
}
