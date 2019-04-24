package com.amchis.firstgeneration.bean.guanli.jwtbean;

import lombok.Data;

@Data
public class Jwtbean {

    private String waijian;

    private String shoujihao;

    private String gonghao;

    private String jueseBianma;

    public Jwtbean(String waijian, String shoujihao, String gonghao, String jueseBianma) {
        this.waijian = waijian;
        this.shoujihao = shoujihao;
        this.gonghao = gonghao;
        this.jueseBianma = jueseBianma;
    }
}
