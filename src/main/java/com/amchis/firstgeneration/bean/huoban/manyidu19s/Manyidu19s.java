package com.amchis.firstgeneration.bean.huoban.manyidu19s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Manyidu19s extends BaseBean {

    @JsonProperty(value = "Yonghuwaijian")
    private String yonghuwaijian;

    @JsonProperty(value = "Liaoxiaowenti")
    private String liaoxiaowenti;

    @JsonProperty(value = "Liaoxiaoyuanyin")
    private String liaoxiaoyuanyin;

    @JsonProperty(value = "Zhiliangwenti")
    private String zhiliangwenti;

    @JsonProperty(value = "Zhiliangyuanyin")
    private String zhiliangyuanyin;

    @JsonProperty(value = "Waiguanwenti")
    private String waiguanwenti;

    @JsonProperty(value = "Waiguanyuanyin")
    private String waiguanyuanyin;

    @JsonProperty(value = "Caozuowenti")
    private String caozuowenti;

    @JsonProperty(value = "Caozuoyuanyin")
    private String caozuoyuanyin;

    @JsonProperty(value = "Pingfen")
    private String pingfen;

    @JsonProperty(value = "Pinglun")
    private String pinglun;
}