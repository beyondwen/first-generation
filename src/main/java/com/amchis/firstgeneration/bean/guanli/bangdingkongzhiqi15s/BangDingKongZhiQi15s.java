package com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BangDingKongZhiQi15s extends BaseBean {



    @JsonProperty(value = "Shoujihao")
    private String shoujihao;

    @NotBlank(message = "WiFi名称不能为空")
    @JsonProperty(value = "Wifiming")
    private String wifiming;

    @NotBlank(message = "MAC地址不能为空")
    @JsonProperty(value = "Macdizhi")
    private String macdizhi;

    @NotBlank(message = "SN号不能为空")
    @JsonProperty(value = "Liushuihao")
    private String liushuihao;

}