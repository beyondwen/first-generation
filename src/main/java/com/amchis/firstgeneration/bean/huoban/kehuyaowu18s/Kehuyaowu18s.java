package com.amchis.firstgeneration.bean.huoban.kehuyaowu18s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Kehuyaowu18s extends BaseBean {

    @JsonProperty(value = "Yonghuwaijian")
    private String yonghuwaijian;

    @JsonProperty(value = "Mingcheng")
    private String mingcheng;

    @JsonProperty(value = "Shujuriqi")
    private String shujuriqi;

    @JsonProperty(value = "Qujian")
    private String qujian;

    @JsonProperty(value = "Leixing")
    private String leixing;

    @JsonProperty(value = "Jiliang")
    private String jiliang;


}