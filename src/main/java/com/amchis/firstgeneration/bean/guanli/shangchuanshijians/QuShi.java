package com.amchis.firstgeneration.bean.guanli.shangchuanshijians;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 获取设备使用时间 接口需要/ /shebeishiyongshijian
 */

@Data
public class QuShi{

    @JsonProperty("Riqi")
    private String riqi;
    @JsonProperty("Shijian")
    private String shijian;
}
