package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.ValOb.*;

public abstract class OrderItem {
    private final int itemNo;
    private final Money cost;
    
    protected OrderItem(int itemNo, Money cost) {
        this.itemNo = itemNo;
        this.cost = cost;
    }
    
    public Money lineTotal() {
        return cost;
    }
    
    public int getItemNo() { return itemNo; }
    public Money getCost() { return cost; }
}