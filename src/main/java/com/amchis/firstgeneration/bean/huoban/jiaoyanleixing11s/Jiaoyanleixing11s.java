package com.amchis.firstgeneration.bean.huoban.jiaoyanleixing11s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Jiaoyanleixing11s extends BaseBean {

    @JsonProperty(value = "Bianma")
    private String bianma;

    @JsonProperty(value = "Mingcheng")
    private String mingcheng;

    @JsonProperty(value = "Shuoming")
    private String shuoming;

}