package com.drxzt.asciimovie.api;

import com.drxzt.asciimovie.commous.Result;
import com.drxzt.asciimovie.controller.GetFileController;
import com.drxzt.asciimovie.service.GifToAscIIService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * className AndroidApi
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/6/12 21:04
 */
@Controller
@RequestMapping("/Android")
public class AndroidApi {
    private static final Logger logger = LoggerFactory.getLogger(GetFileController.class);

    @Autowired
    GifToAscIIService gifToAscIIService;

    @ResponseBody
    @PostMapping(value = "/gif/getFile", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result getFile(HttpServletRequest request) {
        // 这个一般是Nginx反向代理设置的参数
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 处理多IP的情况（只取第一个IP）
        if (ip != null && ip.contains(",")) {
            String[] ipArray = ip.split(",");
            ip = ipArray[0];
        }
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("img");
        logger.info("[API] : [ index/getFile ] , ip : [ {} ] ", ip);
        if (file == null) {
            return Result.build(1, "上传文件为空或文件格式不符", null);
        } else if (!FilenameUtils.getExtension(file.getOriginalFilename()).equals("gif")) {
            return Result.build(2, "上传文件文件格式不符", null);
        } else {
            return gifToAscIIService.AndroidChange(file, ip);
        }
    }
}
