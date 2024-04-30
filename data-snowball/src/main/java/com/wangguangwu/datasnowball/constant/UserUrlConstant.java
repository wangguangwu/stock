package com.wangguangwu.datasnowball.constant;

/**
 * 用户投资组合
 *
 * @author wangguangwu
 */
public final class UserUrlConstant {

    /**
     * 获取用户的观察列表。
     */
    public static final String WATCH_LIST = "https://stock.xueqiu.com/v5/stock/portfolio/list.json?system=true";

    /**
     * 获取用户观察列表中的股票数据。
     */
    public static final String WATCH_STOCK = "https://stock.xueqiu.com/v5/stock/portfolio/stock/list.json?size=1000&category=1&pid=";


    private UserUrlConstant() {
    }
}
