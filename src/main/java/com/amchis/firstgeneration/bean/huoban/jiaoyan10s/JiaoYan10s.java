package com.amchis.firstgeneration.bean.huoban.jiaoyan10s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JiaoYan10s extends BaseBean {

    @JsonProperty(value = "Yonghuwaijian")
    private String yonghuwaijian;

    @JsonProperty(value = "Jiaoyanleixingwaijian")
    private String jiaoyanleixingwaijian;

    @JsonProperty(value = "Jiaoyanzhi")
    private String jiaoyanzhi;

}