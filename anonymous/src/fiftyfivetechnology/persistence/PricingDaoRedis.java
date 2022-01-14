package fiftyfivetechnology.persistence;

import fiftyfivetechnology.model.Price;
import fiftyfivetechnology.model.PricingRule;
import fiftyfivetechnology.persistence.config.RedisService;

public class PricingDaoRedis {

    public Price getPriceFor(String itemId, Integer quantity) {

        String price = RedisService.getInstance().get(generateKey(itemId, quantity));
        return new Price(Float.valueOf(price));
    }

    public String getOfferQuantities(String itemId) {
        return RedisService.getInstance().get(generateKeyQuantity(itemId));
    }

    public void addRule(PricingRule pricingRule) {
        RedisService.getInstance().set(generateKey(pricingRule.getItemId(), pricingRule.getQuantity()),
                pricingRule.getPrice().getAmount().toString(), pricingRule.getExpiry());
        String existing = this.getOfferQuantities(pricingRule.getItemId());
        if (existing == null) {
            existing = "";
        }
        existing +=  pricingRule.getQuantity().toString() + ",";
        RedisService.getInstance().set(generateKeyQuantity(pricingRule.getItemId()), existing, null);
    }

    public void removeRule(String itemId, Integer quantity) {
        RedisService.getInstance().remove(generateKey(itemId, quantity));
        // similar logic to remove quantity
    }

    private String generateKey(String itemId, Integer quantity) {
        return "price_" + itemId + "_" + quantity;
    }

    private String generateKeyQuantity(String itemId) {
        return "quantity_" + itemId;
    }
}
