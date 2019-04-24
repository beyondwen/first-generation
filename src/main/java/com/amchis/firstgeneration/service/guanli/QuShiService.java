package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15s;
import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.QuShi;
import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.ShangChuanShiJians;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.bangdingkongzhiqi15s.BangDingKongZhiQi15sMapper;
import com.amchis.firstgeneration.mapper.guanli.shangchuanshijians.ShangChuanShiJiansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

@Service
public class QuShiService extends BaseApiService<QuShi> {

    @Autowired
    private ShangChuanShiJiansMapper shangChuanShiJiansMapper;

    @Autowired
    private BangDingKongZhiQi15sMapper bangDingKongZhiQi15sMapper;

    public ReponseVo selectByXuliehao(String shoujihao) {
        if (StringUtils.isEmpty(shoujihao)) {
            return setResult("0", "QINGLURU_SHOUJIHAO", "请录入手机号");
        } else {
            BangDingKongZhiQi15s bangDingKongZhiQi15s = bangDingKongZhiQi15sMapper.selectByPhone(shoujihao);
            if (bangDingKongZhiQi15s != null) {
                String wifiming = bangDingKongZhiQi15s.getWifiming();
                List<ShangChuanShiJians> shangChuanShiJians = shangChuanShiJiansMapper.selectByXuliehao(wifiming);
                List<QuShi> list = new LinkedList<>();
                for (ShangChuanShiJians shangChuanShiJian : shangChuanShiJians) {
                    QuShi quShi = new QuShi();
                    String wenjianming = shangChuanShiJian.getWenjianming();
                    String shijian = wenjianming.split("shijian")[2];
                    String[] sjs = shijian.split("_");
                    if (sjs[0].length() == 1) {
                        sjs[0] = "0" + sjs[0];
                    }
                    if (sjs[1].length() == 1) {
                        sjs[1] = "0" + sjs[1];
                    }
                    String startTime = sjs[0];
                    String endTime = sjs[1];
                    String totalTime = startTime + "-" + endTime;
                    Long jieshushijian = shangChuanShiJian.getJieshushijian();
                    Long kaishishijian = shangChuanShiJian.getKaishishijian();
                    long time = jieshushijian - kaishishijian;
                    long riqi = time / 3600;
                    quShi.setRiqi(String.valueOf(riqi));
                    quShi.setShijian(totalTime);
                    list.add(quShi);
                }
                return setResult("1", list);
            } else {
                return setResult("0", "WEIBANGDINGKONGZHIQI", "控制器未绑定");
            }
        }
    }
}
