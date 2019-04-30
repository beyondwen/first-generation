package com.amchis.firstgeneration.bean.huoban.weixinzhanghao16s;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weixinzhanghao16sCanshu {

    @JsonProperty("WeixinzhanghaoShuju")
    private Weixinzhanghao16s weixinzhanghao16s;
}
