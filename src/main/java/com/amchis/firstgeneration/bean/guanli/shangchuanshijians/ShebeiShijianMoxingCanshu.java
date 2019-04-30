package com.amchis.firstgeneration.bean.guanli.shangchuanshijians;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ShebeiShijianMoxingCanshu {
    @JsonProperty("Shoujihao")
    private String shoujihao;

    @JsonProperty("ShebeiShijianMoxing")
    private ShebeiShijianMoxing shebeiShijianMoxing;

    public ShebeiShijianMoxing getShebeiShijianMoxing() {
        return shebeiShijianMoxing;
    }

    public void setShebeiShijianMoxing(ShebeiShijianMoxing shebeiShijianMoxing) {
        this.shebeiShijianMoxing = shebeiShijianMoxing;
    }

    public String getShoujihao() {
        return shoujihao;
    }

    public void setShoujihao(String shoujihao) {
        this.shoujihao = shebeiShijianMoxing.getShoujihao();
    }
}
