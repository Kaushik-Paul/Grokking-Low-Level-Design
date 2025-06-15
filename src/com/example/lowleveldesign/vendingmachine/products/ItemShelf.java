package com.example.lowleveldesign.vendingmachine.products;

public class ItemShelf {
    private int code;
    private Item item;
    private boolean isSoldOut;

    public ItemShelf() {
    }

    public ItemShelf(int code, Item item, boolean isSoldOut) {
        this.code = code;
        this.item = item;
        this.isSoldOut = isSoldOut;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }
}
