package fiftyfivetechnology.model;

public class Price {
    private String currency = "$";
    private Float amount;

    public Price() {

    }

    public Price(Float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
