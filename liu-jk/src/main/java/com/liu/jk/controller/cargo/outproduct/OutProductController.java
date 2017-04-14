package com.liu.jk.controller.cargo.outproduct;

import com.liu.jk.controller.BaseController;
import com.liu.jk.service.OutProductService;
import com.liu.jk.vo.OutProductVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by titanic on 17-4-13.
 */
@Controller
public class OutProductController extends BaseController{

    @Resource
    OutProductService outProductService;

    //转向页面
    @RequestMapping("/cargo/outproduct/toedit.action")
    public String toedit(){
        return "cargo/outproduct/jOutProduct.jsp";
    }

    @RequestMapping("/cargo/outproduct/print.action")
    public void print(String inputDate){  //inputDate 格式: yyyy-MM

        List<OutProductVO> dataList = outProductService.find(inputDate);

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row nRow = sheet.createRow(1);
    }
}
