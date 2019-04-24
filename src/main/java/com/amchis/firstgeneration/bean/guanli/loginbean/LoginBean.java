package com.amchis.firstgeneration.bean.guanli.loginbean;

import lombok.Data;

@Data
public class LoginBean {

    public Denglubiaodan Denglubiaodan;

    private String Gonghao;

    private String Mima;

    public com.amchis.firstgeneration.bean.guanli.loginbean.Denglubiaodan getDenglubiaodan() {
        return Denglubiaodan;
    }

    public void setDenglubiaodan(com.amchis.firstgeneration.bean.guanli.loginbean.Denglubiaodan denglubiaodan) {
        Denglubiaodan = denglubiaodan;
    }

    public String getGonghao() {
        return Denglubiaodan.getGonghao();
    }

    public String getMima() {
        return Denglubiaodan.getMima();
    }
}
