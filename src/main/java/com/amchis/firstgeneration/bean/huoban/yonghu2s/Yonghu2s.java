package com.amchis.firstgeneration.bean.huoban.yonghu2s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Yonghu2s extends BaseBean {

    @JsonProperty(value = "Mingcheng")
    private String mingcheng;
    @JsonProperty(value = "Shenfenzheng")
    private String shenfenzheng;
    @JsonProperty(value = "Shoujihao")
    private String shoujihao;
    @JsonProperty(value = "Shengri")
    private String shengri;
    @JsonProperty(value = "Xingbie")
    private String xingbie;
    @JsonProperty(value = "Wenhua")
    private String wenhua;
    @JsonProperty(value = "Email")
    private String email;
    @JsonProperty(value = "Gonghao")
    private String gonghao;
    @JsonProperty(value = "Tongyixieyi")
    private String tongyixieyi;
    @JsonProperty(value = "Shengao")
    private String shengao;

}