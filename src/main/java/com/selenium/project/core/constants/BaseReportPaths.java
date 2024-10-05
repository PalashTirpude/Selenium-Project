package com.selenium.project.core.constants;

import lombok.Getter;

public enum BaseReportPaths {
    MAKEMYTRIP("reports/Make_My_Trip/"),
    LETCODE("reports/LetCode/");

    private @Getter String baseReportPath;

    BaseReportPaths(String baseReportPath) {
        this.baseReportPath=baseReportPath;
    }
}
