package com.wangguangwu.datasnowball;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@MapperScan("com.wangguangwu.datasnowball.mapper")
@EnableTransactionManagement
public class DataSnowBallApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSnowBallApplication.class, args);
    }

}
