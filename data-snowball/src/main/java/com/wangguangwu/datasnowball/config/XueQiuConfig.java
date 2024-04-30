package com.wangguangwu.datasnowball.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangguangwu
 */
@Configuration
@ConfigurationProperties(prefix = "xueqiu")
@Data
public class XueQiuConfig {

    private String token;

}
