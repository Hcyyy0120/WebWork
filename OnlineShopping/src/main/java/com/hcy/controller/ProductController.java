package com.hcy.controller;

import com.hcy.pojo.Product;
import com.hcy.pojo.dto.ProductDto;
import com.hcy.pojo.vo.ProductVo;
import com.hcy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    
    @PostMapping("/updateNumAndState")//实际应该修改的是t_order_item中的state(已修改)
    public void updateProductNumAndState(@RequestBody ProductDto productDto) {
        Integer[] id = productDto.getId();
        Integer[] num = productDto.getNum();
/*        System.out.println("=============" + Arrays.toString(id));
        System.out.println("=============" + Arrays.toString(num));*/
        productService.updateProductNumAndStateById(id,num);
    }
}
