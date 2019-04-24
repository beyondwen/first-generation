package com.amchis.firstgeneration.bean.guanli.Register;

import lombok.Data;

@Data
public class RegisterBean {
    private String Mingcheng;
    private String Shoujihao;
    private String Gonghao;
    private String Mima;

    private Guanjiacanshu Guanjiacanshu;

    public String getMingcheng() {
        return Guanjiacanshu.getMingcheng();
    }

    public String getShoujihao() {
        return Guanjiacanshu.getShoujihao();
    }

    public String getGonghao() {
        return Guanjiacanshu.getGonghao();
    }

    public String getMima() {
        return Guanjiacanshu.getMima();
    }

}
