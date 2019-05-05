package com.amchis.firstgeneration.controller.guanli;

import com.alibaba.druid.util.StringUtils;
import com.amchis.firstgeneration.bean.guanli.Register.RegisterBean;
import com.amchis.firstgeneration.bean.guanli.loginbean.LoginBean;
import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.ShebeiShijianMoxing;
import com.amchis.firstgeneration.bean.guanli.shangchuanshijians.ShebeiShijianMoxingCanshu;
import com.amchis.firstgeneration.bean.guanli.user.User;
import com.amchis.firstgeneration.common.BaseApiService;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.service.guanli.*;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping("/readexcel")
    public ReponseVo readExcel(@RequestParam("file") CommonsMultipartFile file, String fileName) throws Exception {
        InputStream inputStream = file.getInputStream();
        String name = file.getOriginalFilename();
        Workbook workbook = null;
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
            // 遍历每一行
            String[] id = new String[1];
            String templateType = null;//模板类型（1 商务部分，2 报价部分 ，3 技术部分）
            for (int r = 0; r < rowCount; r++) {
                Row row = sheet.getRow(r);
                if (row != null) {
                    int cellCount = row.getPhysicalNumberOfCells(); // 获取总列数
                    if (cellCount == 8) {
                        Cell cell0 = row.getCell(0);//获取审查内容
                        String v = cell0.getStringCellValue();
                        Cell cell1 = row.getCell(1);//获取审查标准
                        Cell cell2 = row.getCell(2);//获取审核
                        Cell cell3 = row.getCell(3);//获取通知整改记录
                        if (!StringUtils.isEmpty(cell3.getStringCellValue())) {
                        }
                        Cell cell4 = row.getCell(4);//获取备注
                        if (!StringUtils.isEmpty(cell4.getStringCellValue())) {
                        }
                        //result = true;
                    } else {
                        //result = false;
                    }
                }
            }
        }

        return null;
    }


    @ResponseBody
    @RequestMapping("/readexcelttttt")
    public ReponseVo readExcelTTTTTT(@RequestParam("file") MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        String name = file.getOriginalFilename();
        Workbook workbook = null;
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
            // 遍历每一行
            for (int r = 0; r < rowCount; r++) {
                Row row = sheet.getRow(r);
                if (row != null) {
                    int cellCount = row.getPhysicalNumberOfCells(); // 获取总列数
                    if (cellCount == 6) {
                        Cell cell0 = row.getCell(0);//获取审查内容
                        String v = cell0.getStringCellValue();
                        Cell cell1 = row.getCell(1);//获取审查标准
                        Cell cell2 = row.getCell(2);//获取审核
                        Cell cell3 = row.getCell(3);//获取通知整改记录
                        if (!StringUtils.isEmpty(cell3.getStringCellValue())) {
                        }
                        Cell cell4 = row.getCell(4);//获取备注
                        if (!StringUtils.isEmpty(cell4.getStringCellValue())) {
                        }
                        //result = true;
                    } else {
                        //result = false;
                    }
                }
            }
        }

        return null;
    }

}
