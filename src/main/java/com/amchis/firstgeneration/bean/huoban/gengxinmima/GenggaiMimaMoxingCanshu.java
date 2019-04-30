package com.amchis.firstgeneration.bean.huoban.gengxinmima;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenggaiMimaMoxingCanshu {

    @JsonProperty("Jiumima")
    private String jiumima;
    @JsonProperty("Xinmima")
    private String xinmima;
    @JsonProperty("QuerenXinmima")
    private String querenXinmima;

}
