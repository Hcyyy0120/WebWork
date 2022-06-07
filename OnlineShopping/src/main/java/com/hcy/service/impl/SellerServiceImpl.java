package com.hcy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.pojo.Seller;
import com.hcy.pojo.User;
import com.hcy.pojo.vo.RecvOrder;
import com.hcy.service.SellerService;
import com.hcy.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
* @author 16691
* @description 针对表【t_seller】的数据库操作Service实现
* @createDate 2022-05-30 20:02:32
*/
@Service
public class SellerServiceImpl extends ServiceImpl<SellerMapper, Seller> implements SellerService{
    
    @Autowired
    private SellerMapper sellerMapper;
    
    @Override
    public Seller selectBySellerName(String sellerName) {
        return sellerMapper.selectBySellerName(sellerName);
    }
    
    @Override
    public int insertSelective(Seller seller) {
        return sellerMapper.insertSelective(seller);
    }
    
    @Override
    public List<RecvOrder> selectRevOrder(String sellerName) {
        return sellerMapper.selectRevOrder(sellerName);
    }
    
    @Override
    public void updateOrderState(Integer oid, Integer uid) {
        sellerMapper.updateOrderState(oid,uid);
    }
    
    @Override
    public void updateOrderItemState(Integer oid) {
        sellerMapper.updateOrderItemState(oid);
    }
}




