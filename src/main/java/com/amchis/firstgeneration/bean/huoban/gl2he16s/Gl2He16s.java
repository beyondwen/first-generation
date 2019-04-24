package com.amchis.firstgeneration.bean.huoban.gl2he16s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Gl2He16s extends BaseBean {

    @JsonProperty(value = "Yonghuwaijian")
    private String yonghuwaijian;

    @JsonProperty(value = "Weixinzhanghaowaijian")
    private String weixinzhanghaowaijian;

    @JsonProperty(value = "Openid")
    private String openid;
}