package com.amchis.firstgeneration.bean.huoban.ziduan12s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ziduan12s extends BaseBean {

    @JsonProperty(value = "Bianma")
    private String bianma;
    @JsonProperty(value = "Mingcheng")
    private String mingcheng;
    @JsonProperty(value = "Leixing")
    private String leixing;
    @JsonProperty(value = "Morenzhi")
    private String morenzhi;
    @JsonProperty(value = "Zhengze")
    private String zhengze;
    @JsonProperty(value = "Bitian")
    private String bitian;
    @JsonProperty(value = "Shuoming")
    private String shuoming;
}