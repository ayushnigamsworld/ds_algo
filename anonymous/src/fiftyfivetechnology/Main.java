package fiftyfivetechnology;

import fiftyfivetechnology.model.FinalResult;
import fiftyfivetechnology.model.Item;
import fiftyfivetechnology.model.Price;
import fiftyfivetechnology.model.PricingRule;
import fiftyfivetechnology.service.CheckoutService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {
        PricingRule pricingRuleA1 = new PricingRule("1234", 1, new Price(10f), null);
        PricingRule pricingRuleA2 = new PricingRule("1234", 2, new Price(15f), null);
        PricingRule pricingRuleA3 = new PricingRule("1234", 3, new Price(25f), null);
        PricingRule pricingRuleB1 = new PricingRule("5678", 1, new Price(20f), null);
        PricingRule pricingRuleB2 = new PricingRule("5678", 2, new Price(30f), null);
        PricingRule pricingRuleC1 = new PricingRule("3256", 1, new Price(5f), null);
        List<PricingRule> pricingRules = new ArrayList<>();
        pricingRules.add(pricingRuleA1);
        pricingRules.add(pricingRuleA2);
        pricingRules.add(pricingRuleA3);
        pricingRules.add(pricingRuleB1);
        pricingRules.add(pricingRuleB2);
        pricingRules.add(pricingRuleC1);

        CheckoutService checkoutService = new CheckoutService(pricingRules);
        checkoutService.scan(new Item("1234", "A"));
        checkoutService.scan(new Item("5678", "B"));
        checkoutService.scan(new Item("5678", "B"));
        checkoutService.scan(new Item("1234", "A"));
        checkoutService.scan(new Item("5678", "B"));
        checkoutService.scan(new Item("1234", "A"));
        checkoutService.scan(new Item("1234", "A"));
        checkoutService.scan(new Item("1234", "A"));
        checkoutService.scan(new Item("5678", "B"));
        checkoutService.scan(new Item("3256", "C"));
        checkoutService.scan(new Item("3256", "C"));

        // 5As and 4Bs
        FinalResult finalResult = checkoutService.total();
        System.out.println(finalResult);
    }
}
