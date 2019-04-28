package com.amchis.firstgeneration.controller.kehuapp;

import com.alibaba.druid.util.StringUtils;
import com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15s;
import com.amchis.firstgeneration.bean.guanli.jwtbean.Jwtbean;
import com.amchis.firstgeneration.bean.guanli.user.User;
import com.amchis.firstgeneration.bean.huoban.jiaoyan10s.JiaoYan10s;
import com.amchis.firstgeneration.bean.huoban.kehuyaowu18s.Kehuyaowu18s;
import com.amchis.firstgeneration.bean.huoban.manyidu19s.Manyidu19s;
import com.amchis.firstgeneration.bean.huoban.richang6s.Richang6s;
import com.amchis.firstgeneration.bean.huoban.shujuriqi.ShujuRiqi;
import com.amchis.firstgeneration.bean.huoban.tijian5s.Tijian5s;
import com.amchis.firstgeneration.bean.huoban.wenjuan.WenjuanShuju;
import com.amchis.firstgeneration.bean.huoban.yonghu2s.Yonghu2s;
import com.amchis.firstgeneration.bean.huoban.yonghuguanlizhe14s.Yonghuguanlizhe14s;
import com.amchis.firstgeneration.bean.kehuapp.Bangdingguanjia.Bangdingguanjia;
import com.amchis.firstgeneration.bean.kehuapp.Yaowuqushishuju.Yaowuqushishuju;
import com.amchis.firstgeneration.bean.kehuapp.denglu.DengluBiaodan;
import com.amchis.firstgeneration.bean.kehuapp.zidongdenglu.Zidongdenglu;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15sMapper;
import com.amchis.firstgeneration.mapper.guanli.kehuyaowu18s.KeHuYaoWu18sMapper;
import com.amchis.firstgeneration.mapper.guanli.user.UserMapper;
import com.amchis.firstgeneration.mapper.huoban.jiaoyan10s.JiaoYan10sMapper;
import com.amchis.firstgeneration.mapper.huoban.manyidu19s.Manyidu19sMapper;
import com.amchis.firstgeneration.mapper.huoban.richang6s.Richang6sMapper;
import com.amchis.firstgeneration.mapper.huoban.tijian5s.Tijian5sMapper;
import com.amchis.firstgeneration.mapper.huoban.yonghu2s.Yonghu2sMapper;
import com.amchis.firstgeneration.mapper.huoban.yonghuguanlizhe14s.Yonghuguanlizhe14sMapper;
import com.amchis.firstgeneration.utils.DateUtils;
import com.amchis.firstgeneration.utils.GetTime;
import com.amchis.firstgeneration.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/kehuapp")
public class KehuAppController extends BaseApiService {

    @Autowired
    private BangDingKongZhiQi15sMapper bangDingKongZhiQi15sMapper;

    @Autowired
    private Yonghu2sMapper yonghu2sMapper;

    @Autowired
    private JiaoYan10sMapper jiaoYan10sMapper;

    @Autowired
    private Tijian5sMapper tijian5sMapper;

    @Autowired
    private KeHuYaoWu18sMapper keHuYaoWu18sMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Yonghuguanlizhe14sMapper yonghuguanlizhe14sMapper;

    @Autowired
    private Manyidu19sMapper manyidu19sMapper;

    @Autowired
    private Richang6sMapper richang6sMapper;

