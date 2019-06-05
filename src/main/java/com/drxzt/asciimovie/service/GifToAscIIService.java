package com.drxzt.asciimovie.service;

import com.drxzt.asciimovie.commous.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * className GifToAscIIService
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/5/30 22:49
 */

public interface GifToAscIIService {
    Result getFile(MultipartFile file,String ip);
    Result gifToAscII (Integer fileId);
    Result toColorful(Integer fileId);
}
