package com.wangguangwu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@MapperScan("com.wangguangwu.backtest.mapper")
@EnableTransactionManagement
public class BackTestApplication {

        public static void main(String[] args) {
        SpringApplication.run(BackTestApplication.class, args);
    }

}
