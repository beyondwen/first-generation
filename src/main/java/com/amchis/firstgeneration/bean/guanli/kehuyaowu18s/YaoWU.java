package com.amchis.firstgeneration.bean.guanli.kehuyaowu18s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class YaoWU{

    @JsonProperty("Shujushijian")
    private String shujushijian;
    @JsonProperty("Shujuzhi")
    private String shujuzhi;
    @JsonProperty("Leixing")
    private String leixing;
}
