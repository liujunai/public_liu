package com.liu.jk.controller.cargo.contract;

import com.liu.jk.controller.BaseController;
import com.liu.jk.model.ContractProduct;
import com.liu.jk.model.Factory;
import com.liu.jk.service.ContractProductService;
import com.liu.jk.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liu on 17-4-11.
 */
@Controller
public class ContractProductController extends BaseController {
    @Resource
    ContractProductService contractProductService;
    @Resource
    FactoryService factoryService;

    //转向新增页面
    @RequestMapping("/cargo/contractproduct/tocreate.action")
    public String tocreate(String contractId, Model model){		//传递主表的ID
        model.addAttribute("contractId", contractId);

        //准备生产厂家的下拉列表
        List<Factory> factoryList = factoryService.getFactoryList();
        model.addAttribute("factoryList", factoryList);

        //某个合同下的货物列表
        Map paraMap = new HashMap();
        paraMap.put("contractId", contractId);

        List<ContractProduct> dataList = contractProductService.find(paraMap);
        model.addAttribute("dataList", dataList);

        return "/cargo/contract/jContractProductCreate.jsp";	//货物的新增页面
    }

    //新增
    @RequestMapping("/cargo/contractproduct/insert.action")
    public String insert(ContractProduct contractProduct, Model model){
        contractProductService.insert(contractProduct);

        model.addAttribute("contractId", contractProduct.getContractId());		//传递主表的ID

        return "redirect:/cargo/contractproduct/tocreate.action";	//新增完转向新增页面-批量新增
    }
}