package com.drxzt.asciimovie.entities;

public class LogDo {
    private Integer logId;

    private String userIp;

    private String controllor;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public String getControllor() {
        return controllor;
    }

    public void setControllor(String controllor) {
        this.controllor = controllor == null ? null : controllor.trim();
    }
}