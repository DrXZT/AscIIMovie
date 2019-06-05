package com.drxzt.asciimovie.util;


import com.drxzt.asciimovie.commous.UploadResult;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import static com.drxzt.asciimovie.commous.Constants.SERVER_DATA_URL;


/**
 * className FileUtil
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/3/27 16:30
 */
@Component
public class FileSaveUtil {
    public UploadResult save(MultipartFile file) {
        UploadResult uploadResult = new UploadResult();
        if (Files.notExists(Paths.get(SERVER_DATA_URL))) {
            try {
                Files.createDirectories(Paths.get(SERVER_DATA_URL));
            } catch (IOException e) {
                uploadResult.failed("创建上传目录错误！");
            }
        }
        String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        Path path = Paths.get(SERVER_DATA_URL, newFileName);
        try {
           // Thumbnails.of(file.getInputStream()).scale(0.25f).toFile(path.toFile());
            Files.copy(file.getInputStream(), path);
        } catch (IOException e) {
            e.printStackTrace();
            uploadResult.failed();
            return uploadResult;
        }
        uploadResult.setPath(path);
        uploadResult.successful(path.toString(),newFileName,FilenameUtils.getExtension(file.getOriginalFilename()));
        return uploadResult;
    }
}
