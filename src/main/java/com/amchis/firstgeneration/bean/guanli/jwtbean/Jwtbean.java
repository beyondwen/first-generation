package com.amchis.firstgeneration.bean.guanli.jwtbean;

import lombok.Data;

@Data
public class Jwtbean {

    private String waijian;

    private String shoujihao;

    private String gonghao;

    private String jueseBianma;

    private Long time;

    public Jwtbean(String waijian, String shoujihao, String gonghao, String jueseBianma) {
        this.waijian = waijian;
        this.shoujihao = shoujihao;
        this.gonghao = gonghao;
        this.jueseBianma = jueseBianma;
    }

    public Jwtbean(String waijian, String shoujihao, Long time) {
        this.waijian = waijian;
        this.shoujihao = shoujihao;
        this.time = time;
    }
}
