package fishman.fish.springbootdemo01;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author
 * @Package fishman.fish.springbootdemo01
 * @date 2021/1/14 12:02
 * @Copyright
 */
public class ServletInitializer extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(SpringbootDemo01Application.class);
  }
}
