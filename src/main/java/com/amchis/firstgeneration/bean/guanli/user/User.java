package com.amchis.firstgeneration.bean.guanli.user;

import com.amchis.firstgeneration.bean.BaseBean;
import com.amchis.firstgeneration.bean.guanli.Register.Guanjiacanshu;
import lombok.Data;

@Data
public class User extends BaseBean {

    private Guanjiacanshu Guanjiacanshu;

    private String waijian;

    private String mingcheng;

    private String shenfenzheng;

    private String shoujihao;

    private String shengri;

    private String xingbie;

    private String wenhua;

    private String email;

    private String gonghao;

    private String tongyixieyi;

    private String shengao;

    private String luruduan;

    private String shixiao;

    private String mima;
}