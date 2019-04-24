package com.amchis.firstgeneration.bean.huoban.ziyuanleixing3s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ziyuanleixing3s extends BaseBean {
    @JsonProperty(value = "Mingcheng")
    private String mingcheng;

    @JsonProperty(value = "Waijian")
    private String waijian;

    @JsonProperty(value = "Bianma")
    private String bianma;

    @JsonProperty(value = "Shuoming")
    private String shuoming;

}