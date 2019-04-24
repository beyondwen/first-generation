package com.amchis.firstgeneration.bean.huoban.gl13he13s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Gl13He13s extends BaseBean {

    @JsonProperty(value = "Mokuaiwaijian1")
    private String mokuaiwaijian1;

    @JsonProperty(value = "Mokuaiwaijian2")
    private String mokuaiwaijian2;


}