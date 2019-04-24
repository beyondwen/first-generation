package com.amchis.firstgeneration.bean.huoban.gl1he4s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Gl1He4s extends BaseBean {

    @JsonProperty(value = "Juesewaijian")
    private String juesewaijian;

    @JsonProperty(value = "Ziyuanwaijian")
    private String ziyuanwaijian;

}