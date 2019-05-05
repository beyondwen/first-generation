package com.amchis.firstgeneration.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseBean {

    @JsonProperty(value = "Id")
    private Integer id;

    @JsonProperty(value = "Riqi")
    private String riqi;

    @JsonProperty(value = "Shixiao")
    private String shixiao;

    @JsonProperty(value = "Luruduan")
    private String luruduan;

    @JsonProperty(value = "Waijian")
    private String waijian;


}
