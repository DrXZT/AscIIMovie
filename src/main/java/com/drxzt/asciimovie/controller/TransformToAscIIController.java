package com.drxzt.asciimovie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.drxzt.asciimovie.commous.Result;
import com.drxzt.asciimovie.service.GifToAscIIService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className TransformToAscIIController
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/5/31 13:51
 */
@Controller
@RequestMapping("/index")
public class TransformToAscIIController {
    private static final Logger logger = LoggerFactory.getLogger(TransformToAscIIController.class);

    @Autowired
    GifToAscIIService gifToAscIIService;

    @ResponseBody
    @GetMapping("/toAscII")
    public Result TransformToAscII(@Param("fileId")Integer fileId){
        logger.info("[API] : [ index/toAscII] , fileId: [ {} ] ", fileId);
        if (fileId==null){
            return  Result.build(1,"未提交文件",null);
        }else {
            return   gifToAscIIService.gifToAscII(fileId);
        }
    }
}
