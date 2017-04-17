package com.liu.jk.controller.cargo.export;

import com.liu.jk.controller.BaseController;
import com.liu.jk.model.Contract;
import com.liu.jk.model.Export;
import com.liu.jk.service.ExportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by titanic on 17-4-14.
 */
@Controller
public class ExportController extends BaseController {

    @Resource
    ExportService exportService;

    @RequestMapping("/cargo/export/list.action")
    public String list(Model model){
        List<Export> dataList = exportService.find(null);
        model.addAttribute("dataList",dataList);

        return "/cargo/export/jExportList.jsp";
    }

    //购销合同查询列表（已上报的）
    @RequestMapping("/cargo/export/contractList.action")
    public String contractList(Model model){
        List<Contract> dataList = exportService.getContractList();
        model.addAttribute("dataList",dataList);

        return "/cargo/export/jContractList.jsp";       //报运下调用购销合同列表
    }

    //报运新增,直接进行后台保存
    public String insert(String[]  contractIds){        //合同的ID集合
        exportService.insert(export);

        return "redirect:/cargo/export/List.action";
    }
}
