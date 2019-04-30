package com.amchis.firstgeneration.bean.guanli.loginbean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginBean {

    @JsonProperty("Gonghao")
    private String gonghao;

    @JsonProperty("Mima")
    private String Mima;

}
