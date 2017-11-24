package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ITEMSView {

    private int id;
    private final SimpleStringProperty itemName;
    private final SimpleStringProperty itemDesc;
    private final SimpleIntegerProperty quantity;
    private final SimpleIntegerProperty price;
    private final SimpleIntegerProperty totalPrice;

    public ITEMSView(ITEMS item) {

        id = item.getId();

        itemName = new SimpleStringProperty(item.getItemName());
        itemDesc = new SimpleStringProperty(item.getItemDesc());

        quantity = new SimpleIntegerProperty(item.getQuantity());
        price = new SimpleIntegerProperty(item.getPrice());
        totalPrice = new SimpleIntegerProperty(item.getTotalPrice());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public String getItemDesc() {
        return itemDesc.get();
    }

    public SimpleStringProperty itemDescProperty() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc.set(itemDesc);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public int getPrice() {
        return price.get();
    }

    public SimpleIntegerProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public int getTotalPrice() {
        return totalPrice.get();
    }

    public SimpleIntegerProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice.set(totalPrice);
    }

}
