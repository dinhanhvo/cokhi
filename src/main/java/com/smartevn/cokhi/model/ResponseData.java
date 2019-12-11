package com.smartevn.cokhi.model;

import java.util.Set;

import org.openqa.selenium.Cookie;

public class ResponseData {
    String html;
    Set<Cookie> cookies;
    
    public ResponseData(String html, Set<Cookie> cookies) {
        this.html = html;
        this.cookies = cookies;
    }
    
    public String getHtml() {
        return html;
    }
    public void setHtml(String html) {
        this.html = html;
    }
    public Set<Cookie> getCookies() {
        return cookies;
    }
    public void setCookies(Set<Cookie> cookies) {
        this.cookies = cookies;
    }
    
}
