package com.wangguangwu.datasnowball;

import com.wangguangwu.datasnowball.config.XueQiuConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangguangwu
 */
@SpringBootApplication
@MapperScan("com.wangguangwu.datasnowball.mapper")
@EnableTransactionManagement
@EnableConfigurationProperties(XueQiuConfig.class)
public class DataSnowBallApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSnowBallApplication.class, args);
    }

}
