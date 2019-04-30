package com.amchis.firstgeneration.bean.huoban.richang6s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Richang6sCanshu {

    @JsonProperty("Openid")
    private String openid;

    @JsonProperty("RichangShuju")
    private Richang6s richang6s;
}
