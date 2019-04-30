package com.amchis.firstgeneration.bean.guanli.Register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterBean {
    @JsonProperty("Mingcheng")
    @NotBlank(message = "名称不能为空")
    private String mingcheng;
    @JsonProperty("Shoujihao")
    @NotBlank(message = "手机号不能为空")
    private String shoujihao;
    @JsonProperty("Gonghao")
    @NotBlank(message = "工号不能为空")
    private String gonghao;
    @JsonProperty("Mima")
    @NotBlank(message = "密码不能为空")
    private String mima;

}
