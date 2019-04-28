package com.amchis.firstgeneration.bean.kehuapp.Yaowuqushishuju;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Yaowuqushishuju {

    @JsonProperty("Shujushijian")
    private String shujushijian;
    @JsonProperty("Shujuzhi")
    private String shujuzhi;
    @JsonProperty("Leixing")
    private String leixing;

}
