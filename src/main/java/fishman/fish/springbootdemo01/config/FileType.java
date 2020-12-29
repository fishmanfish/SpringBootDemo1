package fishman.fish.springbootdemo01.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.config
 * @date 2020/12/24 14:20
 * @Copyright
 */
@Data
@Component
@ConfigurationProperties("fileup.location")
public class FileType {
  private String absolutePath;
  private String imgRelativePath;
  private String fileRelativePath;
}
