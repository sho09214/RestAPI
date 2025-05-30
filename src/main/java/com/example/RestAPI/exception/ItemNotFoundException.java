package com.example.RestAPI.exception;



public class ItemNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(Long itemid){
        super("商品コード:" + itemid + "は見つかりません。");
    }
}
