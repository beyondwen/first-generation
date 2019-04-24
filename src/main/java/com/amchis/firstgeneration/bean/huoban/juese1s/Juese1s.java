package com.amchis.firstgeneration.bean.huoban.juese1s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Juese1s extends BaseBean {

    @JsonProperty(value = "Mingcheng")
    private String mingcheng;

    @JsonProperty(value = "Bianma")
    private String bianma;

    @JsonProperty(value = "Luruduan")
    private String luruduan;

}