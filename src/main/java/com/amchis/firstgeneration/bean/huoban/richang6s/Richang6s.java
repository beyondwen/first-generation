package com.amchis.firstgeneration.bean.huoban.richang6s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Richang6s extends BaseBean {

    @JsonProperty(value = "Yonghuwaijian")
    private String yonghuwaijian;

    @JsonProperty(value = "Kongfu")
    private String kongfu;

    @JsonProperty(value = "Xueyagao")
    private String xueyagao;

    @JsonProperty(value = "Xueyadi")
    private String xueyadi;

    @JsonProperty(value = "Wanerxiaoshi")
    private String wanerxiaoshi;

    @JsonProperty(value = "Qitayaowu")
    private String qitayaowu;

    @JsonProperty(value = "Beizhu")
    private String beizhu;

    @JsonProperty(value = "Shujuriqi")
    private String shujuriqi;
}