package fishman.fish.springbootdemo01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.config
 * @date 2020/12/24 16:43
 * @Copyright
 */
//@Configuration
public class MyMultipartResolve{

  @Bean
  public CommonsMultipartResolver  multipartResolver(){
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    resolver.setDefaultEncoding("UTF-8");
    resolver.setResolveLazily(true);
    resolver.setMaxInMemorySize(40960);
    //上传文件大小 5M 5*1024*1024
    resolver.setMaxUploadSize(100 * 1024 * 1024);
    return resolver;
  }
}
