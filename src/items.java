import javafx.beans.property.SimpleStringProperty;

public class items {
    private final SimpleStringProperty itemName;
    private final SimpleStringProperty itemDesc;
    private final SimpleStringProperty Quantity;
    private final SimpleStringProperty unitPrice;
    private final SimpleStringProperty totalPrice;

    public items(String itemName, String itemDesc, String Quantity, String unitPrice, String totalPrice) {
        this.itemName = new SimpleStringProperty(itemName);
        this.itemDesc = new SimpleStringProperty(itemDesc);
        this.Quantity = new SimpleStringProperty(Quantity);
        this.unitPrice = new SimpleStringProperty(unitPrice);
        this.totalPrice = new SimpleStringProperty(totalPrice);
    }

    public String getItemName() { return itemName.get(); }
    public void setItemName(String itemName) { this.itemName.set(itemName); }

    public String getItemDesc() { return itemDesc.get(); }
    public void setItemDesc(String itemDesc) { this.itemDesc.set(itemDesc); }

    public String getQuantity() { return Quantity.get(); }
    public void setQuantity(String Quantity) { this.Quantity.set(Quantity); }

    public String getUnitPrice() { return unitPrice.get(); }
    public void setUnitPrice(String unitPrice) { this.unitPrice.set(unitPrice); }

    public String getTotalPrice() { return totalPrice.get(); }
    public void setTotalPrice(String totalPrice) { this.totalPrice.set(totalPrice); }

}

