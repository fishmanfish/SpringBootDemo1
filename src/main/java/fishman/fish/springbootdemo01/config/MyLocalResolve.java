package fishman.fish.springbootdemo01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.config
 * @date 2020/12/24 9:33
 * @Copyright
 * 自定义国际化语言解析器
 */

public class MyLocalResolve implements LocaleResolver {

  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    Locale locale = Locale.getDefault();
    String lang = request.getParameter("lang") == null ? (String) request.getSession().getServletContext().getAttribute("lang")
            : request.getParameter("lang");
    if(StringUtils.hasLength(lang)){
      locale = new Locale(lang.split("_")[0], lang.split("_")[1]);
      request.setAttribute("lang", lang);
    }
    return locale;
  }

  @Override
  public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

  }
}
