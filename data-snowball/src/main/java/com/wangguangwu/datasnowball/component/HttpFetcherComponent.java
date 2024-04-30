package com.wangguangwu.datasnowball.component;

import com.wangguangwu.datasnowball.config.XueQiuConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * HTTP 请求工具类
 *
 * @author wangguangwu
 */
@Component
@Slf4j
public class HttpFetcherComponent {

    /**
     * TODO: 问题
     * 1. 为什么要注入进来一个 HttpClient，直接 new 不可以吗，有什么区别
     * 2. 为什么要通过构造器来传入，直接使用 @Resource 注解不行吗
     */
    @Resource
    private HttpClient client;
    private static final String DEFAULT_HOST = "stock.xueqiu.com";
    private static final int HTTP_OK = 200;

    @Resource
    private XueQiuConfig xueQiuConfig;

    @Autowired
    public HttpFetcherComponent(HttpClient client) {
        this.client = client;
    }

    /**
     * 执行HTTP GET请求。
     *
     * @param url     请求的URL
     * @param headers 请求的头部信息
     * @return 服务器响应的内容
     */
    public String fetch(String url, Map<String, String> headers) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET();

        headers.forEach(requestBuilder::header);
        HttpRequest request = requestBuilder.build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            log.error("访问[{}]异常: {}", url, e.getMessage(), e);
            return "";
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("请求被中断: {}", e.getMessage(), e);
            return "";
        }

        if (HTTP_OK != response.statusCode()) {
            log.error("访问[{}]失败，响应状态码: {}，响应体：{}", url, response.statusCode(), response.body());
            return "";
        }

        return response.body();
    }

    /**
     * 获取带有Token的HTTP响应。
     *
     * @param url 请求的URL
     * @return 响应内容
     */
    public String fetchWithToken(String url) {
        Map<String, String> headers = getDefaultHeaders();
        return fetch(url, headers);
    }


    /**
     * 获取不带Token的HTTP响应。
     *
     * @param url 请求的URL
     * @return 响应内容
     */
    public String fetchWithoutToken(String url) {
        Map<String, String> headers = getDefaultHeadersWithOutToken();
        return fetch(url, headers);
    }

    private Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = getDefaultHeadersWithOutToken();
        headers.put("Cookie", xueQiuConfig.getToken());
        return headers;
    }

    private static Map<String, String> getDefaultHeadersWithOutToken() {
        Map<String, String> headers = new HashMap<>(8);
        headers.put("Host", DEFAULT_HOST);
        headers.put("Accept", "application/json");
        headers.put("User-Agent", "Xueqiu iPhone 11.8");
        headers.put("Accept-Language", "zh-Hans-CN;q=1, ja-JP;q=0.9");
        headers.put("Accept-Encoding", "br, gzip, deflate");
        headers.put("Connection", "keep-alive");
        return headers;
    }
}
