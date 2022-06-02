package com.hcy.service;

import com.hcy.pojo.Seller;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hcy.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
* @author 16691
* @description 针对表【t_seller】的数据库操作Service
* @createDate 2022-05-30 20:02:32
*/
public interface SellerService extends IService<Seller> {
    
    Seller selectBySellerName(String sellerName);
    
    int insertSelective(Seller seller);
    
}
