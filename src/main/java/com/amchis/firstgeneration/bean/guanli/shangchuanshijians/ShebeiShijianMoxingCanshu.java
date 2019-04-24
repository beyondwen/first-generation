package com.amchis.firstgeneration.bean.guanli.shangchuanshijians;

import lombok.Data;

@Data
public class ShebeiShijianMoxingCanshu {
    private String Shoujihao;
    private ShebeiShijianMoxing ShebeiShijianMoxing;

    public void setShoujihao(String shoujihao) {
        Shoujihao = ShebeiShijianMoxing.getShoujihao();
    }
}
