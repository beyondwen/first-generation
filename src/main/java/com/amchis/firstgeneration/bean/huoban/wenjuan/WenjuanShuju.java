package com.amchis.firstgeneration.bean.huoban.wenjuan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WenjuanShuju {
    @JsonProperty("Mingcheng")
    private String mingcheng;
    @JsonProperty("Shenfenzheng")
    private String shenfenzheng;
    @JsonProperty("Xingbie")
    private String Xingbie;
    @JsonProperty("Shengri")
    private String Shengri;
    @JsonProperty("Shengao")
    private String Shengao;
}
