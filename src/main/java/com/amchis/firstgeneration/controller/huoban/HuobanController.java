package com.amchis.firstgeneration.controller.huoban;

import com.alibaba.druid.util.StringUtils;
import com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15s;
import com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15sforBindUser;
import com.amchis.firstgeneration.bean.guanli.gl1he2s.Gl1he2s;
import com.amchis.firstgeneration.bean.huoban.cuowu9s.CuoWu9s;
import com.amchis.firstgeneration.bean.huoban.gengxinmima.GenggaiMimaMoxingCanshu;
import com.amchis.firstgeneration.bean.huoban.gl12he13s.Gl12He13s;
import com.amchis.firstgeneration.bean.huoban.gl13he13s.Gl13He13s;
import com.amchis.firstgeneration.bean.huoban.gl1he4s.Gl1He4s;
import com.amchis.firstgeneration.bean.huoban.gl2he16s.Gl2He16s;
import com.amchis.firstgeneration.bean.huoban.jiankangwenjuan7s.JianKangWenJuan7s;
import com.amchis.firstgeneration.bean.huoban.jiaoyan10s.JiaoYan10s;
import com.amchis.firstgeneration.bean.huoban.jiaoyanleixing11s.Jiaoyanleixing11s;
import com.amchis.firstgeneration.bean.huoban.juese1s.Juese1s;
import com.amchis.firstgeneration.bean.huoban.kehuyaowu18s.Kehuyaowu18s;
import com.amchis.firstgeneration.bean.huoban.manyidu19s.Manyidu19s;
import com.amchis.firstgeneration.bean.huoban.mokuai13s.Mokuai13s;
import com.amchis.firstgeneration.bean.huoban.richang6s.Richang6s;
import com.amchis.firstgeneration.bean.huoban.shebeiliushuihao17s.Shebeiliushuihao17s;
import com.amchis.firstgeneration.bean.huoban.tianxiebiaoji8s.Tianxiebiaoji8s;
import com.amchis.firstgeneration.bean.huoban.tijian5s.Tijian5s;
import com.amchis.firstgeneration.bean.huoban.weixinzhanghao16s.Weixinzhanghao16s;
import com.amchis.firstgeneration.bean.huoban.yonghu2s.Yonghu2s;
import com.amchis.firstgeneration.bean.huoban.yonghuguanlizhe14s.Yonghuguanlizhe14s;
import com.amchis.firstgeneration.bean.huoban.ziduan12s.Ziduan12s;
import com.amchis.firstgeneration.bean.huoban.ziyuan4s.Ziyuan4s;
import com.amchis.firstgeneration.bean.huoban.ziyuanleixing3s.Ziyuanleixing3s;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15sMapper;
import com.amchis.firstgeneration.mapper.guanli.gl1he2s.Gl1he2sMapper;
import com.amchis.firstgeneration.mapper.guanli.kehuyaowu18s.KeHuYaoWu18sMapper;
import com.amchis.firstgeneration.mapper.huoban.cuowu9s.CuoWu9sMapper;
import com.amchis.firstgeneration.mapper.huoban.gl12he13s.Gl12He13sMapper;
import com.amchis.firstgeneration.mapper.huoban.gl13he13s.Gl13He13sMapper;
import com.amchis.firstgeneration.mapper.huoban.gl1he4s.Gl1He4sMapper;
import com.amchis.firstgeneration.mapper.huoban.gl2he16s.Gl2He16sMapper;
import com.amchis.firstgeneration.mapper.huoban.jiankangwenjuan7s.JianKangWenJuan7sMapper;
import com.amchis.firstgeneration.mapper.huoban.jiaoyan10s.JiaoYan10sMapper;
import com.amchis.firstgeneration.mapper.huoban.jiaoyanleixing11s.Jiaoyanleixing11sMapper;
import com.amchis.firstgeneration.mapper.huoban.juese1s.Juese1sMapper;

