package com.example.lowleveldesign.vendingmachine.products;

public class Inventory {
    private ItemShelf[] inventory;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    private void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < this.inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            this.inventory[i]= space;
            startCode++;
        }
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                    break;
                } else {
                    throw new Exception("Item already exists, you cannot add another item");
                }
            }
        }
    }

    public Item getItem (int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("Item is sold out");
                } else {
                    return itemShelf.getItem();
                }
            }
        }

        throw new Exception("Item not found, invalid code number");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }

}
