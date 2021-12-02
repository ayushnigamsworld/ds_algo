package parentChild;

public class Child extends Parent {
    private String field3;

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public static void main(String[] args) {
        CommonInterface cc = new ChildMapper();
        cc.mapRow();
    }
}
