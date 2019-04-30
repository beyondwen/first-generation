package com.amchis.firstgeneration.bean.huoban.ziyuanleixing3s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ziyuanleixing3sCanshu {

    @JsonProperty("ZiyuanleixingShuju")
    private Ziyuanleixing3s ziyuanleixing3s;
}
