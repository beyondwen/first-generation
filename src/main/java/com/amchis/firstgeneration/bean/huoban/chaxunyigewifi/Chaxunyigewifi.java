package com.amchis.firstgeneration.bean.huoban.chaxunyigewifi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Chaxunyigewifi {

    @JsonProperty("WifimingChaxun")
    private String wifimingChaxun;
    @JsonProperty("LiushuihaoChaxun")
    private String liushuihaoChaxun;
}
