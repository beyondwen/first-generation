package com.amchis.firstgeneration.bean.kehuapp.Bangdingguanjia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Bangdingguanjia {

    @JsonProperty("GuanjiaGonghao")
    private String guanjiaGonghao;
    @JsonProperty("Shenfenzheng")
    private String shenfenzheng;

}
