package fishman.fish.springbootdemo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication
@MapperScan("fishman.fish.springbootdemo01.mapper")
public class SpringbootDemo01Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootDemo01Application.class, args);
  }

}
