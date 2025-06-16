package com.xidan.stu_management_sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.xidan.stu_management_sys.mapper")
public class StuManagementSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuManagementSysApplication.class, args);
    }

}
