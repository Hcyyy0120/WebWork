package com.hcy.mapper;

import com.hcy.pojo.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcy.pojo.vo.CartVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 16691
* @description 针对表【t_cart】的数据库操作Mapper
* @createDate 2022-06-04 11:52:28
* @Entity com.hcy.pojo.Cart
*/
@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    /**
     * 向购物车插入数据
     */
    void insertIntoCart(Cart cart);
    
    /**
     * 如果当前商品已经在购物车中存在，则直接更新num的数量即可。
     * 更新购物车某件商品的数量
     * @param cid
     * @param cartItemNum
     * @return
     */
    void updateCartItemNumByCid(Integer cid, Integer cartItemNum);
    
    /**
     * 插入还是更新，取决于数据库中是否有当前的这个购物车商品的数据，得去查询才能确定
     * 根据用户的id和商品的id来查询购物车的数据
     */
    Cart selectByUidAndPid(Integer uid, Integer pid);
    
    /**
     * 通过用户uid查询购物车信息
     */
    List<CartVo> selectCartVoByUid(Integer uid);
    
    /**
     * 根据cid的值来查询当前的购物车这条数据是否存在
     * @param cid
     * @return
     */
    Cart selectByCid(Integer cid);
    
    /**
     * 根据cid删除购物车中商品数据
     * @param cid
     */
    void deleteByCid(Integer cid);

}




