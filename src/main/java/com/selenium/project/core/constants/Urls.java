package com.selenium.project.core.constants;

import lombok.Getter;

public enum Urls {
    MAKEMYTRIP("https://www.makemytrip.com"),
    LETCODE("https://letcode.in/test");

    private @Getter String url;

    Urls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
