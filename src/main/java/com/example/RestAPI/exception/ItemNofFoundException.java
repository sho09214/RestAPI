package com.example.RestAPI.exception;

public class ItemNofFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ItemNofFoundException(Long itemId) {
        super("商品コード：" + itemId + "は見つかりません。");
    }
}
