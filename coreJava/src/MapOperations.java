import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOperations {

    public static void main(String[] args) {
        Map<String, List<Someclass>> ss = new HashMap<>();
        List<Someclass> l = new ArrayList<>();
        l.add(new Someclass("hello"));
        ss.put("a1", l);
        System.out.println(ss.toString());
    }
}

class Someclass {
    public Someclass() {

    }
    public Someclass(String s) {
        this.a1 = s;
    }
    private String a1;

    @Override
    public String toString() {
        return "Someclass{" +
                "a1='" + a1 + '\'' +
                '}';
    }
}
