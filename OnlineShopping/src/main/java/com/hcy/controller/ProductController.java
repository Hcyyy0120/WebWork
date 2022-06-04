package com.hcy.controller;

import com.hcy.pojo.Product;
import com.hcy.pojo.vo.ProductVo;
import com.hcy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    /**
     * 查询所有商品
     * @param productVo
     * @return
     */
    @GetMapping("/all")
    public List<ProductVo> selectAll(ProductVo productVo) {
        return productService.getAllProductVo(productVo);
    }
    
    /**
     * 多条件查询商品
     * @param productVo
     * @return
     */
    @PostMapping ("/condition")
    public List<ProductVo> selectByCondition(@RequestBody ProductVo productVo) {
        System.out.println(productVo);
        return productService.selectAllByCondition(productVo.getTitle(), productVo.getTypeName(), productVo.getBeginPrice(), productVo.getEndPrice(), productVo.getSellerName());
    }
    
    /**
     * 商家查询自身所拥有商品
     * @param productVo
     * @return
     */
    @PostMapping("/seller")
    public List<ProductVo> selectAllProductVoBySeller(@RequestBody ProductVo productVo) {
        return productService.selectAllProductVoBySeller(productVo.getSellerName());
    }
    
    /**
     * 商家删除商品
     * @param productVo
     */
    @PostMapping("/delete")
    public void deleteProductById(@RequestBody ProductVo productVo) {
        productService.deleteProductById(productVo);
    }
    
    /**
     * 商家新增商品
     * @param productVo
     */
    @PostMapping("/insert")
    public void insertProduct(@RequestBody ProductVo productVo) {
        productService.insertProduct(productVo);
    }
    
    /**
     * 商家修改商品
     * @param productVo
     */
    @PostMapping("/update")
    public void updateProductById(@RequestBody ProductVo productVo) {
        productService.updateProductById(productVo);
    }
}
