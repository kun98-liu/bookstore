package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.*;

/** 购物车对象
 * @author LIU JIANKUN
 * @create 2021-09-22 20:43
 */
public class Cart {
    private Map<Integer,CartItem> items = new LinkedHashMap<>();

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem> entry: items.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry: items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount()+
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public void addItem(CartItem item){
        CartItem cartItem = items.get(item.getId());
        if(cartItem != null){
            cartItem.setCount(cartItem.getCount()+1);
//            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
            items.put(cartItem.getId(), cartItem);
        }else{
            items.put(item.getId(), item);
        }

    }

    public void deleteItem(Integer id){
        items.remove(id);

    }
    public void clear(){
        items.clear();
    }

    public void updateCount(Integer id,Integer count){
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);
//            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }

    }

}
