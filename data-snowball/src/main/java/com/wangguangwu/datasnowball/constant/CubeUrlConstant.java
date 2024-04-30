package com.wangguangwu.datasnowball.constant;

/**
 * 投资组合（Cube）数据
 *
 * @author wangguangwu
 */
public final class CubeUrlConstant {

    /**
     * 提供投资组合的日常净值变动。
     */
    public static final String NAV_DAILY = "https://xueqiu.com/cubes/nav_daily/all.json?cube_symbol=";

    /**
     * 提供投资组合的再平衡历史。
     */
    public static final String REBALANCING_HISTORY = "https://xueqiu.com/cubes/rebalancing/history.json?cube_symbol=";

    private CubeUrlConstant() {
    }
}
