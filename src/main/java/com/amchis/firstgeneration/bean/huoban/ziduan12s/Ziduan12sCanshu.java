package com.amchis.firstgeneration.bean.huoban.ziduan12s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ziduan12sCanshu {

    @JsonProperty("ZiduanShuju")
    private Ziduan12s ziduan12s;
}
