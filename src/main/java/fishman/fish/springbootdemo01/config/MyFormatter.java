package fishman.fish.springbootdemo01.config;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.config
 * @date 2021/1/13 10:44
 * @Copyright
 */
public class MyFormatter implements Formatter {
  private final String[] str = {"yes", "ok", "true", "是", "on"};

  @Override
  public Boolean parse(String s, Locale locale) throws ParseException {
    if(Arrays.asList(str).contains(s)){
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }

  @Override
  public String print(Object o, Locale locale) {
    return null;
  }
}
