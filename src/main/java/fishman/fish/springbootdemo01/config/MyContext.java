package fishman.fish.springbootdemo01.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
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
   * 自定义过滤器
   * @return
   */
  @Bean
  public FilterRegistrationBean filterRegistrationBean(){
    FilterRegistrationBean bean = new FilterRegistrationBean();
    bean.setFilter(new HiddenHttpMethodFilter());    //配置此过滤器配合发送PUT请求
    bean.setUrlPatterns(Arrays.asList("/*"));
    return bean;
  }
}
