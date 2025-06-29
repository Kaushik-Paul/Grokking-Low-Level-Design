package com.example.lowleveldesign.inventorymanagementsystem.controllers.warehouse;

import com.example.lowleveldesign.inventorymanagementsystem.inventory.Warehouse;

import java.util.List;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionCategory {
    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList) {

        // Algo to select nearest warehouse/
        // TODO: implement this method in future
        return warehouseList.get(0);
    }
}
