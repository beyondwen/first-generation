package com.amchis.firstgeneration.bean.huoban.kehuyaowu18s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Kehuyaowu18{

    @JsonProperty(value = "Id")
    private Integer id;

    @JsonProperty(value = "Riqi")
    private String riqi;

    @JsonProperty(value = "Shixiao")
    private String shixiao;

    @JsonProperty(value = "Waijian")
    private String waijian;

    @JsonProperty(value = "Yonghuwaijian")
    private String yonghuwaijian;

    @JsonProperty(value = "Shujuriqi")
    private String shujuriqi;
    @JsonProperty(value = "Mingcheng")
    private String mingcheng;

    @JsonProperty(value = "Qujian")
    private String qujian;

    @JsonProperty(value = "Leixing")
    private String leixing;

    @JsonProperty(value = "Jiliang")
    private String jiliang;

}