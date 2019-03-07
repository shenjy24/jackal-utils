package com.jonas.shorturl;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2019/01/02
 */
public class UrlResponse {
    @JSONField(name = "Code")
    private int code;

    @JSONField(name = "ErrMsg")
    private String errMsg;

    @JSONField(name = "LongUrl")
    private String longUrl;

    @JSONField(name = "ShortUrl")
    private String shortUrl;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
