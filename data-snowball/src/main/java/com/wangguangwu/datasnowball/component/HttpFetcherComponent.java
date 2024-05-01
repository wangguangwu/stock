package com.wangguangwu.datasnowball.component;

import com.alibaba.fastjson2.JSON;
import com.wangguangwu.datasnowball.config.XueQiuConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

    private static final String DEFAULT_HOST = "stock.xueqiu.com";
    private static final int HTTP_OK = 200;

    @Resource
    private XueQiuConfig xueQiuConfig;

    private final CloseableHttpClient client;

    public HttpFetcherComponent() {
        this.client = HttpClients.createDefault();
    }

    public String fetch(String url, Map<String, String> headers) {
        HttpGet request = new HttpGet(url);
        headers.forEach(request::addHeader);

        try (CloseableHttpResponse response = client.execute(request)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            log.info("访问[{}]，响应实体: {}", url, JSON.toJSON(responseBody));
            if (HTTP_OK != response.getStatusLine().getStatusCode()) {
                log.error("访问[{}]失败，响应状态码: {}, 响应体：{}", url, response.getStatusLine().getStatusCode(), responseBody);
                return "";
            }
            return responseBody;
        } catch (IOException e) {
            log.error("访问[{}]异常: {}", url, e.getMessage(), e);
            return "";
        }
    }

    public String fetch(String url) {
        return fetch(url, getDefaultHeaders());
    }

    public String fetchWithoutToken(String url) {
        return fetch(url, getDefaultHeadersWithOutToken());
    }

    private Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = getDefaultHeadersWithOutToken();
        headers.put("Cookie", "xq_a_token=" + xueQiuConfig.getToken());
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
