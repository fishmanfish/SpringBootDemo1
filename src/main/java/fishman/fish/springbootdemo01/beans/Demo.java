package fishman.fish.springbootdemo01.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.beans
 * @date 2020/12/22 14:09
 * @Copyright
 */
@Data
@Component
@PropertySource("classpath:demo.properties")
@ConfigurationProperties(prefix = "demo")
public class Demo {
  private String demoStr;
  private List<String> list;
  private Map<String, Object> map;
}
