package fiftyfivetechnology.persistence;

import fiftyfivetechnology.model.PricingRule;

import java.util.ArrayList;
import java.util.List;

public class PricingDao {

    public PricingRule create(PricingRule pricingRule) {
        // persist it in db along with
        // created_at, updated_at, active, expiry, created_by, updated_by
        // in relational db :: MySQL
        return pricingRule;
    }

    public PricingRule getById(String pricingId) {
        return new PricingRule();
    }

    public List<Integer> getOfferQuantities(String itemId) {
        // SELECT DISTINCT quantity FROM pricing_rules WHERE item_id = :itemId ORDER BY quantity DESC;
        return new ArrayList<>();
    }

    public List<PricingRule> getAllActive() {
        // return all active rules
        return new ArrayList<>();
    }

    public void remove(String pricingRuleId) {
        // remove from Relational db
    }
}
