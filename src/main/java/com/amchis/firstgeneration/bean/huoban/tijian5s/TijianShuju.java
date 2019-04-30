package com.amchis.firstgeneration.bean.huoban.tijian5s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TijianShuju {

    @JsonProperty("Openid")
    private String openid;

    @JsonProperty("TijianShuju")
    private Tijian5s tijian5s;
}