import com.amchis.firstgeneration.mapper.huoban.manyidu19s.Manyidu19sMapper;
import com.amchis.firstgeneration.mapper.huoban.mokuai13s.Mokuai13sMapper;
import com.amchis.firstgeneration.mapper.huoban.richang6s.Richang6sMapper;
import com.amchis.firstgeneration.mapper.huoban.shebeiliushuihao17s.Shebeiliushuihao17sMapper;
import com.amchis.firstgeneration.mapper.huoban.tianxiebiaoji8s.Tianxiebiaoji8sMapper;
import com.amchis.firstgeneration.mapper.huoban.tijian5s.Tijian5sMapper;
import com.amchis.firstgeneration.mapper.huoban.weixinzhanghao16s.Weixinzhanghao16sMapper;
import com.amchis.firstgeneration.mapper.huoban.yonghu2s.Yonghu2sMapper;
import com.amchis.firstgeneration.mapper.huoban.yonghuguanlizhe14s.Yonghuguanlizhe14sMapper;
import com.amchis.firstgeneration.mapper.huoban.ziduan12s.Ziduan12sMapper;
import com.amchis.firstgeneration.mapper.huoban.ziyuan4s.Ziyuan4sMapper;
import com.amchis.firstgeneration.mapper.huoban.ziyuanleixing3s.Ziyuanleixing3sMapper;
import com.amchis.firstgeneration.utils.DateUtils;
import com.amchis.firstgeneration.utils.GetTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/huoban")
public class HuobanController extends BaseApiService {

    @Autowired
    private JiaoYan10sMapper jiaoYan10sMapper;

    @Autowired
    private BangDingKongZhiQi15sMapper bangDingKongZhiQi15sMapper;

    @Autowired
    private CuoWu9sMapper cuoWu9sMapper;

    @Autowired
    private Gl12He13sMapper gl12He13sMapper;

    @Autowired
    private Gl13He13sMapper gl13He13sMapper;

    @Autowired
    private Gl1he2sMapper gl1he2sMapper;

    @Autowired
    private Gl1He4sMapper gl1He4sMapper;

    @Autowired
    private Gl2He16sMapper gl2He16sMapper;

    @Autowired
    private JianKangWenJuan7sMapper jianKangWenJuan7sMapper;

    @Autowired
    private Jiaoyanleixing11sMapper jiaoyanleixing11sMapper;

    @Autowired
    private Juese1sMapper juese1sMapper;

    @Autowired
    private KeHuYaoWu18sMapper kehuyaowu18sMapper;

    @Autowired
    private Manyidu19sMapper manyidu19sMapper;

    @Autowired
    private Mokuai13sMapper mokuai13sMapper;

    @Autowired
    private Richang6sMapper richang6sMapper;

    @Autowired
    private Shebeiliushuihao17sMapper shebeiliushuihao17sMapper;

    @Autowired
    private Tianxiebiaoji8sMapper tianxiebiaoji8sMapper;

    @Autowired
    private Tijian5sMapper tijian5sMapper;

    @Autowired
    private Weixinzhanghao16sMapper weixinzhanghao16sMapper;

    @Autowired
    private Yonghu2sMapper yonghu2sMapper;

    @Autowired
    private Yonghuguanlizhe14sMapper yonghuguanlizhe14sMapper;

    @Autowired
    private Ziduan12sMapper ziduan12sMapper;

    @Autowired
    private Ziyuan4sMapper ziyuan4sMapper;

    @Autowired
    private Ziyuanleixing3sMapper ziyuanleixing3sMapper;

