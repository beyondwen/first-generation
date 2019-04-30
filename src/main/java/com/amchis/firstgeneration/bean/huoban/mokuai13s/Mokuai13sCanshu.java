package com.amchis.firstgeneration.bean.huoban.mokuai13s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Mokuai13sCanshu {

    @JsonProperty("MokuaiShuju")
    private Mokuai13s mokuai13s;
}
