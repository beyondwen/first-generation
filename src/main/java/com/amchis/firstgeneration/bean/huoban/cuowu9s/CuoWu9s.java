package com.amchis.firstgeneration.bean.huoban.cuowu9s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CuoWu9s extends BaseBean {

    @NotBlank(message = "名称不能为空")
    @JsonProperty(value = "Mingcheng")
    private String mingcheng;

    @JsonProperty(value = "Bianma")
    private String bianma;

    @JsonProperty(value = "Miaoshu")
    private String miaoshu;

    @JsonProperty(value = "Fangfa")
    private String fangfa;

    @JsonProperty(value = "Canshuzhi")
    private String canshuzhi;


}