package com.amchis.firstgeneration.common;


import com.amchis.firstgeneration.bean.BaseBean;
import com.amchis.firstgeneration.mapper.BaseMapper;
import com.amchis.firstgeneration.utils.DateUtils;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class BaseApiService<T extends BaseBean> {

    //通用封装
    public ReponseVo setResult(String Zhuangtai, String bianma, String miaoshu) {
        ErrorVo errorVo = new ErrorVo();
        errorVo.setBianma(bianma);
        errorVo.setMiaoshu(miaoshu);
        return new ReponseVo(Zhuangtai, errorVo);
    }

    //通用封装
    public ReponseVo setResult(String Zhuangtai, String[] token) {
        return new ReponseVo(Zhuangtai, token);
    }

    //通用封装
    public ReponseVo setResult(String Zhuangtai, List<T> t) {
        return new ReponseVo(Zhuangtai, t);

    }

    protected Boolean toDaoResult(int result) {
        return result > 0 ? true : false;
    }


    protected ReponseVo commomMethod(T t, BaseMapper<T> baseMapper) {
        if (t != null && t.getId() == null) {
            t.setRiqi(DateUtils.getDay());
            int i = baseMapper.insertSelective(t);
            return getReponseVo(baseMapper, i);
        } else if (t != null && t.getId() != null) {
            t.setRiqi(DateUtils.getDay());
            int i = baseMapper.updateByPrimaryKeySelective(t);
            return getReponseVo(baseMapper, i);
        }
        return setResult("0", "XITONG_YICHANG", "系统异常，请联系管理员");

    }

    private ReponseVo getReponseVo(BaseMapper<T> baseMapper, int i) {
        if (toDaoResult(i)) {
            List<T> all = baseMapper.getAll();
            if (all != null && all.size() > 0) {
                return setResult("1", all);
            } else {
                return setResult("0", "SHUJULIANG_WEILING", "数据量为零");
            }
        } else {
            return setResult("0", "XITONG_YICHANG", "系统异常，请联系管理员");
        }
    }
}
