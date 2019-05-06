package com.amchis.firstgeneration.controller.guanli;

import com.alibaba.druid.util.StringUtils;
import com.amchis.firstgeneration.bean.guanli.Register.RegisterBean;
import com.amchis.firstgeneration.bean.guanli.jiyinjiance20s.JiYinJianCe20s;
import com.amchis.firstgeneration.bean.guanli.loginbean.LoginBean;
import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.ShebeiShijianMoxing;
import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.ShebeiShijianMoxingCanshu;
import com.amchis.firstgeneration.bean.guanli.user.User;
import com.amchis.firstgeneration.bean.huoban.yonghu2s.Yonghu2s;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ErrorVo;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.mapper.huoban.yonghu2s.Yonghu2sMapper;
import com.amchis.firstgeneration.service.guanli.*;
import com.amchis.firstgeneration.utils.DateUtils;
import com.amchis.firstgeneration.utils.GetTime;
import com.amchis.firstgeneration.utils.UUIDUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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

    @Autowired
    private Yonghu2sMapper yonghu2sMapper;

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
     * 查询基因检测
     *
     * @return
     */
    @PostMapping("/daorujiyinjiance")
    public ReponseVo exportGeneticTestingFile(HttpServletRequest request) {
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

    @PostMapping("/readexcel")
    public ReponseVo readExcel(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
        //String biaoji = (String) request.getAttribute("Biaoji");
        //String zhanghao = (String) request.getAttribute("Shoujihao");
        InputStream inputStream = file.getInputStream();
        String name = file.getOriginalFilename();
        Workbook workbook = null;
        ErrorVo errorVo = new ErrorVo();
        errorVo.setBianma("LURU_SHIBAI");
        errorVo.setMiaoshu("录入失败");
        ReponseVo reponseVo = new ReponseVo("0", errorVo);
        String postfix = name.substring(name.lastIndexOf("."), name.length());
        try {
            if (".xls".equals(postfix)) {
                // 针对 2003 Excel 文件
                workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
            } else {
                // 针对2007 Excel 文件
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int s = 0; s < 1; s++) {
            Sheet sheet = workbook.getSheetAt(s);
            int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
            List<JiYinJianCe20s> list = new LinkedList<>();
            for (int r = 0; r < rowCount; r++) {
                Row row = sheet.getRow(r + 1);
                if (row != null) {
                    int cellCount = row.getPhysicalNumberOfCells(); // 获取总列数
                    if (cellCount == 8) {
                        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        String yonghuming = row.getCell(0).getStringCellValue();//获取用户名
                        row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        String shoujihao = row.getCell(1).getStringCellValue();//获取手机号
                        row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        String cdka1 = row.getCell(2).getStringCellValue();//获取cdka1
                        row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                        String cdka2 = row.getCell(3).getStringCellValue();//获取cdka2
                        row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                        String cdkn2a = row.getCell(4).getStringCellValue();//获取cdkn2a
                        row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                        String hhex = row.getCell(5).getStringCellValue();//获取hhex
                        row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                        String slc30a8 = row.getCell(6).getStringCellValue();//获取slc30a8
                        row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                        String kcnq1 = row.getCell(7).getStringCellValue();//获取kcnq1
                        JiYinJianCe20s jiYinJianCe20s = new JiYinJianCe20s();
                        Yonghu2s yonghu2s = yonghu2sMapper.chaxunyonghuByshouji(shoujihao);
                        if (yonghu2s != null) {
                            jiYinJianCe20s.setWaijian(GetTime.getGuid());
                            jiYinJianCe20s.setRiqi(DateUtils.getDay());
                            jiYinJianCe20s.setYonghuwaijian(yonghu2s.getWaijian());
                            jiYinJianCe20s.setCdkal11(cdka1);
                            jiYinJianCe20s.setCdkal12(cdka2);
                            jiYinJianCe20s.setCdkn2aB(cdkn2a);
                            jiYinJianCe20s.setHhex(hhex);
                            jiYinJianCe20s.setSlc30a8(slc30a8);
                            jiYinJianCe20s.setKcnq1(kcnq1);
                            jiYinJianCe20s.setLuruduan("DAORU");
                            jiYinJianCe20s.setYonghumingcheng(yonghuming);
                        } else {
                            jiYinJianCe20s.setWaijian(GetTime.getGuid());
                            jiYinJianCe20s.setRiqi(DateUtils.getDay());
                            jiYinJianCe20s.setYonghuwaijian(shoujihao);
                            jiYinJianCe20s.setCdkal11(cdka1);
                            jiYinJianCe20s.setCdkal12(cdka2);
                            jiYinJianCe20s.setCdkn2aB(cdkn2a);
                            jiYinJianCe20s.setHhex(hhex);
                            jiYinJianCe20s.setSlc30a8(slc30a8);
                            jiYinJianCe20s.setKcnq1(kcnq1);
                            jiYinJianCe20s.setLuruduan("DAORU");
                            jiYinJianCe20s.setYonghumingcheng(yonghuming);
                        }
                        int i = jiYinJianCe20sService.insertSelective(jiYinJianCe20s);
                        if (!toDaoResult(i)) {
                            errorVo.setBianma("LURU_SHIBAI");
                            errorVo.setMiaoshu("录入失败");
                            reponseVo = new ReponseVo("0", errorVo);
                        } else {
                            list.add(jiYinJianCe20s);
                            reponseVo = new ReponseVo("1", list);
                        }
                    } else {
                        errorVo.setBianma("BAOCUN_CUOWU");
                        errorVo.setMiaoshu("文件列数为8列，请检查");
                        reponseVo = new ReponseVo("0", errorVo);
                    }
                }
            }
        }
        return reponseVo;
    }

}
