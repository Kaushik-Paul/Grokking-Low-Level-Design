package com.example.lowleveldesign.inventorymanagementsystem.controllers.warehouse;

import com.example.lowleveldesign.inventorymanagementsystem.inventory.Warehouse;

import java.util.List;

public class WarehouseController {
    private List<Warehouse> warehouseList;
    private WarehouseSelectionCategory warehouseSelectionCategory;

    public WarehouseController(List<Warehouse> warehouseList, WarehouseSelectionCategory warehouseSelectionCategory) {
        this.warehouseList = warehouseList;
        this.warehouseSelectionCategory = warehouseSelectionCategory;
    }

    // Add new warehouse
    public void addNewWarehouse(Warehouse warehouse) {
        warehouseList.add(warehouse);
    }

    // Remove warehouse
    public void removeWarehouse(Warehouse warehouse) {
        warehouseList.remove(warehouse);
    }

    // Select warehouse
    public Warehouse selectWarehouse(WarehouseSelectionCategory warehouseSelectionStrategy) {
        this.warehouseSelectionCategory = warehouseSelectionStrategy;
        return warehouseSelectionStrategy.selectWarehouse(warehouseList);
    }
}
