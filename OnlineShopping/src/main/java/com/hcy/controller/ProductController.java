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
    
    @GetMapping("/all")
    public List<ProductVo> selectAll(ProductVo productVo) {
        return productService.getAllProductVo(productVo);
    }
    
    @PostMapping ("/condition")
    public List<ProductVo> selectByCondition(@RequestBody ProductVo productVo) {
        System.out.println(productVo);
        return productService.selectAllByCondition(productVo.getTitle(), productVo.getTypeName(), productVo.getBeginPrice(), productVo.getEndPrice(), productVo.getSellerName());
    }
    
    @PostMapping("/seller")
    public List<ProductVo> selectAllProductVoBySeller(@RequestBody ProductVo productVo) {
        return productService.selectAllProductVoBySeller(productVo.getSellerName());
    }
    
    @PostMapping("/delete")
    public void deleteProductById(@RequestBody ProductVo productVo) {
        productService.deleteProductById(productVo);
    }
    
    @PostMapping("/insert")
    public void insertProduct(@RequestBody ProductVo productVo) {
        productService.insertProduct(productVo);
    }
}
