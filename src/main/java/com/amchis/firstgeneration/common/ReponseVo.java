package com.amchis.firstgeneration.common;

import lombok.Data;

@Data
public class ReponseVo<T> {

    private String Zhuangtai;

    private T Neirong;

    public ReponseVo(String zhuangtai, T neirong) {
        Zhuangtai = zhuangtai;
        Neirong = neirong;
    }
}
