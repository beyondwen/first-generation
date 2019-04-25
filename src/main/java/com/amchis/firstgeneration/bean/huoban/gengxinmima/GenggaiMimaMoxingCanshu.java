package com.amchis.firstgeneration.bean.huoban.gengxinmima;

import lombok.Data;

@Data
public class GenggaiMimaMoxingCanshu {

    private GenggaiMimaMoxing GenggaiMimaMoxing;

    private String Jiumima;
    private String Xinmima;
    private String QuerenXinmima;

    public void setJiumima(String jiumima) {
        Jiumima = GenggaiMimaMoxing.getJiumima();
    }

    public void setXinmima(String xinmima) {
        Xinmima = GenggaiMimaMoxing.getXinmima();
    }

    public void setQuerenXinmima(String querenXinmima) {
        QuerenXinmima = GenggaiMimaMoxing.getQuerenXinmima();
    }
}
