package com.hcy.mapper;

import com.hcy.pojo.Seller;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 16691
* @description 针对表【t_seller】的数据库操作Mapper
* @createDate 2022-05-30 20:02:32
* @Entity com.hcy.pojo.Seller
*/
@Mapper
public interface SellerMapper extends BaseMapper<Seller> {
    Seller selectBySellerName(@Param("seller_name") String sellerName);
    
    int insertSelective(Seller seller);
}




