package com.amchis.firstgeneration.bean.huoban.shujuriqi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShujuRiqi {
    @NotBlank(message = "数据日期不能为空")
    @JsonProperty("ShujuRiqi")
    private String shujuRiqi;
}