    /**
     * 绑定控制器
     *
     * @param bangDingKongZhiQi15s
     * @return
     */
    @PostMapping(value = "/bangdingkongzhiqiluru")
    public ReponseVo bindController(@Valid @RequestBody BangDingKongZhiQi15s bangDingKongZhiQi15s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(bangDingKongZhiQi15s, bangDingKongZhiQi15sMapper);
        }
    }

    /**
     * 错误录入
     *
     * @param cuoWu9s
     * @return
     */
    @PostMapping("/cuowuluru")
    public ReponseVo errorInput(@Valid @RequestBody CuoWu9s cuoWu9s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(cuoWu9s, cuoWu9sMapper);
        }
    }

    /**
     * gl12He13s录入
     *
     * @param gl12He13s
     * @return
     */
    @PostMapping("/gl12he13sluru")
    public ReponseVo gl12he13sInput(@Valid @RequestBody Gl12He13s gl12He13s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(gl12He13s, gl12He13sMapper);
        }
    }

    /**
     * gl13He13s录入
     *
     * @param gl13He13s
     * @return
     */
    @PostMapping("/gl13he13sluru")
    public ReponseVo gl13he13sInput(@Valid @RequestBody Gl13He13s gl13He13s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(gl13He13s, gl13He13sMapper);
        }
    }

    /**
     * gl1he2s录入
     *
     * @param gl1he2s
     * @return
     */
    @PostMapping("/gl1he2sluruluru")
    public ReponseVo gl1he2sInput(@Valid @RequestBody Gl1he2s gl1he2s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(gl1he2s, gl1he2sMapper);
        }
    }


    /**
     * gl1he4s录入
     *
     * @param gl1He4s
     * @return
     */
    @PostMapping("/gl1he4sluru")
    public ReponseVo gl1he4sInput(@Valid @RequestBody Gl1He4s gl1He4s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(gl1He4s, gl1He4sMapper);
        }
    }

    /**
     * gl2He16s录入
     *
     * @param gl2He16s
     * @return
     */
    @PostMapping("/gl2he16sluru")
    public ReponseVo gl2he16sInput(@Valid @RequestBody Gl2He16s gl2He16s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(gl2He16s, gl2He16sMapper);
        }
    }

    /**
     * 健康问卷录入
     *
     * @param jianKangWenJuan7s
     * @return
     */
    @PostMapping("/jiankangwenjuanluru")
    public ReponseVo HealthQuestionnaireInput(@Valid @RequestBody JianKangWenJuan7s
                                                      jianKangWenJuan7s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(jianKangWenJuan7s, jianKangWenJuan7sMapper);
        }
    }

    /**
     * 密码录入
     *
     * @param jiaoYan10s
     * @return
     */
    @PostMapping("/jiaoyanluru")
    public ReponseVo passwordInput(@Valid @RequestBody JiaoYan10s jiaoYan10s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(jiaoYan10s, jiaoYan10sMapper);
        }
    }

    /**
     * 密码类型录入
     *
     * @param jiaoyanleixing11s
     * @return
     */
    @PostMapping("/jiaoyanleixingluru")
    public ReponseVo passwordTypeInput(@Valid @RequestBody Jiaoyanleixing11s jiaoyanleixing11s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(jiaoyanleixing11s, jiaoyanleixing11sMapper);
        }
    }

    /**
     * 角色录入
     *
     * @param juese1s bean
     * @return ReponseVo
     */
    @PostMapping("/jueseluru")
    public ReponseVo roleInput(@Valid @RequestBody Juese1s juese1s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(juese1s, juese1sMapper);
        }
    }

    /**
     * 客户药物录入
     *
     * @param kehuyaowu18s bean
     * @return ReponseVo
     */
    @PostMapping("/kehuyaowuluru")
    public ReponseVo customMedicineInput(@Valid @RequestBody Kehuyaowu18s kehuyaowu18s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(kehuyaowu18s, kehuyaowu18sMapper);
        }
    }

    /**
     * 满意度录入
     *
     * @param manyidu19s bean
     * @return ReponseVo
     */
    @PostMapping("/manyiduluru")
    public ReponseVo SatisfactionInput(@Valid @RequestBody Manyidu19s manyidu19s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(manyidu19s, manyidu19sMapper);
        }
    }

    /**
     * 模块录入
     *
     * @param mokuai13s bean
     * @return ReponseVo
     */
    @PostMapping("/mokuailuru")
    public ReponseVo modelInput(@Valid @RequestBody Mokuai13s mokuai13s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(mokuai13s, mokuai13sMapper);
        }
    }

    /**
     * 日常录入
     *
     * @param richang6s bean
     * @return ReponseVo
     */
    @PostMapping("/richangluru")
    public ReponseVo dailyInput(@Valid @RequestBody Richang6s richang6s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(richang6s, richang6sMapper);
        }
    }

    /**
     * sn号录入
     *
     * @param shebeiliushuihao17s bean
     * @return ReponseVo
     */
    @PostMapping("/shebeiliushuihaoluru")
    public ReponseVo deviceSnInput(@Valid @RequestBody Shebeiliushuihao17s shebeiliushuihao17s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(shebeiliushuihao17s, shebeiliushuihao17sMapper);
        }
    }

    /**
     * sn号录入
     *
     * @param tianxiebiaoji8s bean
     * @return ReponseVo
     */
    @PostMapping("/tianxiebiaojiluru")
    public ReponseVo markInput(@Valid @RequestBody Tianxiebiaoji8s tianxiebiaoji8s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(tianxiebiaoji8s, tianxiebiaoji8sMapper);
        }
    }


    /**
     * 体检录入
     *
     * @param tijian5s bean
     * @return ReponseVo
     */
    @PostMapping("/tijianluru")
    public ReponseVo medicalExaminationInput(@Valid @RequestBody Tijian5s tijian5s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(tijian5s, tijian5sMapper);
        }
    }

    /**
     * 微信帐号录入
     *
     * @param weixinzhanghao16s bean
     * @return ReponseVo
     */
    @PostMapping("/weixinzhanghaoluru")
    public ReponseVo weixinAccountInput(@Valid @RequestBody Weixinzhanghao16s weixinzhanghao16s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(weixinzhanghao16s, weixinzhanghao16sMapper);
        }
    }

    /**
     * 用户录入
     *
     * @param yonghu2s bean
     * @return ReponseVo
     */
    @PostMapping("/yonghuluru")
    public ReponseVo userInput(@Valid @RequestBody Yonghu2s yonghu2s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(yonghu2s, yonghu2sMapper);
        }
    }

    /**
     * 用户管理者录入
     *
     * @param yonghuguanlizhe14s bean
     * @return ReponseVo
     */
    @PostMapping("/yonghuguanlizheluru")
    public ReponseVo userAdminInput(@Valid @RequestBody Yonghuguanlizhe14s yonghuguanlizhe14s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(yonghuguanlizhe14s, yonghuguanlizhe14sMapper);
        }
    }

    /**
     * 字段录入
     *
     * @param ziduan12s bean
     * @return ReponseVo
     */
    @PostMapping("/ziduanluru")
    public ReponseVo domainInput(@Valid @RequestBody Ziduan12s ziduan12s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(ziduan12s, ziduan12sMapper);
        }
    }

    /**
     * 资源录入
     *
     * @param ziyuan4s bean
     * @return ReponseVo
     */
    @PostMapping("/ziyuanluru")
    public ReponseVo resourceInput(@Valid @RequestBody Ziyuan4s ziyuan4s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(ziyuan4s, ziyuan4sMapper);
        }
    }

    /**
     * 资源录入
     *
     * @param ziyuanleixing3s bean
     * @return ReponseVo
     */
    @PostMapping("/ziyuanleixingluru")
    public ReponseVo resourceTypeInput(@Valid @RequestBody Ziyuanleixing3s ziyuanleixing3s, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            return commomMethod(ziyuanleixing3s, ziyuanleixing3sMapper);
        }
    }

    /*==================================删除路由================================================*/

    /**
     * 删除绑定控制器
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaobangdingkongzhiqi")
    public ReponseVo controllerDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, bangDingKongZhiQi15sMapper);
    }

    /**
     * 删除错误
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaocuowu")
    public ReponseVo errorDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, cuoWu9sMapper);
    }

    /**
     * 删除gl12he13s
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaogl12he13s")
    public ReponseVo gl12he13sDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, gl12He13sMapper);
    }

    /**
     * 删除gl13he13s
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaogl13he13s")
    public ReponseVo gl13he13sDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, gl13He13sMapper);
    }

    /**
     * 删除gl1he2s
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaogl1he2s")
    public ReponseVo gl1he2sDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, gl1he2sMapper);
    }

    /**
     * 删除gl1he4s
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaogl1he4s")
    public ReponseVo gl1he4sDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, gl1He4sMapper);
    }

    /**
     * 删除gl2he16s
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaogl2he16s")
    public ReponseVo gl2he16sDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, gl2He16sMapper);
    }

    /**
     * 删除健康问卷
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaojiankangwenjuan")
    public ReponseVo healthQuestionnaireDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, jianKangWenJuan7sMapper);
    }

    /**
     * 删除密码
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaojiaoyan")
    public ReponseVo passwordDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, jiaoYan10sMapper);
    }

    /**
     * 删除密码类型
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaojiaoyanleixing")
    public ReponseVo passwordTypeDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, jiaoyanleixing11sMapper);
    }

    /**
     * 删除role
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaojuese")
    public ReponseVo roleDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, juese1sMapper);
    }

    /**
     * shixiaokehuyaowu
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaokehuyaowu")
    public ReponseVo customMedicineDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, kehuyaowu18sMapper);
    }

    /**
     * shixiaokehuyaowu
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaomanyidu")
    public ReponseVo satisfactionDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, manyidu19sMapper);
    }

    /**
     * shixiaomokuai
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaomokuai")
    public ReponseVo modelDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, mokuai13sMapper);
    }

    /**
     * shixiaorichang
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaorichang")
    public ReponseVo daliyDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, richang6sMapper);
    }

    /**
     * shixiaoshebeiliushuihao
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaoshebeiliushuihao")
    public ReponseVo deviceSnDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, shebeiliushuihao17sMapper);
    }

    /**
     * shixiaotianxiebiaoji
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaotianxiebiaoji")
    public ReponseVo markDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, tianxiebiaoji8sMapper);
    }

    /**
     * shixiaotijian
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaotijian")
    public ReponseVo medicalExaminationDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, tijian5sMapper);
    }

    /**
     * shixiaoweixinzhanghao
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaoweixinzhanghao")
    public ReponseVo weixinAccountDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, weixinzhanghao16sMapper);
    }

    /**
     * shixiaoyonghu
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaoyonghu")
    public ReponseVo userDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, yonghu2sMapper);
    }

    /**
     * shixiaoyonghuguanlizhe
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaoyonghuguanlizhe")
    public ReponseVo userAdminDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, yonghuguanlizhe14sMapper);
    }

    /**
     * shixiaoziduan
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaoziduan")
    public ReponseVo domainDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, ziduan12sMapper);
    }

    /**
     * shixiaoziyuan
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaoziyuan")
    public ReponseVo resourceDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, ziyuan4sMapper);
    }

    /**
     * shixiaoziyuanleixing
     *
     * @param Ids id
     * @return ReponseVo
     */
    @PostMapping("/shixiaoziyuanleixing")
    public ReponseVo resourceTypeDelete(@RequestBody Integer[] Ids) {
        return commomDelete(Ids, ziyuanleixing3sMapper);
    }
    /*===================================控制器==========================================*/


    /**
     * 查询一个绑定设备
     *
     * @param request          获取jwt中的用户
     * @param WifimingChaxun   WiFi名称
     * @param LiushuihaoChaxun sn号
     * @return ReponseVo
     */
    @PostMapping("/chaxunyigewifi")
    public ReponseVo getOneWifi(HttpServletRequest request, @RequestBody String WifimingChaxun, String LiushuihaoChaxun) {
        String biaoji = (String) request.getAttribute("biaoji");
        if (StringUtils.isEmpty(WifimingChaxun) && StringUtils.isEmpty(LiushuihaoChaxun)) {
            List<BangDingKongZhiQi15s> bangDingKongZhiQi15s = bangDingKongZhiQi15sMapper.ChaxunYibangding(biaoji);
            return setResult("1", bangDingKongZhiQi15s);
        }
        BangDingKongZhiQi15s bangDingKongZhiQi15s1 = bangDingKongZhiQi15sMapper.selectBySnOrWifiName(LiushuihaoChaxun, WifimingChaxun);
        List<BangDingKongZhiQi15s> list = new ArrayList<>();
        list.add(bangDingKongZhiQi15s1);
        if (bangDingKongZhiQi15s1 == null) {
            return setResult("1", "WIFI_LIUSHUIHAO_BUCUNZAI", "请输入正确的wifi名或流水号进行查询！");
        } else if (StringUtils.equals("0", bangDingKongZhiQi15s1.getShoujihao())) {
            return setResult("1", list);
        } else {
            BangDingKongZhiQi15s bangDingKongZhiQi15s = bangDingKongZhiQi15sMapper.ChaxunGuanjiaWifi(biaoji, WifimingChaxun, LiushuihaoChaxun);
            list.clear();
            list.add(bangDingKongZhiQi15s);
            return setResult("1", list);
        }
    }

    /**
     * 查询已绑定
     *
     * @param request 获取登录信息
     * @return ReponseVo
     */
    @PostMapping("/ChaxunYibangding")
    public ReponseVo chaxunYibangding(HttpServletRequest request) {
        String biaoji = (String) request.getAttribute("biaoji");
        List<BangDingKongZhiQi15s> bangDingKongZhiQi15s = bangDingKongZhiQi15sMapper.ChaxunYibangding(biaoji);
        if (bangDingKongZhiQi15s != null && bangDingKongZhiQi15s.size() > 0) {
            return setResult("1", bangDingKongZhiQi15s);
        } else {
            return setResult("0", "MEIYOU_SHUJU", "您未给客户绑定设备流水号，无数据！");
        }

    }


    /**
     * 绑定用户
     *
     * @param bindUser bean
     * @return ReponseVo
     */
    @PostMapping("/bangdingyonghu")
    public ReponseVo bangdingyonghu(@Valid @RequestBody BangDingKongZhiQi15sforBindUser bindUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            String shoujihao = bindUser.getShoujihao();
            BangDingKongZhiQi15s bangDingKongZhiQi15s1 = bangDingKongZhiQi15sMapper.selectByPhone(shoujihao);
            if (bangDingKongZhiQi15s1 != null) {
                return setResult("0", "SHOUJIHAO_YIBANGDING", "该手机号已经绑定了设备,一台DNAMY设备只能绑定一个手机号,请勿重复绑定！");
            }
            BangDingKongZhiQi15s bindController = bangDingKongZhiQi15sMapper.getByWifiNameOrSN(bindUser.getWifiming(), bindUser.getLiushuihao(), "");
            if (bindController == null) {
                return setResult("0", "WIFI_CUOWU", "请勿更改wifi名和流水号!");
            } else {
                bindController.setShoujihao(bindUser.getShoujihao());
                bindController.setRiqi(DateUtils.getDay());
                int i = bangDingKongZhiQi15sMapper.updateByPrimaryKeySelective(bindController);
                if (!toDaoResult(i)) {
                    return setResult("0", "LURU_SHIBAI", "录入失败");
                } else {
                    return setResult("1", "LURU_CHENGGONG", "录入成功");
                }
            }
        }
    }

    /**
     * 解除绑定用户
     *
     * @param bindUser bean
     * @return ReponseVo
     */
    @PostMapping("/jiechubangding")
    public ReponseVo jiechubangding(@Valid @RequestBody BangDingKongZhiQi15sforBindUser bindUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return setResult("0", "QINGTIANXIEWANZHENG", errorMsg);
        } else {
            BangDingKongZhiQi15s bindController = bangDingKongZhiQi15sMapper.getByWifiNameOrSN(bindUser.getWifiming(), bindUser.getLiushuihao(), bindUser.getShoujihao());
            if (bindController == null) {
                return setResult("0", "BANGDING_BUCUNZAI", "绑定信息不存在!");
            } else {
                bangDingKongZhiQi15sMapper.deleteByPrimaryKey(bindController.getId());
                bindUser.setWaijian(GetTime.getGuid());
                bindUser.setShixiao("0");
                bindUser.setLuruduan("JIECHU_CHONGZHI");
                bindUser.setRiqi(DateUtils.getDay());
                int i = bangDingKongZhiQi15sMapper.insertSelective4BindUser(bindUser);
                if (!toDaoResult(i)) {
                    return setResult("0", "LURU_SHIBAI", "录入失败");
                } else {
                    return setResult("1", "LURU_CHENGGONG", "录入成功");
                }
            }
        }
    }

    /*=================================================管家客户===========================================================*/

    /**
     * @param shoujihao bean
     * @return ReponseVo
     */
    @PostMapping("/guanjiachaxunkehu")
    public ReponseVo guanjiachaxunkehu(HttpServletRequest request, @RequestBody String shoujihao) {
        String jueseBianma = (String) request.getAttribute("JueseBianma");
        String biaoji = (String) request.getAttribute("Biaoji");
        if ("MEIHUA_ZHUGUAN".equals(jueseBianma) || "JIYIN_JIANCE".equals(jueseBianma)) {
            List<Yonghu2s> yonghu2s = yonghu2sMapper.ChaxunZhuguanKehu();
            return setResult("1", yonghu2s);
        } else {
            List<Yonghu2s> yonghu2s = yonghu2sMapper.ChaxunGuanjiayonghu(biaoji, shoujihao);
            if (yonghu2s != null && yonghu2s.size() > 0) {
                return setResult("1", yonghu2s);
            } else {
                return setResult("0", "WEIBANGDING_KEHU", "客户未在微信端绑定您的信息，您无法查看用户数据！");
            }
        }

    }

    /**
     * @param GenggaiMimaMoxingCanshu bean
     * @return ReponseVo
     */
    @PostMapping("/guanjiaxiugaimima")
    public ReponseVo guanjiaxiugaimima(HttpServletRequest request, @RequestBody GenggaiMimaMoxingCanshu GenggaiMimaMoxingCanshu) {
        String biaoji = (String) request.getAttribute("Biaoji");
        if (GenggaiMimaMoxingCanshu != null) {
            if (!GenggaiMimaMoxingCanshu.getQuerenXinmima().equals(GenggaiMimaMoxingCanshu.getXinmima())) {
                return setResult("0", "MIMA_QUERENMIMA_BUTONG", "新密码和确认新密码不相同，请重新输入！");
            }
            if (!"0".equals(biaoji)) {
                Yonghu2s yonghu2s = yonghu2sMapper.ChaxunGuanjiayonghuByWaijian(biaoji);
                if (yonghu2s != null) {
                    JiaoYan10s jiaoYan10s = jiaoYan10sMapper.jiaoyanMima(biaoji, GenggaiMimaMoxingCanshu.getJiumima());
                    if (jiaoYan10s != null) {
                        jiaoYan10s.setJiaoyanzhi(GenggaiMimaMoxingCanshu.getQuerenXinmima());
                        jiaoYan10sMapper.updateByPrimaryKeySelective(jiaoYan10s);
                    } else {
                        return setResult("0", "JIUMIMA_CUOWU", "旧密码错误，请重新输入！如忘记旧密码，请联系美华尚医系统管理员进行重置！");
                    }
                }
            } else {
                return setResult("0", "DENGLU_CHAOSHI", "登录信息已超时，请重新登录！");
            }
        }
        return setResult("0", "DENGLU_CHAOSHI", "登录信息已超时，请重新登录！");
    }
}
