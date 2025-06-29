package com.example.lowleveldesign.inventorymanagementsystem.controllers.warehouse;

import com.example.lowleveldesign.inventorymanagementsystem.inventory.Warehouse;

import java.util.List;

public abstract class WarehouseSelectionCategory {

    public abstract Warehouse selectWarehouse(List<Warehouse> warehouseList);
}
