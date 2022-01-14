package fiftyfivetechnology.model;

import java.util.List;

public class FinalResult {
    List<String> offers;
    Price total;

    public FinalResult() {
    }

    public FinalResult(List<String> offers, Price total) {
        this.offers = offers;
        this.total = total;
    }

    public List<String> getOffers() {
        return offers;
    }

    public void setOffers(List<String> offers) {
        this.offers = offers;
    }

    public Price getTotal() {
        return total;
    }

    public void setTotal(Price total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Total= " + total.getAmount() + "\n Offers: " + offers;
    }
}
