package fiftyfivetechnology.service;

import fiftyfivetechnology.model.FinalResult;
import fiftyfivetechnology.model.Item;
import fiftyfivetechnology.model.Price;
import fiftyfivetechnology.model.PricingRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutService {

    private PricingRulesService pricingRulesService = new PricingRulesService();
    private PricingService pricingService = new PricingService();

    private Map<String, Integer> itemCount = new HashMap<>();

    public CheckoutService() {
    }

    public CheckoutService(List<PricingRule> pricingRuleList) throws Exception {
        init(pricingRuleList);
    }

    void init(List<PricingRule> pricingRules) throws Exception{
        for (PricingRule pricingRule: pricingRules) {
            pricingRulesService.addPricing(pricingRule);
        }
    }

    public void scan(Item item) {
        itemCount.put(item.getId().toString(), itemCount.getOrDefault(item.getId().toString(), 0) + 1);
    }

    public FinalResult total() throws Exception {
        List<String> offers = new ArrayList<>();
        Float totalPrice = 0.0f;
        for (Map.Entry<String, Integer> obj: itemCount.entrySet()) {
            totalPrice += pricingService.calculateRelevantPrice(obj.getKey(), obj.getValue(), offers).getAmount();
        }
        return new FinalResult(offers, new Price(totalPrice));
    }
}
