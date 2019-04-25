package com.amchis.firstgeneration.bean.huoban.bindcontroller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BindController {

    @JsonProperty(value = "WifimingChaxun")
    private String wifimingChaxun;

    @JsonProperty(value = "LiushuihaoChaxun")
    private String liushuihaoChaxun;
}
