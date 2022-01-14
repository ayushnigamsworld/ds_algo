package fiftyfivetechnology.service;

import fiftyfivetechnology.model.Price;

import java.util.List;

public class PricingService {

    private PricingRulesService pricingRulesService = new PricingRulesService();

    public Price calculateRelevantPrice(String itemId, Integer quantity, List<String> offers) throws Exception {
        Float totalPrice = 0.0f;
        if (quantity == 1) {
            return pricingRulesService.getOfferPrice(itemId, 1);
        }
        List<Integer> sortedQuantites = getPricingOfferQuantity(itemId);
        Integer startingIndex = 0;
        for (Integer offerQuantity: sortedQuantites) {
            if (quantity >= offerQuantity) {
                break;
            }
            startingIndex++;
        }
        while (quantity > 0 && startingIndex < sortedQuantites.size()) {
            Integer offerQuantity = sortedQuantites.get(startingIndex);
            Integer quotient = quantity / offerQuantity;
            Price price = pricingRulesService.getOfferPrice(itemId, offerQuantity);
            if (price == null) {
                continue;
            }
            if (offerQuantity > 1) {
                offers.add("Offer applied for "+ itemId + " on " + quotient * offerQuantity
                        + " under price of "+ price.getAmount() + " per " + offerQuantity);
            }
            totalPrice += quotient * price.getAmount();
            quantity = quantity % offerQuantity;
            startingIndex++;
        }
        if (quantity != 0) {
            throw new Exception("something went wrong");
        }
        return new Price(totalPrice);
    }

    private List<Integer> getPricingOfferQuantity(String itemId) {
        return pricingRulesService.getSortedQuantitiesPricing(itemId);
    }
}
