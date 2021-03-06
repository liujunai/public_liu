package com.liu.jk.vo;

import com.liu.jk.model.ContractProduct;
import com.liu.jk.model.Factory;

/**
 * Created by liu on 17-4-12.
 */
public class ExtCproductVO {

    private String id;

    private ContractProduct contractProduct;   //和货物陪多对一关系
    private Factory factory;                   //和厂家陪多对一关系

    private String ctype;
    private String productNo;
    private String productImage;
    private String productDesc;
    private Integer cnumber;
    private String packingUnit;			//包装单位
    private Double price;
    private Double amount;
    private String productRequest;
    private Integer orderNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContractProduct getContractProduct() {
        return contractProduct;
    }

    public void setContractProduct(ContractProduct contractProduct) {
        this.contractProduct = contractProduct;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(String productRequest) {
        this.productRequest = productRequest;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
