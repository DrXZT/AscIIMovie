package com.drxzt.asciimovie.commous;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * className UploadResult
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/3/26 22:07
 */

public class UploadResult {
    private int success = 0; // 0 失败 1成功
    private String message;

    private String url;
    private Path path;
    private String name;
    private String format;

    public boolean isSuccess() {
        return (success == 1 && path != null && Files.exists(this.path));
    }

    public void successful(String url,String name,String format) {
        successful("上传成功！", url,name,format);
    }

    public void successful(String message, String url,String name,String format) {
        this.success = 1;
        this.message = message;
        this.url = url;
        this.format=format;
        this.name =name;
    }

    public void failed() {
        this.success = 0;
        this.message = "上传失败！";
    }

    public void failed(String message) {
        this.success = 0;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void failed(String message, String url) {
        this.success = 0;
    }


    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPath(Path path) {
        this.path = path;
    }

}
