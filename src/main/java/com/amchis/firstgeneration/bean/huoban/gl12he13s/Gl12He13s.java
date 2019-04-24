package com.amchis.firstgeneration.bean.huoban.gl12he13s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Gl12He13s extends BaseBean {

    @JsonProperty(value = "Ziduanwaijian")
    private String ziduanwaijian;

    @JsonProperty(value = "Miduanwaijian")
    private String mokuaiwaijian;

}