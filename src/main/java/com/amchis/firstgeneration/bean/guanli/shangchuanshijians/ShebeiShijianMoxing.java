package com.amchis.firstgeneration.bean.guanli.shangchuanshijians;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class ShebeiShijianMoxing {

    @JsonProperty("Shoujihao")
    private String shoujihao;

    public String getShoujihao() {
        return shoujihao;
    }

    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao;
    }
}