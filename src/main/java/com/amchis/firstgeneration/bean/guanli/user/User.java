package com.amchis.firstgeneration.bean.guanli.user;

import com.amchis.firstgeneration.bean.BaseBean;
import com.amchis.firstgeneration.bean.guanli.Register.Guanjiacanshu;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User extends BaseBean {

    @JsonProperty("Mingcheng")
    private String mingcheng;
    @JsonProperty("Shenfenzheng")
    private String shenfenzheng;
    @JsonProperty("Shoujihao")
    private String shoujihao;
    @JsonProperty("Shengri")
    private String shengri;
    @JsonProperty("Xingbie")
    private String xingbie;
    @JsonProperty("Wenhua")
    private String wenhua;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Gonghao")
    private String gonghao;
    @JsonProperty("Tongyixieyi")
    private String tongyixieyi;
    @JsonProperty("Shengao")
    private String shengao;
    @JsonProperty("Mima")
    private String mima;
}