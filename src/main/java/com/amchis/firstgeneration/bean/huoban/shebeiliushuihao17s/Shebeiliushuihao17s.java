package com.amchis.firstgeneration.bean.huoban.shebeiliushuihao17s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Shebeiliushuihao17s extends BaseBean {

    @JsonProperty(value = "Liushuihao")
    private String liushuihao;

}