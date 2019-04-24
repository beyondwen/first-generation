package com.amchis.firstgeneration.bean.huoban.tianxiebiaoji8s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Tianxiebiaoji8s extends BaseBean {
    @JsonProperty(value = "Guanlianyonghu")
    private String guanlianyonghu;

    @JsonProperty(value = "Weixinopenid")
    private String weixinopenid;

    @JsonProperty(value = "Richangyitian")
    private String richangyitian;

    @JsonProperty(value = "Tijianyitian")
    private String tijianyitian;

    @JsonProperty(value = "Jiankangwenjuanyitian")
    private String jiankangwenjuanyitian;

    @JsonProperty(value = "Shengwuboyitian")
    private String shengwuboyitian;

}