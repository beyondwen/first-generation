package com.amchis.firstgeneration.bean.guanli.jiyinjiance20s;

import com.amchis.firstgeneration.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JiYinJianCe20{
    @JsonProperty("Yonghuwaijian")
    private String yonghuwaijian;
    @JsonProperty("Cdkal11")
    private String cdkal11;
    @JsonProperty("Cdkal12")
    private String cdkal12;
    @JsonProperty("Cdkn2aB")
    private String cdkn2aB;
    @JsonProperty("Hhex")
    private String hhex;
    @JsonProperty("Slc30a8")
    private String slc30a8;
    @JsonProperty("Kcnq1")
    private String kcnq1;
    @JsonProperty("Yonghumingcheng")
    private String yonghumingcheng;
    @JsonProperty("Yonghushoujihao")
    private String yonghushoujihao;

}