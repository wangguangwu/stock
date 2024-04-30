package com.wangguangwu.datasnowball.constant;

/**
 * 中证指数公司（CSIndex）
 *
 * @author wangguangwu
 */
public final class CSIndexUrlConstant {

    /**
     * 提供指数的基本信息。
     */
    public static final String INDEX_BASIC_INFO = "https://www.csindex.com.cn/csindex-home/indexInfo/index-basic-info/{}";
    /**
     * 提供指数的详细数据。
     */
    public static final String INDEX_DETAILS_DATA = "https://www.csindex.com.cn/csindex-home/indexInfo/index-details-data?fileLang=1&indexCode={}";
    /**
     * 提供指数的十大权重股信息。
     */
    public static final String INDEX_WEIGHT_TOP10 = "https://www.csindex.com.cn/csindex-home/index/weight/top10/{}";
    /**
     * 提供指数的业绩数据。
     */
    public static final String INDEX_PERF = "https://www.csindex.com.cn/csindex-home/perf/index-perf?indexCode={}&startDate={}&endDate={}";


    private CSIndexUrlConstant() {
    }
}
