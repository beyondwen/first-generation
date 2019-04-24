package com.amchis.firstgeneration.bean.huoban.weixinzhanghao16s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weixinzhanghao16s extends BaseBean {

    @JsonProperty(value = "Openid")
    private String openid;
    @JsonProperty(value = "Nicheng")
    private String nicheng;
    @JsonProperty(value = "Xingbie")
    private String xingbie;
    @JsonProperty(value = "Chengshi")
    private String chengshi;
    @JsonProperty(value = "Sheng")
    private String sheng;
    @JsonProperty(value = "Guojia")
    private String guojia;
    @JsonProperty(value = "Touxiang")
    private String touxiang;
    @JsonProperty(value = "Tequan")
    private String tequan;

}