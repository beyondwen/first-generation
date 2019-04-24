package com.amchis.firstgeneration.bean.guanli.gl1he2s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Gl1he2s extends BaseBean {

    @JsonProperty(value = "Juesewaijian")
    private String juesewaijian;

    @JsonProperty(value = "Yonghuwaijian")
    private String yonghuwaijian;


}