package com.amchis.firstgeneration.bean.guanli.appbanben21s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AppBanBen21s extends BaseBean {

    @JsonProperty("Iosapp")
    private String iosapp;
    @JsonProperty("Androidapp")
    private String androidapp;

}