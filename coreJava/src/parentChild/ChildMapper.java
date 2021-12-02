package parentChild;

public class ChildMapper implements CommonInterface<Child> {

    @Override
    public Child mapRow() {
        CommonInterface<Parent> c = new ParentMapper();
        Child child = (Child) c.mapRow();
        child.setField3("child field");
        return child;
    }
}
