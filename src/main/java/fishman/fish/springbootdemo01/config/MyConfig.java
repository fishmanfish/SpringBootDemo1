package fishman.fish.springbootdemo01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.config
 * @date 2020/12/23 11:11
 * @Copyright
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

  @Autowired
  private FileType fileType;

  /**
   * 视图映射器
   * */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/index.html").setViewName("index");
  }

  /**
   * 拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MyIntercept()).addPathPatterns("/**").excludePathPatterns("/", "/index.html", "/user/login","/asserts/**", "/webjars/**");

  }

  /**
   * 解决图片上传无法立即显示，而需要重启才能访问的问题。
   * 这是因为对服务器的保护措施导致的，服务器不能对外部暴露真实的资源路径，需要配置 虚拟路径映射访问。
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry){
    //获取文件的真实路径
    String path = fileType.getAbsolutePath();
    registry.addResourceHandler(fileType.getImgRelativePath() + "/**").addResourceLocations("file:" + path);  //上传图片的虚拟路径
    registry.addResourceHandler(fileType.getFileRelativePath() + "/**").addResourceLocations("file:" + path); //上传文件的虚拟路径
  }

  @Bean
  public LocaleResolver localeResolver(){
    return new MyLocalResolve();
  }

  @Bean
  public Formatter formatter(){
    return new MyFormatter();
  }

}
