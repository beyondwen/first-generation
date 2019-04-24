package com.amchis.firstgeneration.bean.huoban.ziyuan4s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ziyuan4s  extends BaseBean {
    @JsonProperty(value = "Mingcheng")
    private String mingcheng;
    @JsonProperty(value = "Waijian")
    private String waijian;
    @JsonProperty(value = "Bianma")
    private String bianma;
    @JsonProperty(value = "Lianjie")
    private String lianjie;
    @JsonProperty(value = "Leixing")
    private String leixing;
    @JsonProperty(value = "Shangji")
    private String shangji;
}