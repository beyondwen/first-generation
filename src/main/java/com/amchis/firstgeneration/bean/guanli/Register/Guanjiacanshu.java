package com.amchis.firstgeneration.bean.guanli.Register;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Guanjiacanshu {

    @NotBlank(message = "名称不能为空")
    private String Mingcheng;
    @NotBlank(message = "手机号不能为空")
    private String Shoujihao;
    @NotBlank(message = "工号不能为空")
    private String Gonghao;
    @NotBlank(message = "密码不能为空")
    private String Mima;
}
