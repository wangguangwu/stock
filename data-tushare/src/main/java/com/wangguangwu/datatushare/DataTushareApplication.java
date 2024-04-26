package com.wangguangwu.datatushare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@MapperScan("com.wangguangwu.datatushare.mapper")
@EnableTransactionManagement
public class DataTushareApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataTushareApplication.class, args);
    }

}
