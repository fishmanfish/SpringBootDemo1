package fishman.fish.springbootdemo01.controller;

import com.alibaba.fastjson.JSONObject;
import fishman.fish.springbootdemo01.beans.Dept;
import fishman.fish.springbootdemo01.config.FileType;
import fishman.fish.springbootdemo01.util.StrEncryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


import java.io.File;
/**
 * @author
 * @Package fishman.fish.springbootdemo01.controller
 * @date 2020/12/23 9:34
 * @Copyright
 */
@Controller
@RequestMapping("/file")
public class FileUpController {


  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private FileType fileType;

  @PostMapping("/imgup")
  @ResponseBody
  public JSONObject imgUp(@RequestParam(value = "file", required = false) MultipartFile[] files){
    JSONObject json = new JSONObject();
    String checkImgLocation = "";   //返回文件上传的相对路径供前台展示
    try {
      String descPath = fileType.getAbsolutePath() + fileType.getImgRelativePath();  //从配置文件中获取文件上传的路径

      for (MultipartFile file : files) {
        logger.info("图片上传路径：" + descPath);

        String fileName = file.getOriginalFilename();  //获取文件名
        File descFile = new File(descPath, fileName);
        if (!descFile.getParentFile().exists()) {  //判断父级路径存不存在
          descFile.getParentFile().mkdirs();   //创建父级路径
          descFile.createNewFile();   //创建当前文件
        }
        file.transferTo(descFile);  //开始上传
        checkImgLocation = checkImgLocation.concat(fileType.getImgRelativePath() + fileName + "|");
      }
      if(StringUtils.hasLength(checkImgLocation)){
        checkImgLocation = checkImgLocation.substring(0, checkImgLocation.lastIndexOf("|"));
      }
    } catch (Exception e){
      json.put("flag", "1");
      json.put("msg", "图片上传失败");
      logger.error(e.getMessage());
    }
    if(StringUtils.hasLength(checkImgLocation)){
      json.put("msg", "未选择图片");
      json.put("flag", "1");
    }
    json.put("path", checkImgLocation);
    json.put("flag", "0");
    return json;
  }

  @PostMapping("/delimg")
  @ResponseBody
  public JSONObject delImg(@RequestParam(value = "path", required = false) String path){

    JSONObject json = new JSONObject();
    if(StringUtils.hasLength(path)){
      json.put("flag", "1");
      json.put("msg", "图片删除失败");
    }
    try {
      String descPath = fileType.getAbsolutePath() + path;  //从配置文件中获取文件上传的路径
      logger.info("删除图片路径：" + descPath);
      File file = new File(descPath);
      if(file.exists() && file.isFile()){
        file.delete();
      }
    } catch (Exception e){
      json.put("flag", "1");
      json.put("msg", "图片删除失败");
      logger.error(e.getMessage());
    }
    json.put("msg", "删除成功");
    json.put("flag", "0");
    return json;
  }

}
