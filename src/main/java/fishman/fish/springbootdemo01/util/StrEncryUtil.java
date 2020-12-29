package fishman.fish.springbootdemo01.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.util.Debug;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author
 * @Package fishman.fish.springbootdemo01.util
 * @date 2020/12/24 11:29
 * @Copyright
 */
public class StrEncryUtil {


  /*public static String MD5(){
    return MD5();
  }  */

  public static String MD5() {
    String result = "", sourceStr = UUID.randomUUID().toString();
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(sourceStr.getBytes());
      byte b[] = md.digest();
      int i;
      StringBuffer buf = new StringBuffer("");
      for (int offset = 0; offset < b.length; offset++) {
        i = b[offset];
        if (i < 0)
          i += 256;
        if (i < 16)
          buf.append("0");
        buf.append(Integer.toHexString(i));
      }
      result = buf.toString();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return result;
  }
}
