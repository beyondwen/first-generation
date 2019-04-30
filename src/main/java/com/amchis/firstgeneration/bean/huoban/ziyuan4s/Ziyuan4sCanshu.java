package com.amchis.firstgeneration.bean.huoban.ziyuan4s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ziyuan4sCanshu {

    @JsonProperty("ZiyuanShuju")
    private Ziyuan4s ziyuan4s;
}
