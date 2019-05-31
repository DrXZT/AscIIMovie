package com.drxzt.asciimovie.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FilesDo {
    private Integer fileId;

    private String oldFileUrl;

    private String newFileUrl;

    private Integer state;

    private Integer newFileMemory;

    private Integer oldFileMemory;

    private Integer transformtime;

    private String userIp;

    private String newFileName;

    private String oldFileName;

    public FilesDo(String oldFileUrl, Integer state, Integer oldFileMemory, String userIp, String oldFileName) {
        this.oldFileUrl = oldFileUrl;
        this.state = state;
        this.oldFileMemory = oldFileMemory;
        this.userIp = userIp;
        this.oldFileName = oldFileName;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getOldFileUrl() {
        return oldFileUrl;
    }

    public void setOldFileUrl(String oldFileUrl) {
        this.oldFileUrl = oldFileUrl == null ? null : oldFileUrl.trim();
    }

    public String getNewFileUrl() {
        return newFileUrl;
    }

    public void setNewFileUrl(String newFileUrl) {
        this.newFileUrl = newFileUrl == null ? null : newFileUrl.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getNewFileMemory() {
        return newFileMemory;
    }

    public void setNewFileMemory(Integer newFileMemory) {
        this.newFileMemory = newFileMemory;
    }

    public Integer getOldFileMemory() {
        return oldFileMemory;
    }

    public void setOldFileMemory(Integer oldFileMemory) {
        this.oldFileMemory = oldFileMemory;
    }

    public Integer getTransformtime() {
        return transformtime;
    }

    public void setTransformtime(Integer transformtime) {
        this.transformtime = transformtime;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName == null ? null : newFileName.trim();
    }

    public String getOldFileName() {
        return oldFileName;
    }

    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName == null ? null : oldFileName.trim();
    }
}