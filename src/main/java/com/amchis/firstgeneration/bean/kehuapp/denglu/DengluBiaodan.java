package com.amchis.firstgeneration.bean.kehuapp.denglu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DengluBiaodan {

    @JsonProperty("Shoujihao")
    @NotBlank(message = "手机号不能为空")
    private String shoujihao;
    @JsonProperty("Mima")
    private String mima;
    @JsonProperty("Jizhumima")
    private String jizhumima;
    @JsonProperty("Gonghao")
    private String gonghao;
    @JsonProperty("Luruduan")
    private String luruduan;

}
