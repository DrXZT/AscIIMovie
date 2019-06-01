package com.drxzt.asciimovie.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TokenDo {
    private Integer id;

    private String accessToken;

    public TokenDo(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }
}