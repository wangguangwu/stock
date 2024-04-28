package com.wangguangwu.datatushare.controller;

import com.wangguangwu.datatushare.service.hello.HelloService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguangwu
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("/hello")
    public void hello() {
        helloService.hello();
    }

}
