package fiftyfivetechnology.service;

import fiftyfivetechnology.model.Price;
import fiftyfivetechnology.model.PricingRule;
import fiftyfivetechnology.persistence.PricingDao;
import fiftyfivetechnology.persistence.PricingDaoRedis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PricingRulesService {

    private PricingDao pricingDao = new PricingDao();
    private PricingDaoRedis pricingDaoRedis = new PricingDaoRedis();

    // @Secured() role checking done via annotations here
    public void addPricing(PricingRule pricingRule) throws Exception {
        // check rules of pricingRule here
        checkValidPricingRule(pricingRule);
        pricingDao.create(pricingRule);
        pricingDaoRedis.addRule(pricingRule);
    }

    // Role check here
    public void removePricing(String id) {
        PricingRule pricingRule = pricingDao.getById(id);
        pricingDaoRedis.removeRule(pricingRule.getItemId(), pricingRule.getQuantity());
        pricingDao.remove(id);
    }

    public List<Integer> getSortedQuantitiesPricing(String itemId) {
        String list = pricingDaoRedis.getOfferQuantities(itemId);
        String[] quantities = list.trim().split(",");
        List<Integer> result = new ArrayList<>();
        for (String quantity: quantities) {
            quantity = quantity.trim();
            if (quantity.length() == 0) { continue; }
            result.add(Integer.parseInt(quantity));
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    public Price getOfferPrice(String itemId, Integer quantity) {
        return pricingDaoRedis.getPriceFor(itemId, quantity);
    }

    private Boolean checkValidPricingRule(PricingRule pricingRule) {
        // do calculations here w.r.t amount
        return true;
    }
}
