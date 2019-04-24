package com.amchis.firstgeneration.bean.huoban.jiankangwenjuan7s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JianKangWenJuan7s extends BaseBean {

    @JsonProperty(value = "Guanliyonghu")
    private String guanliyonghu;

    @JsonProperty(value = "Weixinopenid")
    private String weixinopenid;

    @JsonProperty(value = "Shoujihao")
    private String shoujihao;

    @JsonProperty(value = "Xingming")
    private String xingming;

    @JsonProperty(value = "Shengri")
    private String shengri;

    @JsonProperty(value = "Xingbie")
    private String xingbie;

    @JsonProperty(value = "Wenhua")
    private String wenhua;

    @JsonProperty(value = "Shuimian")
    private String shuimian;

    @JsonProperty(value = "Jiankangzhuangkuang")
    private String jiankangzhuangkuang;

    @JsonProperty(value = "Bingcheng")
    private String bingcheng;

    @JsonProperty(value = "Zhengzhuang")
    private String zhengzhuang;

    @JsonProperty(value = "Yidaoliang1")
    private String yidaoliang1;

    @JsonProperty(value = "Yidaoliang2")
    private String yidaoliang2;

    @JsonProperty(value = "Koufuliang1")
    private String koufuliang1;

    @JsonProperty(value = "Koufuliang2")
    private String koufuliang2;

    @JsonProperty(value = "Koufuliang3")
    private String koufuliang3;

    @JsonProperty(value = "Lururenwaijian")
    private String lururenwaijian;

}