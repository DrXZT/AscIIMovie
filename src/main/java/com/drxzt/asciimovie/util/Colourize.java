package com.drxzt.asciimovie.util;

/**
 * className Colourize
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/6/1 18:10
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.util.Base64Util;
import com.drxzt.asciimovie.entities.FilesDo;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import static com.drxzt.asciimovie.commous.Constants.SERVER_DATA_URL;

/**
 * 图像处理——黑白图像上色
 */
@Component
public class Colourize {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public FilesDo colourize(FilesDo filesDo) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-process/v1/colourize";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filesDo.getOldFileUrl());
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.a3ca9be6da674c21732bd7f547839159.2592000.1562314733.282335-15199730";

            String result = HttpUtil.post(url, accessToken, param);
            JSONObject jsonObject = JSON.parseObject(result);
            String img =jsonObject.getString("image");
            String path =SERVER_DATA_URL+"Colorful"+filesDo.getOldFileName();
            GenerateImage(img,path);
            filesDo.setNewFileUrl(path);
            filesDo.setState(1);
            filesDo.setNewFileName("Colorful"+filesDo.getOldFileName());
            return filesDo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   public static boolean GenerateImage(String imgStr, String imgFilePath) {
            if (imgStr == null) // 图像数据为空
                  return false;
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                  // Base64解码
                  byte[] bytes = decoder.decodeBuffer(imgStr);
                  for (int i = 0; i < bytes.length; ++i) {
                        if (bytes[i] < 0) {// 调整异常数据
                              bytes[i] += 256;
                        }
                  }
                  // 生成jpeg图片
                  OutputStream out = new FileOutputStream(imgFilePath);
                  out.write(bytes);
                  out.flush();
                  out.close();
                  return true;
            } catch (Exception e) {
                  return false;
            }
      }

}