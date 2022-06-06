package com.hcy.mapper;

import com.hcy.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcy.pojo.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 16691
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2022-06-06 09:08:15
* @Entity com.hcy.pojo.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 插入订单数据/创建订单
     * @param order
     * @return
     */
    Integer insertOrder(Order order);
    
    List<OrderVo> selectOrderVoByOid(Integer oid);
    
}




