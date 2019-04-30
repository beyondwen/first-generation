package com.amchis.firstgeneration.bean.huoban.guanjiachaxunkehu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class guanjiachaxunkehu {

    @JsonProperty("ChaxunShoujihao")
    private String shoujihao;
}
