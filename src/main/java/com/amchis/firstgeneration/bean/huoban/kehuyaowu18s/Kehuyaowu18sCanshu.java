package com.amchis.firstgeneration.bean.huoban.kehuyaowu18s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Kehuyaowu18sCanshu {

    @JsonProperty("Openid")
    private String openid;

    @JsonProperty("KehuyaowuShuju")
    private Kehuyaowu18s kehuyaowu18s;
}
