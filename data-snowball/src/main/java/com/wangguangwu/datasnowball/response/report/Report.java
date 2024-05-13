package com.wangguangwu.datasnowball.response.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author wangguangwu
 */
@Data
public class Report {

    @JsonProperty("title")
    private String title;

    @JsonProperty("rpt_comp")
    private String reportCompany;

    @JsonProperty("rating_desc")
    private String ratingDescription;

    @JsonProperty("target_price_min")
    private Double targetPriceMin;

    @JsonProperty("target_price_max")
    private Double targetPriceMax;

    @JsonProperty("pub_date")
    private Long publicationDate;

    @JsonProperty("status_id")
    private Long statusId;

    @JsonProperty("retweet_count")
    private Integer retweetCount;

    @JsonProperty("reply_count")
    private Integer replyCount;

    @JsonProperty("like_count")
    private Integer likeCount;

    @JsonProperty("liked")
    private Boolean liked;

}
