package com.amchis.firstgeneration.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BaseBean {

    @JsonProperty(value = "Id")
    private Integer id;

    @JsonProperty(value = "Riqi")
    private String riqi;

    @NotBlank(message = "是否失效不能为空")
    @JsonProperty(value = "Shixiao")
    private String shixiao;

    @NotBlank(message = "录入端不能为空")
    @JsonProperty(value = "Luruduan")
    private String luruduan;

    @NotBlank(message = "SN号不能为空")
    @JsonProperty(value = "Liushuihao")
    private String liushuihao;

    @JsonProperty(value = "Waijian")
    private String waijian;


}
