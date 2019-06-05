package com.drxzt.asciimovie.controller;

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
 * className TransformToColorfulController
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/6/5 18:11
 */
@Controller
@RequestMapping("/index")
public class TransformToColorfulController {
    private static final Logger logger = LoggerFactory.getLogger(TransformToAscIIController.class);

    @Autowired
    GifToAscIIService gifToAscIIService;

    @ResponseBody
    @GetMapping("/toColorful")
    public Result TransformtoColorful(@Param("fileId")Integer fileId){
        logger.info("[API] : [ index/toColorful] , fileId: [ {} ] ", fileId);
        if (fileId==null){
            return  Result.build(1,"未提交文件",null);
        }else {
            return   gifToAscIIService.toColorful(fileId);
        }
    }
}
