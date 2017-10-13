import javafx.beans.property.SimpleStringProperty;

public class items {
    private final SimpleStringProperty itemName;
    private final SimpleStringProperty itemDesc;
    private final SimpleStringProperty Quantity;
    private final SimpleStringProperty unitPrice;

    public items(String itemName, String itemDesc, String Quantity, String unitPrice) {
        this.itemName = new SimpleStringProperty(itemName);
        this.itemDesc = new SimpleStringProperty(itemDesc);
        this.Quantity = new SimpleStringProperty(Quantity);
        this.unitPrice = new SimpleStringProperty(unitPrice);
    }

    public String getitemName() { return itemName.get(); }
    public void setitemName(String itemName) { this.itemName.set(itemName); }

    public String getitemDesc() { return itemDesc.get(); }
    public void setitemDesc(String itemDesc) { this.itemDesc.set(itemDesc); }

    public String getQuantity() { return Quantity.get(); }
    public void setQuantity(String Quantity) { this.Quantity.set(Quantity); }

    public String getUnitPrice() { return unitPrice.get(); }
    public void setUnitPrice(String unitPrice) { this.unitPrice.set(unitPrice); }

}

