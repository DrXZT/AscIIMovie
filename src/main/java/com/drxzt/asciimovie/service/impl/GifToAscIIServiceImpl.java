package com.drxzt.asciimovie.service.impl;

import com.drxzt.asciimovie.commous.Result;
import com.drxzt.asciimovie.commous.UploadResult;
import com.drxzt.asciimovie.dao.FilesDoMapper;
import com.drxzt.asciimovie.entities.FilesDo;
import com.drxzt.asciimovie.service.GifToAscIIService;
import com.drxzt.asciimovie.util.Colourize;
import com.drxzt.asciimovie.util.FileSaveUtil;
import com.drxzt.asciimovie.util.ImgToCharacter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import static com.drxzt.asciimovie.commous.Constants.IMG_URL;

/**
 * className GifToAscIIServiceImpl
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/5/30 22:51
 */
@Service
public class GifToAscIIServiceImpl implements GifToAscIIService {
    private static final Logger logger = LoggerFactory.getLogger(GifToAscIIServiceImpl.class);
    @Resource
    FileSaveUtil fileSaveUtil;
    @Resource
    ImgToCharacter imgToCharacter;
    @Resource
    Colourize colourize;
    @Autowired
    FilesDoMapper filesDoMapper;

    public Result getFile(MultipartFile file, String ip) {
        logger.info("[Service] : [ getFile ] , ip : [ {} ] ,fileName: [ {} ],fileSize: [ {} ]", ip, file.getName(), file.getSize() / 1024);
        UploadResult uploadResult = fileSaveUtil.save(file);
        if (uploadResult.isSuccess()) {
            int memory = (int) file.getSize() / 1024;
            FilesDo filesDo = new FilesDo(uploadResult.getUrl(), 0, memory, ip, uploadResult.getName());
            filesDoMapper.insertSelective(filesDo);
            return Result.success(filesDo.getFileId());
        } else {
            return Result.build(0, uploadResult.getMessage(), null);
        }

    }

    public Result gifToAscII(Integer fileId) {
        FilesDo filesDo = filesDoMapper.selectByPrimaryKey(fileId);
        if (filesDo == null) {
            return Result.build(2, "文件为空或无效文件", null);
        } else {
            long startTime = System.currentTimeMillis();
            filesDo = imgToCharacter.readGiF(filesDo);
            if (filesDo == null) {
                return Result.build(2, "文件转换失败或无效文件", null);
            }
            long endTime = System.currentTimeMillis();
            filesDo.setTransformtime((int) (endTime - startTime));
            filesDoMapper.updateByPrimaryKeySelective(filesDo);
            return Result.success(IMG_URL + filesDo.getNewFileName());
        }
    }

    public Result toColorful(Integer fileId) {
        FilesDo filesDo = filesDoMapper.selectByPrimaryKey(fileId);
        if (filesDo == null) {
            return Result.build(2, "文件为空或无效文件", null);
        } else {
            long startTime = System.currentTimeMillis();
            filesDo = colourize.colourize(filesDo);
            if (filesDo == null) {
                return Result.build(2, "文件转换失败或无效文件", null);
            }
            long endTime = System.currentTimeMillis();
            filesDo.setTransformtime((int) (endTime - startTime));
            filesDoMapper.updateByPrimaryKeySelective(filesDo);
            return Result.success(IMG_URL + filesDo.getNewFileName());
        }
    }

    public  Result AndroidChange(MultipartFile file,String ip){
        logger.info("[Service] : [ getFile ] , ip : [ {} ] ,fileName: [ {} ],fileSize: [ {} ]", ip, file.getName(), file.getSize() / 1024);
        UploadResult uploadResult = fileSaveUtil.save(file);
        if (uploadResult.isSuccess()) {
            int memory = (int) file.getSize() / 1024;
            FilesDo filesDo = new FilesDo(uploadResult.getUrl(), 0, memory, ip, uploadResult.getName());
            filesDoMapper.insertSelective(filesDo);
            long startTime = System.currentTimeMillis();
            filesDo = imgToCharacter.readGiF(filesDo);
            long endTime = System.currentTimeMillis();
            filesDo.setTransformtime((int) (endTime - startTime));
            filesDoMapper.updateByPrimaryKeySelective(filesDo);
            return Result.success(IMG_URL + filesDo.getNewFileName());
        } else {
            return Result.build(0, uploadResult.getMessage(), null);
        }
    }
}
