package com.amchis.firstgeneration.bean.guanli.loginbean;

/**
 * 从go移植过来的  他原来就这样封装的  我也没法改 轻喷
 */
public class DengluBiaodanForm {
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