    /**
     * 注册接口
     *
     * @param dengluBiaodan
     * @return
     */
    @PostMapping("/zhuce")
    public ReponseVo zhuce(@Valid @RequestBody DengluBiaodan dengluBiaodan, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", "请录入手机号");
        } else {
            BangDingKongZhiQi15s bindController = bangDingKongZhiQi15sMapper.selectByPhone(dengluBiaodan.getShoujihao());
            if (bindController != null) {
                Yonghu2s yonghu2s1 = yonghu2sMapper.chaxunyonghuByshouji(dengluBiaodan.getShoujihao());
                if (yonghu2s1 != null) {
                    return setResult("0", "SHOUJIHAO_YIZHUCE", "手机号已经注册，请直接登录!");
                } else {
                    Yonghu2s yonghu2s = new Yonghu2s();
                    yonghu2s.setWaijian(GetTime.getGuid());
                    yonghu2s.setShixiao("0");
                    yonghu2s.setRiqi(DateUtils.getDay());
                    yonghu2s.setLuruduan(dengluBiaodan.getLuruduan());
                    yonghu2s.setShoujihao(dengluBiaodan.getShoujihao());
                    int i = yonghu2sMapper.insertSelective(yonghu2s);
                    if (toDaoResult(i)) {
                        JiaoYan10s jiaoYan10s = new JiaoYan10s();
                        jiaoYan10s.setYonghuwaijian(yonghu2s.getWaijian());
                        jiaoYan10s.setJiaoyanzhi(dengluBiaodan.getMima());
                        jiaoYan10s.setShixiao("0");
                        jiaoYan10s.setRiqi(DateUtils.getDay());
                        int i1 = jiaoYan10sMapper.insertSelective(jiaoYan10s);
                        if (toDaoResult(i1)) {
                            Jwtbean jwtbean = new Jwtbean(yonghu2s.getWaijian(), yonghu2s.getShoujihao(), System.currentTimeMillis());
                            String jwt = JwtUtil.createJWT(jwtbean);
                            String[] tokenarr = {jwt};
                            return setResult("1", tokenarr);
                        } else {
                            return setResult("0", "MIMA_SHIBAI", "密码保存失败，请联系管理员！");
                        }
                    } else {
                        return setResult("0", "YONGHU_SHIBAI", "用户保存失败，请联系管理员！");
                    }
                }
            } else {
                return setResult("0", "SHOUJIHAO_WEIBANGDING", "您的手机号未绑定到设备，请联系经销商绑定您的手机号到设备！");
            }
        }
    }

    /**
     * 登录接口
     *
     * @param dengluBiaodan
     * @return
     */
    @PostMapping("/denglu")
    public ReponseVo denglu(@Valid @RequestBody DengluBiaodan dengluBiaodan, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            Yonghu2s yonghu2s2 = yonghu2sMapper.selectByShoujihaoAndJiaoyan(dengluBiaodan.getShoujihao(), dengluBiaodan.getMima());
            if (yonghu2s2 == null) {
                return setResult("0", "DENGLU_SHIBAI", "登录失败，请检测您的密码或用户名是否正确！");
            } else {
                Jwtbean jwtbean = new Jwtbean(yonghu2s2.getWaijian(), yonghu2s2.getShoujihao(), System.currentTimeMillis());
                String jwt = JwtUtil.createJWT(jwtbean);
                String[] tokenarr = {jwt};
                return setResult("1", tokenarr);
            }
        }
    }

    /**
     * 自动登录
     *
     * @param dengluBiaodan bean
     * @param request       http
     * @return ReponseVo
     */
    @PostMapping("/zidongdenglu")
    public ReponseVo zidongdenglu(HttpServletRequest request, @Valid @RequestBody DengluBiaodan dengluBiaodan, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            String Shujuriqi = tijian5sMapper.ChaxunGerenZuizaoTijian(biaoji);
            if (!StringUtils.isEmpty(Shujuriqi)) {
                Tijian5s tijian5s = tijian5sMapper.selectByshujuriAndWaijian(Shujuriqi, biaoji);
                Zidongdenglu guanjia = yonghu2sMapper.HuoquGuanjia(biaoji);
                String guanjiagonghao = guanjia.getGuanjiagonghao();
                if (!StringUtils.isEmpty(guanjiagonghao)) {
                    tijian5s.setGuanjiacunzai("1");
                } else {
                    tijian5s.setGuanjiacunzai("0");
                }
                tijian5s.setJiaoxueUrl("http://www.iqiyi.com/w_19rzjqdzx9.html");
                Yonghu2s yonghu2s = yonghu2sMapper.ChaxunYigeYonghu2s(biaoji);
                if (yonghu2s != null && "0".equals(yonghu2s.getShenfenzheng()) && "0".equals(yonghu2s.getMingcheng())) {
                    tijian5s.setWenjuancunzai("1");
                } else {
                    tijian5s.setWenjuancunzai("0");
                }
                String s = keHuYaoWu18sMapper.ChaxunGerenZuixinYaowu(biaoji);
                List<Kehuyaowu18s> keHuYaoWu18s = keHuYaoWu18sMapper.ChaxunGerenZuixinYaowu1(s, biaoji);
                getTijian5s(tijian5s, keHuYaoWu18s);
                return setResult("1", tijian5s);
            } else {
                return setResult("0", "CAOZUOSHIBAI", "操作失败");
            }
        }
    }

    /**
     * 绑定管家
     *
     * @param bangdingguanjia bean
     * @param request         http
     * @return ReponseVo
     */
    @PostMapping("/bangdingguanjia")
    public ReponseVo bangdingguanjia(HttpServletRequest request, @Valid @RequestBody Bangdingguanjia bangdingguanjia, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            User user = userMapper.findByName(bangdingguanjia.getGuanjiaGonghao());
            if (user != null) {
                Yonghuguanlizhe14s yonghuguanlizhe14s = yonghuguanlizhe14sMapper.selectByWaijianAndGuanjiaWaijian(biaoji, user.getWaijian());
                if (yonghuguanlizhe14s != null) {
                    return setResult("0", "YIBANGDING_GUANJIA", "您已经绑定了管家，请勿重复绑定！");
                } else {
                    Yonghu2s yonghu2s = yonghu2sMapper.ChaxunYigeYonghu2s(biaoji);
                    if (yonghu2s != null) {
                        yonghu2s.setShenfenzheng(bangdingguanjia.getShenfenzheng());
                        int i = yonghu2sMapper.updateByPrimaryKeySelective(yonghu2s);
                        if (toDaoResult(i)) {
                            yonghuguanlizhe14s = new Yonghuguanlizhe14s();
                            yonghuguanlizhe14s.setYonghuwaijian(biaoji);
                            yonghuguanlizhe14s.setWaijian(GetTime.getGuid());
                            yonghuguanlizhe14s.setGuanjiawaijian(user.getWaijian());
                            int i1 = yonghuguanlizhe14sMapper.insertSelective(yonghuguanlizhe14s);
                            if (toDaoResult(i1)) {
                                return setResult("1", "BANGDING_CHENGGONG", "绑定管家成功！您绑定的管家将根据您的日常数据及生物波更新数据对您进行设备使用辅助，如有任何疑问请与管家进行联系！");
                            } else {
                                return setResult("0", "XITONG_CUOWU", "绑定失败，系统错误，请联系管理员！");
                            }
                        } else {
                            return setResult("0", "SHENFENZHENG_SHIBAI", "身份证绑定失败，请联系管理员！");
                        }
                    }
                }
            } else {
                return setResult("0", "WEIZHAODAOGUANJIA", "未找到管家");
            }
            return setResult("0", "WEIZHAODAOGUANJIA", "未找到管家");
        }
    }

    /**
     * 日常数据
     *
     * @param kehuyaowu18s bean
     * @param request      http
     * @return ReponseVo
     */
    @PostMapping("/richangshuju")
    public ReponseVo richangshuju(HttpServletRequest request, @Valid @RequestBody Kehuyaowu18s kehuyaowu18s, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            BangDingKongZhiQi15s bangDingKongZhiQi15s = bangDingKongZhiQi15sMapper.selectByPhone(shoujihao);
            if (bangDingKongZhiQi15s == null) {
                return setResult("0", "YI_JIEBANG", "您已经解绑设备，无法再填写日常数据！");
            }
            List<Kehuyaowu18s> keHuYaoWu18s1 = keHuYaoWu18sMapper.ChaxunGerenZuixinYaowu1(kehuyaowu18s.getShujuriqi(), biaoji);
            for (Kehuyaowu18s keHuYaoWu18 : keHuYaoWu18s1) {
                keHuYaoWu18sMapper.deleteByPrimaryKey(keHuYaoWu18.getId());
            }
            return saveYaowu(kehuyaowu18s, biaoji);
        }
    }

    private ReponseVo saveYaowu(@RequestBody @Valid Kehuyaowu18s kehuyaowu18s, String biaoji) {
        if (StringUtils.isEmpty(kehuyaowu18s.getZaoYidao()) && StringUtils.isEmpty(kehuyaowu18s.getZaoYidaoLiang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getZaoYidao());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getZaoYidaoLiang());
            kehuyaowu18s.setQujian("ZAO");
            kehuyaowu18s.setLeixing("YIDAO");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getZaoKoufu1()) && StringUtils.isEmpty(kehuyaowu18s.getZaoKoufu1Liang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getZaoKoufu1());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getZaoKoufu1Liang());
            kehuyaowu18s.setQujian("ZAO");
            kehuyaowu18s.setLeixing("KOUFUYAO1");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getZaoKoufu2()) && StringUtils.isEmpty(kehuyaowu18s.getZaoKoufu2Liang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getZaoKoufu2());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getZaoKoufu2Liang());
            kehuyaowu18s.setQujian("ZAO");
            kehuyaowu18s.setLeixing("KOUFUYAO2");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getZaoKoufu3()) && StringUtils.isEmpty(kehuyaowu18s.getZaoKoufu3Liang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getZaoKoufu3());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getZaoKoufu3Liang());
            kehuyaowu18s.setQujian("ZAO");
            kehuyaowu18s.setLeixing("KOUFUYAO3");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getZhongYidao()) && StringUtils.isEmpty(kehuyaowu18s.getZhongYidaoLiang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getZhongYidao());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getZhongYidaoLiang());
            kehuyaowu18s.setQujian("ZHONG");
            kehuyaowu18s.setLeixing("YIDAO");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getZhongKoufu1()) && StringUtils.isEmpty(kehuyaowu18s.getZhongKoufu1Liang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getZhongKoufu1());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getZhongKoufu1Liang());
            kehuyaowu18s.setQujian("ZHONG");
            kehuyaowu18s.setLeixing("KOUFUYAO1");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getZhongKoufu2()) && StringUtils.isEmpty(kehuyaowu18s.getZhongKoufu2Liang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getZhongKoufu2());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getZhongKoufu2Liang());
            kehuyaowu18s.setQujian("ZHONG");
            kehuyaowu18s.setLeixing("KOUFUYAO2");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getZhongKoufu3()) && StringUtils.isEmpty(kehuyaowu18s.getZhongKoufu3Liang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getZhongKoufu3());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getZhongKoufu3Liang());
            kehuyaowu18s.setQujian("ZHONG");
            kehuyaowu18s.setLeixing("KOUFUYAO3");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getWanYidao()) && StringUtils.isEmpty(kehuyaowu18s.getWanYidaoLiang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getWanYidao());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getWanYidaoLiang());
            kehuyaowu18s.setQujian("WAN");
            kehuyaowu18s.setLeixing("YIDAO");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getWanKoufu1()) && StringUtils.isEmpty(kehuyaowu18s.getWanKoufu1Liang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getWanKoufu1());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getWanKoufu1Liang());
            kehuyaowu18s.setQujian("WAN");
            kehuyaowu18s.setLeixing("KOUFUYAO1");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getWanKoufu2()) && StringUtils.isEmpty(kehuyaowu18s.getWanKoufu2Liang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getWanKoufu2());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getWanKoufu2Liang());
            kehuyaowu18s.setQujian("WAN");
            kehuyaowu18s.setLeixing("KOUFUYAO2");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getWanKoufu3()) && StringUtils.isEmpty(kehuyaowu18s.getWanKoufu3Liang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getWanKoufu3());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getWanKoufu3Liang());
            kehuyaowu18s.setQujian("WAN");
            kehuyaowu18s.setLeixing("KOUFUYAO3");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        if (StringUtils.isEmpty(kehuyaowu18s.getShuiqianYidao()) && StringUtils.isEmpty(kehuyaowu18s.getShuiqianYidaoLiang())) {
            kehuyaowu18s.setMingcheng(kehuyaowu18s.getShuiqianYidao());
            kehuyaowu18s.setJiliang(kehuyaowu18s.getShuiqianYidaoLiang());
            kehuyaowu18s.setQujian("SHUIQIAN");
            kehuyaowu18s.setLeixing("YIDAO");
            return getResponseVo(kehuyaowu18s, biaoji);
        }
        return setResult("0", "RICHANG_LURU_SHIBAI", "日常数据录入失败，请联系管理员！");
    }

    private ReponseVo getResponseVo(@Valid @RequestBody Kehuyaowu18s kehuyaowu18s, String biaoji) {
        kehuyaowu18s.setWaijian(GetTime.getGuid());
        kehuyaowu18s.setYonghuwaijian(biaoji);
        kehuyaowu18s.setShixiao("0");
        kehuyaowu18s.setRiqi(DateUtils.getDay());
        int i = keHuYaoWu18sMapper.insertSelective(kehuyaowu18s);
        if (toDaoResult(i)) {
            return setResult("1", "TIANJIA_RICHANG_CHENGGONG", "添加日常数据成功!");
        } else {
            return setResult("0", "RICHANG_LURU_SHIBAI", "日常数据录入失败，请联系管理员！");
        }
    }

    /**
     * 日常数据
     *
     * @param kehuyaowu18s bean
     * @param request      http
     * @return ReponseVo
     */
    @PostMapping("/richangiosshuju")
    public ReponseVo richangiosshuju(HttpServletRequest request, @Valid @RequestBody Kehuyaowu18s kehuyaowu18s, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            BangDingKongZhiQi15s bangDingKongZhiQi15s = bangDingKongZhiQi15sMapper.selectByPhone(shoujihao);
            if (bangDingKongZhiQi15s == null) {
                return setResult("0", "YI_JIEBANG", "您已经解绑设备，无法再填写日常数据！");
            }
            List<Kehuyaowu18s> keHuYaoWu18s1 = keHuYaoWu18sMapper.ChaxunGerenZuixinYaowu1(kehuyaowu18s.getShujuriqi(), biaoji);
            for (Kehuyaowu18s keHuYaoWu18 : keHuYaoWu18s1) {
                keHuYaoWu18sMapper.deleteByPrimaryKey(keHuYaoWu18.getId());
            }
            return saveYaowu(kehuyaowu18s, biaoji);
        }
    }


    /**
     * 体检数据
     *
     * @param tijian5s bean
     * @param request  http
     * @return ReponseVo
     */
    @PostMapping("/tijianshuju")
    public ReponseVo tijianshuju(HttpServletRequest request, @Valid @RequestBody Kehuyaowu18s tijian5s, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            BangDingKongZhiQi15s bangDingKongZhiQi15s = bangDingKongZhiQi15sMapper.selectByPhone(shoujihao);
            if (bangDingKongZhiQi15s == null) {
                return setResult("0", "YI_JIEBANG", "您已经解绑设备，无法再填写日常数据！");
            }
            List<Kehuyaowu18s> keHuYaoWu18s = keHuYaoWu18sMapper.ChaxunGerenZuixinYaowu1(tijian5s.getShujuriqi(), biaoji);
            for (Kehuyaowu18s keHuYaoWu18 : keHuYaoWu18s) {
                keHuYaoWu18sMapper.deleteByPrimaryKey(keHuYaoWu18.getId());
            }
            if (!"45".equals(tijian5s.getShujuZhouqi())) {
                //健康状况
                if (StringUtils.isEmpty(tijian5s.getJiankangzhuangkuang())) {
                    return setResult("0", "QINGLURU_JIANKANGZHUANGKUANG", "请录入健康状况");
                }
                if (StringUtils.isEmpty(tijian5s.getShuimianqingkuang())) {
                    return setResult("0", "QINGLURU_SHUIMIANQINGKUANG", "请录入睡眠情况");
                }
                if (StringUtils.isEmpty(tijian5s.getTanghuaxuehongdanbai())) {
                    return setResult("0", "QINGLURU_TANGHUAXUEHONGDANBAI", "请录入糖化血红蛋白");
                }
                if (StringUtils.isEmpty(tijian5s.getGanyousanzhi())) {
                    return setResult("0", "QINGLURU_GANYOUSANZHI", "请录入甘油三酯");
                }
                if (StringUtils.isEmpty(tijian5s.getZongdanguchun())) {
                    return setResult("0", "QINGLURU_ZONGDANGUCHUN", "请录入总胆固醇");
                }
                if (StringUtils.isEmpty(tijian5s.getGaomiduzhidanbaidanguchun())) {
                    return setResult("0", "QINGLURU_GAOMIDUZHIDANBAIDANGUCHUN", "请录入高密度脂蛋白胆固醇");
                }
                if (StringUtils.isEmpty(tijian5s.getDimiduzhidanbaidanguchun())) {
                    return setResult("0", "QINGLURU_DIMIDUZHIDANBAIDANGUCHUN", "请录入低密度脂蛋白胆固醇");
                }
                if (StringUtils.isEmpty(tijian5s.getNiaosuan())) {
                    return setResult("0", "QINGLURU_NIAOSUAN", "请录入尿酸");
                }
                if (StringUtils.isEmpty(tijian5s.getCtai())) {
                    return setResult("0", "QINGLURU_CTAI", "请录入C肽");
                }
                if (StringUtils.isEmpty(tijian5s.getGucaozhuananmei())) {
                    return setResult("0", "QINGLURU_GUCAOZHUANANMEI", "请录入谷草转氨酶");
                }
                if (StringUtils.isEmpty(tijian5s.getZongdanhongsu())) {
                    return setResult("0", "QINGLURU_ZONGDANHONGSU", "请录入总胆红素");
                }
                if (StringUtils.isEmpty(tijian5s.getChaomincfanyingdanbai())) {
                    return setResult("0", "QINGLURU_CHAOMINCFANYINGDANBAI", "请录入超敏C反应蛋白");
                }
                if (StringUtils.isEmpty(tijian5s.getTizhong())) {
                    return setResult("0", "QINGLURU_TIZHONG", "请录入体重");
                }
            }
            return saveYaowu(tijian5s, biaoji);
        }
    }

    /**
     * 体检数据ios
     *
     * @param tijian5s bean
     * @param request  http
     * @return ReponseVo
     */
    @PostMapping("/tijianiosshuju")
    public ReponseVo tijianiosshuju(HttpServletRequest request, @Valid @RequestBody Kehuyaowu18s tijian5s, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            BangDingKongZhiQi15s bangDingKongZhiQi15s = bangDingKongZhiQi15sMapper.selectByPhone(shoujihao);
            if (bangDingKongZhiQi15s == null) {
                return setResult("0", "YI_JIEBANG", "您已经解绑设备，无法再填写日常数据！");
            }
            List<Kehuyaowu18s> keHuYaoWu18s = keHuYaoWu18sMapper.ChaxunGerenZuixinYaowu1(tijian5s.getShujuriqi(), biaoji);
            for (Kehuyaowu18s keHuYaoWu18 : keHuYaoWu18s) {
                keHuYaoWu18sMapper.deleteByPrimaryKey(keHuYaoWu18.getId());
            }
            if (!"45".equals(tijian5s.getShujuZhouqi())) {
                //健康状况
                if (StringUtils.isEmpty(tijian5s.getJiankangzhuangkuang())) {
                    return setResult("0", "QINGLURU_JIANKANGZHUANGKUANG", "请录入健康状况");
                }
                if (StringUtils.isEmpty(tijian5s.getShuimianqingkuang())) {
                    return setResult("0", "QINGLURU_SHUIMIANQINGKUANG", "请录入睡眠情况");
                }
                if (StringUtils.isEmpty(tijian5s.getTanghuaxuehongdanbai())) {
                    return setResult("0", "QINGLURU_TANGHUAXUEHONGDANBAI", "请录入糖化血红蛋白");
                }
                if (StringUtils.isEmpty(tijian5s.getGanyousanzhi())) {
                    return setResult("0", "QINGLURU_GANYOUSANZHI", "请录入甘油三酯");
                }
                if (StringUtils.isEmpty(tijian5s.getZongdanguchun())) {
                    return setResult("0", "QINGLURU_ZONGDANGUCHUN", "请录入总胆固醇");
                }
                if (StringUtils.isEmpty(tijian5s.getGaomiduzhidanbaidanguchun())) {
                    return setResult("0", "QINGLURU_GAOMIDUZHIDANBAIDANGUCHUN", "请录入高密度脂蛋白胆固醇");
                }
                if (StringUtils.isEmpty(tijian5s.getDimiduzhidanbaidanguchun())) {
                    return setResult("0", "QINGLURU_DIMIDUZHIDANBAIDANGUCHUN", "请录入低密度脂蛋白胆固醇");
                }
                if (StringUtils.isEmpty(tijian5s.getNiaosuan())) {
                    return setResult("0", "QINGLURU_NIAOSUAN", "请录入尿酸");
                }
                if (StringUtils.isEmpty(tijian5s.getCtai())) {
                    return setResult("0", "QINGLURU_CTAI", "请录入C肽");
                }
                if (StringUtils.isEmpty(tijian5s.getGucaozhuananmei())) {
                    return setResult("0", "QINGLURU_GUCAOZHUANANMEI", "请录入谷草转氨酶");
                }
                if (StringUtils.isEmpty(tijian5s.getZongdanhongsu())) {
                    return setResult("0", "QINGLURU_ZONGDANHONGSU", "请录入总胆红素");
                }
                if (StringUtils.isEmpty(tijian5s.getChaomincfanyingdanbai())) {
                    return setResult("0", "QINGLURU_CHAOMINCFANYINGDANBAI", "请录入超敏C反应蛋白");
                }
                if (StringUtils.isEmpty(tijian5s.getTizhong())) {
                    return setResult("0", "QINGLURU_TIZHONG", "请录入体重");
                }
            }
            return saveYaowu(tijian5s, biaoji);
        }
    }


    /**
     * 问卷数据
     *
     * @param wenjuanShuju bean
     * @param request      http
     * @return ReponseVo
     */
    @PostMapping("/wenjuanshuju")
    public ReponseVo wenjuanshuju(HttpServletRequest request, @Valid @RequestBody WenjuanShuju wenjuanShuju, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            Yonghu2s yonghu2s = yonghu2sMapper.ChaxunYigeYonghu2s(biaoji);
            if (yonghu2s != null) {
                yonghu2s.setShengao(wenjuanShuju.getShengao());
                yonghu2s.setMingcheng(wenjuanShuju.getMingcheng());
                yonghu2s.setShenfenzheng(wenjuanShuju.getShenfenzheng());
                yonghu2s.setXingbie(wenjuanShuju.getXingbie());
                yonghu2s.setShengri(wenjuanShuju.getShengri());
                yonghu2s.setShengao(wenjuanShuju.getShengao());
                int i = yonghu2sMapper.updateByPrimaryKeySelective(yonghu2s);
                if (toDaoResult(i)) {
                    return setResult("1", "BAOCUNCHENGGONG", "保存成功");
                } else {
                    return setResult("0", "BAOCUNSHIBAI", "保存失败");
                }
            } else {
                return setResult("0", "BAOCUNSHIBAI", "保存失败");
            }
        }
    }

    /**
     * 满意度数据
     *
     * @param manyidu19s bean
     * @param request    http
     * @return ReponseVo
     */
    @PostMapping("/manyidushuju")
    public ReponseVo manyidushuju(HttpServletRequest request, @Valid @RequestBody Manyidu19s manyidu19s, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            manyidu19s.setYonghuwaijian(biaoji);
            manyidu19s.setWaijian(GetTime.getGuid());
            manyidu19s.setRiqi(DateUtils.getDay());
            manyidu19s.setShixiao("0");
            int i = manyidu19sMapper.insertSelective(manyidu19s);
            if (toDaoResult(i)) {
                return setResult("1", "BAOCUNCHENGGONG", "保存成功");
            } else {
                return setResult("0", "BAOCUNSHIBAI", "保存失败");
            }
        }
    }

    /**
     * 获取管家
     *
     * @param richang6s bean
     * @param request   http
     * @return ReponseVo
     */
    @PostMapping("/huoquguanjia")
    public ReponseVo huoquguanjia(HttpServletRequest request, @Valid @RequestBody Richang6s richang6s, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            Zidongdenglu guanjia = yonghu2sMapper.HuoquGuanjia(biaoji);
            List<Zidongdenglu> list = new ArrayList<>();
            list.add(guanjia);
            if (guanjia != null && "0".equals(guanjia.getGuanjiagonghao()) && !StringUtils.isEmpty(guanjia.getGuanjiagonghao())) {
                return setResult("1", list);
            } else {
                return setResult("0", "WEIBANGDING_GUANJIA", "您未绑定管家，请联系客服！");
            }
        }
    }

    /**
     * 回显日常
     *
     * @param shujuRiqi bean
     * @param request   http
     * @return ReponseVo
     */
    @PostMapping("/huixianrichang")
    public ReponseVo huixianrichang(HttpServletRequest request, @Valid @RequestBody ShujuRiqi shujuRiqi, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "CANSHU_WEIKONG", errorMsg);
        } else {
            List<Richang6s> richang6s = richang6sMapper.ChaxunYigeRichang6s(biaoji, shujuRiqi.getShujuRiqi());
            if (richang6s != null && richang6s.size() > 0) {
                return setResult("1", richang6s);
            } else {
                return setResult("0", "JINRI_WEITIANXIE", "今日未填写");
            }
        }
    }

    /**
     * 回显体检
     *
     * @param shujuRiqi bean
     * @param request   http
     * @return ReponseVo
     */
    @PostMapping("/huixiantijian")
    public ReponseVo huixiantijian(HttpServletRequest request, @Valid @RequestBody ShujuRiqi shujuRiqi, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            Tijian5s tijian5s = tijian5sMapper.selectByshujuriAndWaijian(shujuRiqi.getShujuRiqi(), biaoji);
            if (tijian5s != null) {
                return setResult("1", tijian5s);
            } else {
                return setResult("0", "JINRI_WEITIANXIE", "今日未填写");
            }
        }
    }

    /**
     * 获取所有日常
     *
     * @param request http
     * @return ReponseVo
     */
    @PostMapping("/huoqusuoyourichang")
    public ReponseVo huoqusuoyourichang(HttpServletRequest request) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        List<Richang6s> richang6s = richang6sMapper.ChaxunAppSuoyouRichangRiqi(biaoji);
        if (richang6s != null) {
            return setResult("1", richang6s);
        } else {
            return setResult("0", "RICHANG_WEITIANXIE", "您没有填写过日常数据！");
        }
    }

    /**
     * 获取客户药物
     *
     * @param richang6s bean
     * @param request   http
     * @return ReponseVo
     */
    @PostMapping("/huoqukehuyaowu")
    public ReponseVo huoqukehuyaowu(HttpServletRequest request, @Valid @RequestBody Richang6s richang6s, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String shoujihao = (String) request.getAttribute("Shoujihao");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            List<Kehuyaowu18s> kehuyaowu18s = keHuYaoWu18sMapper.ChaxunAppKehuyaowu(biaoji);
            if (kehuyaowu18s != null && kehuyaowu18s.size() > 0) {
                return setResult("1", kehuyaowu18s);
            } else {
                return setResult("0", "YAOWU_WEITIANXIE", "您没有填写过药物数据！");
            }
        }
    }

    /**
     * 获取药物趋势
     *
     * @param richang6s bean
     * @param request   http
     * @return ReponseVo
     */
    @PostMapping("/huoquyaowuqushi")
    public ReponseVo huoquyaowuqushi(HttpServletRequest request, @Valid @RequestBody Richang6s richang6s, BindingResult bindingResult) {
        String biaoji = (String) request.getAttribute("Biaoji");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMsg = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_SHOUJIHAO", errorMsg);
        } else {
            List<Kehuyaowu18s> kehuyaowu18s = keHuYaoWu18sMapper.ChaxunAppKehuyaowu(biaoji);
            List<Yaowuqushishuju> list = new LinkedList<>();
            if (kehuyaowu18s != null && kehuyaowu18s.size() > 0) {
                for (Kehuyaowu18s kehuyaowu18 : kehuyaowu18s) {
                    if ("YIDAO".equals(kehuyaowu18.getLeixing())) {
                        if ("ZAO".equals(kehuyaowu18.getQujian())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("ZAOYIDAOSU");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                        if ("ZHONG".equals(kehuyaowu18.getQujian())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("ZHONGYIDAOSU");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                        if ("WAN".equals(kehuyaowu18.getQujian())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("WANYIDAOSU");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                        if ("SHUIQIAN".equals(kehuyaowu18.getQujian())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("SHUIQIANYIDAOSU");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                    }
                    if ("ZAO".equals(kehuyaowu18.getQujian())) {
                        if ("KOUFU1".equals(kehuyaowu18.getLeixing())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("ZAOKOUFUYAO1");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                        if ("KOUFU2".equals(kehuyaowu18.getLeixing())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("ZAOKOUFUYAO2");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                        if ("KOUFU3".equals(kehuyaowu18.getLeixing())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("ZAOKOUFUYAO2");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                    }
                    if ("ZHONG".equals(kehuyaowu18.getQujian())) {
                        if ("KOUFU1".equals(kehuyaowu18.getLeixing())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("ZHONGKOUFUYAO1");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                        if ("KOUFU2".equals(kehuyaowu18.getLeixing())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("ZHONGKOUFUYAO2");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                        if ("KOUFU3".equals(kehuyaowu18.getLeixing())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("ZHONGKOUFUYAO3");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                    }
                    if ("WAN".equals(kehuyaowu18.getQujian())) {
                        if ("KOUFU1".equals(kehuyaowu18.getLeixing())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("WANKOUFUYAO1");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                        if ("KOUFU2".equals(kehuyaowu18.getLeixing())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("WANKOUFUYAO2");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                        if ("KOUFU3".equals(kehuyaowu18.getLeixing())) {
                            Yaowuqushishuju yaowuqushishuju = new Yaowuqushishuju();
                            yaowuqushishuju.setLeixing("WANKOUFUYAO3");
                            yaowuqushishuju.setShujushijian(kehuyaowu18.getShujuriqi());
                            yaowuqushishuju.setShujuzhi(kehuyaowu18.getJiliang());
                            list.add(yaowuqushishuju);
                        }
                    }
                }
                return setResult("1", list);
            } else {
                return setResult("0", "YAOWU_WEITIANXIE","您没有填写过药物数据！");
            }
        }
    }


    private void getTijian5s(Tijian5s tijian5s, List<Kehuyaowu18s> keHuYaoWu18s) {
        for (Kehuyaowu18s keHuYaoWu18 : keHuYaoWu18s) {
            if ("ZAO".equals(keHuYaoWu18.getQujian())) {
                switch (keHuYaoWu18.getLeixing()) {
                    case "YIDAO":
                        tijian5s.setZaoYidao(keHuYaoWu18.getMingcheng());
                        tijian5s.setZaoYidaoLiang(keHuYaoWu18.getJiliang());
                    case "KOUFU1":
                        tijian5s.setZaoKoufu1(keHuYaoWu18.getMingcheng());
                        tijian5s.setZaoKoufu1Liang(keHuYaoWu18.getJiliang());
                    case "KOUFU2":
                        tijian5s.setZaoKoufu2(keHuYaoWu18.getMingcheng());
                        tijian5s.setZaoKoufu2Liang(keHuYaoWu18.getJiliang());
                    case "KOUFU3":
                        tijian5s.setZaoKoufu3(keHuYaoWu18.getMingcheng());
                        tijian5s.setZaoKoufu3Liang(keHuYaoWu18.getJiliang());
                }
            }
            if ("ZHONG".equals(keHuYaoWu18.getQujian())) {
                switch (keHuYaoWu18.getLeixing()) {
                    case "YIDAO":
                        tijian5s.setZhongYidao(keHuYaoWu18.getMingcheng());
                        tijian5s.setZhongYidaoLiang(keHuYaoWu18.getJiliang());
                    case "KOUFU1":
                        tijian5s.setZhongKoufu1(keHuYaoWu18.getMingcheng());
                        tijian5s.setZhongKoufu1Liang(keHuYaoWu18.getJiliang());
                    case "KOUFU2":
                        tijian5s.setZhongKoufu2(keHuYaoWu18.getMingcheng());
                        tijian5s.setZhongKoufu2Liang(keHuYaoWu18.getJiliang());
                    case "KOUFU3":
                        tijian5s.setZhongKoufu3(keHuYaoWu18.getMingcheng());
                        tijian5s.setZhongKoufu3Liang(keHuYaoWu18.getJiliang());
                }
            }
            if ("WAN".equals(keHuYaoWu18.getQujian())) {
                switch (keHuYaoWu18.getLeixing()) {
                    case "YIDAO":
                        tijian5s.setWanYidao(keHuYaoWu18.getMingcheng());
                        tijian5s.setWanYidaoLiang(keHuYaoWu18.getJiliang());
                    case "KOUFU1":
                        tijian5s.setWanKoufu1(keHuYaoWu18.getMingcheng());
                        tijian5s.setWanKoufu1Liang(keHuYaoWu18.getJiliang());
                    case "KOUFU2":
                        tijian5s.setWanKoufu2(keHuYaoWu18.getMingcheng());
                        tijian5s.setWanKoufu2Liang(keHuYaoWu18.getJiliang());
                    case "KOUFU3":
                        tijian5s.setWanKoufu3(keHuYaoWu18.getMingcheng());
                        tijian5s.setWanKoufu3Liang(keHuYaoWu18.getJiliang());
                }
            }
            if ("SHUIQIAN".equals(keHuYaoWu18.getQujian())) {
                switch (keHuYaoWu18.getLeixing()) {
                    case "YIDAO":
                        tijian5s.setShuiqianYidao(keHuYaoWu18.getMingcheng());
                        tijian5s.setShuiqianYidaoLiang(keHuYaoWu18.getJiliang());
                }
            }
        }
    }

}
