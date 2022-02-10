package models;

import lombok.Data;

@Data
public class Summary {
    private long total;
    private long cured;
    private long fatality;
    private long active;

    @Override
    public String toString() {
        return "Summary{" +
                "total=" + total +
                ", cured=" + cured +
                ", fatality=" + fatality +
                ", active=" + active +
                '}';
    }
}
