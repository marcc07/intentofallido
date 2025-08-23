package Clinic.Clinic.domain.model;

import Clinic.Clinic.domain.model.ValOb.*;

public class InvoiceLine {
    private final String description;
    private final int quantity;
    private final Money unitCost;
    private final Money lineTotal;
    private final String orderNumber;
    private final int itemNo;
    
    public InvoiceLine(String description, int quantity, Money unitCost, 
                      String orderNumber, int itemNo) {
        this.description = description;
        this.quantity = quantity;
        this.unitCost = unitCost;
        this.lineTotal = unitCost.multiply(quantity);
        this.orderNumber = orderNumber;
        this.itemNo = itemNo;
    }
    
    // Getters
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public Money getUnitCost() { return unitCost; }
    public Money getLineTotal() { return lineTotal; }
    public String getOrderNumber() { return orderNumber; }
    public int getItemNo() { return itemNo; }
}