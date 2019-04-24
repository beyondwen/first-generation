package com.amchis.firstgeneration.bean.huoban.yonghuguanlizhe14s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Yonghuguanlizhe14s extends BaseBean {
    @JsonProperty(value = "Yonghuwaijian")
    private String yonghuwaijian;
    @JsonProperty(value = "Guanjiawaijian")
    private String guanjiawaijian;

}