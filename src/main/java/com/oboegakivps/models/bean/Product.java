package com.oboegakivps.models.bean;

/**
 * 商品クラス(DTO/Entity)
 */
public class Product {

    /**
     * 商品ID
     */
    private String id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 価格
     */
    private int price;

    /**
     * 購入数
     */
    private int purchaseNumber;

    /**
     * コンストラクタ
     * @param id
     * @param name
     * @param price
     */
    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 価格を文字列で返す（３桁カンマ区切り＋"円"）
     * @return 価格 + 円
     */
    public String getPriceString() {
        return String.format("%,d", Integer.valueOf(price)) + "円";
    }

    /**
     * @return purchaseNumber
     */
    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    /**
     * 購入ボタンを押下時、個数を増やす。
     * @param purchaseNumber 購入数
     */
    public void addPurchaseNumber() {
        this.purchaseNumber += 1;
    }

}
