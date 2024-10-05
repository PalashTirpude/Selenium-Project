package com.selenium.project.core.annotations;


import com.selenium.project.core.constants.BaseReportPaths;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
public @interface ReportBasePath {
    BaseReportPaths baseReportPath() default BaseReportPaths.MAKEMYTRIP;
}
