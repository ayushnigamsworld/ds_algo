package parentChild;

public class ParentMapper implements CommonInterface<Parent> {
    @Override
    public Parent mapRow() {
        Parent p = new Child();
        p.setField1("parent 1");
        p.setField2("parent 2");
        return p;
    }
}
