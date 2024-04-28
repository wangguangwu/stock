package com.wangguangwu.datatushare.service.hello.impl;

import com.wangguangwu.datatushare.service.hello.HelloService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloServiceImplTest {

    @Resource
    private HelloService helloService;

    @Test
    void hello() {
        helloService.hello();
    }
}