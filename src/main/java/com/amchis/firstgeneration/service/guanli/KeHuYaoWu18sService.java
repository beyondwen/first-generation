package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.kehuyaowu18s.YaoWU;
import com.amchis.firstgeneration.bean.guanli.user.User;
import com.amchis.firstgeneration.bean.huoban.kehuyaowu18s.Kehuyaowu18s;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.kehuyaowu18s.KeHuYaoWu18sMapper;
import com.amchis.firstgeneration.mapper.guanli.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeHuYaoWu18sService extends BaseApiService {

    @Autowired
    private KeHuYaoWu18sMapper keHuYaoWu18sMapper;

    @Autowired
    private UserMapper userMapper;

    public int deleteByPrimaryKey(Integer id) {
        return keHuYaoWu18sMapper.deleteByPrimaryKey(id);
    }

    public int insert(Kehuyaowu18s record) {
        return keHuYaoWu18sMapper.insert(record);
    }

    public int insertSelective(Kehuyaowu18s record) {
        return keHuYaoWu18sMapper.insertSelective(record);
    }

    public Kehuyaowu18s selectByPrimaryKey(Integer id) {
        return keHuYaoWu18sMapper.selectByPrimaryKey(id);
    }

    public ReponseVo selectByYonghuwaijian(String Shoujihao, String yonghuwaijian) {
        //根据工号查询用户是否存在
        User user = userMapper.findByPhone(Shoujihao);
        if (user == null) {
            return setResult("0", "YONGHU_BUCUNZAI", "用户不存在");
        } else {
            List<Kehuyaowu18s> keHuYaoWu18s = keHuYaoWu18sMapper.selectByYonghuwaijian(yonghuwaijian);
            List<YaoWU> yaoWUS = new ArrayList<>();
            if (keHuYaoWu18s.size() > 0) {
                for (Kehuyaowu18s keHuYaoWu18 : keHuYaoWu18s) {
                    if ("YIDAO".equals(keHuYaoWu18.getLeixing()) && "ZAO".equals(keHuYaoWu18.getQujian())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("ZAOYIDAOSU");
                        yaoWUS.add(yaoWU);
                    }
                    if ("YIDAO".equals(keHuYaoWu18.getLeixing()) && "ZHONG".equals(keHuYaoWu18.getQujian())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("ZHONGYIDAOSU");
                        yaoWUS.add(yaoWU);
                    }
                    if ("YIDAO".equals(keHuYaoWu18.getLeixing()) && "WAN".equals(keHuYaoWu18.getQujian())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("WANYIDAOSU");
                        yaoWUS.add(yaoWU);
                    }
                    if ("YIDAO".equals(keHuYaoWu18.getLeixing()) && "SHUIQIAN".equals(keHuYaoWu18.getQujian())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("SHUIQIANYIDAOSU");
                        yaoWUS.add(yaoWU);
                        continue;
                    }
                    if ("ZAO".equals(keHuYaoWu18.getQujian()) && "KOUFUYAO1".equals(keHuYaoWu18.getLeixing())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("ZAOKOUFUYAO1");
                        yaoWUS.add(yaoWU);
                    }
                    if ("ZAO".equals(keHuYaoWu18.getQujian()) && "KOUFUYAO2".equals(keHuYaoWu18.getLeixing())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("ZAOKOUFUYAO2");
                        yaoWUS.add(yaoWU);
                    }
                    if ("ZAO".equals(keHuYaoWu18.getQujian()) && "KOUFUYAO3".equals(keHuYaoWu18.getLeixing())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("ZAOKOUFUYAO3");
                        yaoWUS.add(yaoWU);
                    }

                    if ("ZHONG".equals(keHuYaoWu18.getQujian()) && "KOUFUYAO1".equals(keHuYaoWu18.getLeixing())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("ZHONGKOUFUYAO1");
                        yaoWUS.add(yaoWU);
                    }
                    if ("ZHONG".equals(keHuYaoWu18.getQujian()) && "KOUFUYAO2".equals(keHuYaoWu18.getLeixing())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("ZHONGKOUFUYAO2");
                        yaoWUS.add(yaoWU);
                    }
                    if ("ZHONG".equals(keHuYaoWu18.getQujian()) && "KOUFUYAO3".equals(keHuYaoWu18.getLeixing())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("ZHONGKOUFUYAO3");
                        yaoWUS.add(yaoWU);
                    }
                    if ("WAN".equals(keHuYaoWu18.getQujian()) && "KOUFUYAO1".equals(keHuYaoWu18.getLeixing())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("WANKOUFUYAO1");
                        yaoWUS.add(yaoWU);
                    }
                    if ("WAN".equals(keHuYaoWu18.getQujian()) && "KOUFUYAO2".equals(keHuYaoWu18.getLeixing())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("WANKOUFUYAO2");
                        yaoWUS.add(yaoWU);
                    }
                    if ("WAN".equals(keHuYaoWu18.getQujian()) && "KOUFUYAO3".equals(keHuYaoWu18.getLeixing())) {
                        YaoWU yaoWU = new YaoWU();
                        yaoWU.setShujushijian(keHuYaoWu18.getShujuriqi());
                        yaoWU.setShujuzhi(keHuYaoWu18.getJiliang());
                        yaoWU.setLeixing("WANKOUFUYAO3");
                        yaoWUS.add(yaoWU);
                    }

                }
                return setResult("1",yaoWUS);
            } else {
                return setResult("0", "YAOWU_WEITIANXIE", "您没有填写过药物数据！");
            }
        }
    }

    public int updateByPrimaryKeySelective(Kehuyaowu18s record) {
        return keHuYaoWu18sMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Kehuyaowu18s record) {
        return keHuYaoWu18sMapper.updateByPrimaryKey(record);
    }
}
