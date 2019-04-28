package com.amchis.firstgeneration.bean.huoban.richang6s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
public class Richang6s extends BaseBean {

    @JsonProperty(value = "Yonghuwaijian")
    private String yonghuwaijian;

    @JsonProperty(value = "Kongfu")
    @NotBlank(message = "空腹不能为空")
    private String kongfu;

    @JsonProperty(value = "Xueyagao")
    @NotBlank(message = "血压高不能为空")
    private String xueyagao;

    @JsonProperty(value = "Xueyadi")
    @NotBlank(message = "血压低不能为空")
    private String xueyadi;

    @JsonProperty(value = "Wanerxiaoshi")
    @NotBlank(message = "晚二小时不能为空")
    private String wanerxiaoshi;

    @JsonProperty(value = "Qitayaowu")
    private String qitayaowu;

    @JsonProperty(value = "Beizhu")
    private String beizhu;

    @JsonProperty(value = "Shujuriqi")
    private String shujuriqi;

}