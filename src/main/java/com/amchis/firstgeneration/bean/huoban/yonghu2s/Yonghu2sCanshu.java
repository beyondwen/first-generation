package com.amchis.firstgeneration.bean.huoban.yonghu2s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Yonghu2sCanshu {

    @JsonProperty("YonghuShuju")
    private Yonghu2s yonghu2s;
}
