package com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BangDingKongZhiQi15sforBindUser{



    @JsonProperty(value = "Shoujihao")
    @NotBlank(message = "手机号不能为空")
    private String shoujihao;

    @NotBlank(message = "WiFi名称不能为空")
    @JsonProperty(value = "Wifiming")
    private String wifiming;

    private String macdizhi;

    @JsonProperty(value = "Id")
    private Integer id;

    @JsonProperty(value = "Riqi")
    private String riqi;

    @JsonProperty(value = "Shixiao")
    private String shixiao;

    @JsonProperty(value = "Luruduan")
    private String luruduan;

    @NotBlank(message = "SN号不能为空")
    @JsonProperty(value = "Liushuihao")
    private String liushuihao;

    @JsonProperty(value = "Waijian")
    private String waijian;

}