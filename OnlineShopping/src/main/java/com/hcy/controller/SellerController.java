package com.hcy.controller;

import com.hcy.pojo.Seller;
import com.hcy.pojo.User;
import com.hcy.pojo.vo.RecvOrder;
import com.hcy.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seller")
public class SellerController {
    
    @Autowired
    private SellerService sellerService;
    
    @GetMapping("/orderState/{oid}/{uid}")
    public void updateOrderState(@PathVariable("oid") Integer oid,@PathVariable("uid") Integer uid) {
        sellerService.updateOrderState(oid, uid);
    }
    
    @GetMapping("/orderItemState/{oid}")
    public void updateOrderItemState(@PathVariable("oid") Integer oid) {
        sellerService.updateOrderItemState(oid);
    }
    
    @GetMapping("/selectRecvOrder")
    public List<RecvOrder> selectRevOrder(HttpSession session) {
        Seller seller = (Seller)session.getAttribute("seller");
        String sellerName = seller.getSellerName();
        return sellerService.selectRevOrder(sellerName);
    }
    
    /**
     * 商家登录
     * @param seller
     * @param session
     * @return
     */
    @PostMapping("/login")
    public Map<String, Object> SellerLogin(@RequestBody Seller seller, HttpSession session) {
        Seller checkSeller = sellerService.selectBySellerName(seller.getSellerName());
        Map<String, Object> map = new HashMap<>();
        //判断从数据库中查询出来的seller是否为空
        if (checkSeller != null && seller.getPassword().equals(checkSeller.getPassword())) {
            map.put("status", true);
            //map.put("message", "登录成功,点击确定跳转到主页");
            map.put("seller", checkSeller);
            session.setAttribute("seller", checkSeller);
        } else {
            //通过商家名查询该商家是否存在数据库
            Seller reSeller = sellerService.selectBySellerName(seller.getSellerName());
            if (reSeller != null) {
                //如果存在
                map.put("status", false);
                map.put("message", "密码错误");
            } else {
                map.put("status", false);
                map.put("message", "商家不存在");
            }
        }
        return map;
    }
    
    /**
     * 商家入驻/注册
     * @param seller
     * @return
     */
    @PostMapping("/reg")
    public Map<String, Object> SellerReg(@RequestBody Seller seller) {
        Seller checkSeller = sellerService.selectBySellerName(seller.getSellerName());//在数据库里查找是否已存在
        System.out.println("111111111" + checkSeller);
        HashMap<String, Object> map = new HashMap<>();
        if (checkSeller != null) {
            map.put("status", false);
            map.put("message", "商家已存在");
            return map;
        }
        int res = sellerService.insertSelective(seller);
        if (res == 0) {
            map.put("status", false);
            map.put("message", "注册失败");
            return map;
        }
        map.put("status", true);
        map.put("message", "注册成功");
        return map;
    }
    
    /**
     * 获取商家信息（商家名）
     * @param session
     * @return
     */
    @GetMapping("/getSellerInfo")
    public Map<String,Object> getSellerInfo(HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        Seller seller = (Seller)session.getAttribute("seller");
        map.put("sellerInfo",seller.getSellerName());
        map.put("sellerId",seller.getSid());
        return map;
    }
    
    /**
     * 商家注销/登出
     * @param session
     * @return
     */
    @GetMapping("/sellerLoginOut")
    public Map<String,Object> SellerLoginOut(HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        session.invalidate();
        map.put("message","点击返回登录页");
        return map;
    }
}
