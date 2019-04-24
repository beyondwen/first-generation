package com.amchis.firstgeneration.bean.huoban.mokuai13s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Mokuai13s extends BaseBean {

    @JsonProperty(value = "Biaoming")
    private String biaoming;
    @JsonProperty(value = "Mingcheng")
    private String mingcheng;
    @JsonProperty(value = "Zhushi")
    private String zhushi;

}