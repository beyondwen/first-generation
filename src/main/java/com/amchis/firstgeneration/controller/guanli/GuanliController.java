package com.amchis.firstgeneration.controller.guanli;

import com.amchis.firstgeneration.bean.guanli.Register.RegisterBean;
import com.amchis.firstgeneration.bean.guanli.loginbean.LoginBean;
import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.ShebeiShijianMoxing;
import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.ShebeiShijianMoxingCanshu;
import com.amchis.firstgeneration.bean.guanli.user.User;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.service.guanli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/guanli")
public class GuanliController extends BaseApiService {

    @Autowired
    private UserService userService;

    @Autowired
    private ZiyuanService ziyuanService;

    @Autowired
    private RiChang6sService riChang6sService;

    @Autowired
    private KeHuYaoWu18sService keHuYaoWu18sService;

    @Autowired
    private JiYinJianCe20sService jiYinJianCe20sService;

    @Autowired
    private AppBanBen21sService appBanBen21sService;

    @Autowired
    private QuShiService quShiService;

    /**
     * 登录接口
     *
     * @param loginBean
     * @return
     */
    @PostMapping("/denglu")
    public ReponseVo login(@RequestBody LoginBean loginBean) {
        return userService.findByName(loginBean);
    }

    /**
     * 获取菜单
     *
     * @param request
     * @return
     */
    @PostMapping("/caidan")
    public ReponseVo menu(HttpServletRequest request) {
        String biaoji = (String) request.getAttribute("Biaoji");
        String jueseBianma = (String) request.getAttribute("JueseBianma");
        return ziyuanService.selectZyByYonghuwaijian(biaoji, jueseBianma);
    }

    /**
     * 添加帐号
     *
     * @param registerBean
     * @return
     */
    @PostMapping("/tianjiazhanghao")
    public ReponseVo addAccount(@RequestBody @Valid RegisterBean registerBean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMessage = fieldError.getDefaultMessage();
            return setResult("0", "QINGLURU_XIANGGUANXINGXI", errorMessage);
        } else {
            return userService.findByName4Register(registerBean);
        }
    }

    /**
     * 获取日常数据
     *
     * @param user
     * @return
     */
    @PostMapping("/guanjiahuoqusuoyourichang")
    public ReponseVo getAllManagerDaily(HttpServletRequest request, @RequestBody User user) {
        String biaoji = (String) request.getAttribute("Biaoji");
        return riChang6sService.ChaxunAppSuoyouRichangRiqi(user.getShoujihao(), biaoji);
    }

    /**
     * 获取药物趋势
     *
     * @param user
     * @return
     */
    @PostMapping("/guanjiahuoquyaowuqushi")
    public ReponseVo getAllManagerMedicine(HttpServletRequest request, @RequestBody User user) {
        String biaoji = (String) request.getAttribute("Biaoji");
        return keHuYaoWu18sService.selectByYonghuwaijian(user.getShoujihao(), biaoji);
    }

    /**
     * 查询基因检测
     *
     * @return
     */
    @PostMapping("/chakanjiyinjiance")
    public ReponseVo getGeneticTesting(HttpServletRequest request) {
        String jueseBianma = (String) request.getAttribute("JueseBianma");
        return jiYinJianCe20sService.selectJiYinJianCe(jueseBianma);
    }

    /**
     * 获取app版本
     *
     * @return
     */
    @PostMapping("/appzuixinbanben")
    public ReponseVo getAppVersion() {
        return appBanBen21sService.getAppUpdate();
    }

    /**
     * 设备使用时间
     *
     * @return
     */
    @PostMapping("/shebeishiyongshijian")
    public ReponseVo getDeviceTime(@RequestBody ShebeiShijianMoxingCanshu ShebeiShijianMoxingCanshu) {
        return quShiService.selectByXuliehao(ShebeiShijianMoxingCanshu.getShebeiShijianMoxing().getShoujihao());
    }

}
