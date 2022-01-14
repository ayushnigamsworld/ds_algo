package fiftyfivetechnology.model;

import fiftyfivetechnology.model.Price;

import java.util.UUID;

public class PricingRule {
    UUID id;
    String itemId;
    Integer quantity;
    Price price;
    Long expiry;

    public PricingRule() {
    }

    public PricingRule(String itemId, Integer quantity, Price price, Long expiry) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.expiry = expiry;
    }

    public Long getExpiry() {
        return expiry;
    }

    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
