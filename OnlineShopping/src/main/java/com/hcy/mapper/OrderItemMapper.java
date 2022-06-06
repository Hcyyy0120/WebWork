package com.hcy.mapper;

import com.hcy.pojo.OrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 16691
* @description 针对表【t_order_item】的数据库操作Mapper
* @createDate 2022-06-06 09:08:20
* @Entity com.hcy.pojo.OrderItem
*/
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    
    void insertOrderItem(OrderItem orderItem);
    
    /**
     * 设置t_order_item的state为2
     * @param oid
     * @param pid
     */
    void updateOrderItemStateByOidAndPid(Integer oid,Integer pid);
}




