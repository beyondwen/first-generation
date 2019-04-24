package com.amchis.firstgeneration.service.guanli;

import com.amchis.firstgeneration.bean.guanli.ziyuan4s.Ziyuan4s;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.guanli.ziyuan4s.Ziyuan4sMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZiyuanService extends BaseApiService<Ziyuan4s> {

    @Autowired
    private Ziyuan4sMapper ziyuan4sMapper;

    public int deleteByPrimaryKey(Integer id) {
        return ziyuan4sMapper.deleteByPrimaryKey(id);
    }

    public int insert(Ziyuan4s record) {
        return ziyuan4sMapper.insert(record);
    }

    public int insertSelective(Ziyuan4s record) {
        return ziyuan4sMapper.insertSelective(record);
    }

    public Ziyuan4s selectByPrimaryKey(Integer id) {
        return ziyuan4sMapper.selectByPrimaryKey(id);
    }

    public ReponseVo selectZyByYonghuwaijian(String yonghuwaijian, String jueseBianma) {
        List<Ziyuan4s> ziyuan4s = ziyuan4sMapper.selectZyByYonghuwaijian(yonghuwaijian);
        if ("JIYIN_JIANCE".equals(jueseBianma)) {
            Ziyuan4s list = new Ziyuan4s();
            list.setLeixing("ANNIU");
            list.setMingcheng("导入基因检测");
            list.setBianma("DAORU_JIYIN_JIANCE");
            ziyuan4s.add(list);
        }
        if ("MEIHUA_ZHUGUAN".equals(jueseBianma)) {
            Ziyuan4s list = new Ziyuan4s();
            list.setLeixing("ANNIU");
            list.setMingcheng("帮助客户录入");
            list.setBianma("BANGZHU_KEHU_LURU");
            ziyuan4s.add(list);
        }
        return setResult("0", ziyuan4s);

    }

    public int updateByPrimaryKeySelective(Ziyuan4s record) {
        return ziyuan4sMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Ziyuan4s record) {
        return ziyuan4sMapper.updateByPrimaryKey(record);
    }
}
