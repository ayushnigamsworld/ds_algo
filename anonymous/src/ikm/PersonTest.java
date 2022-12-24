package ikm;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonTest {


    static List<Person> people = Arrays.asList(new Person("bob", 1), new Person(2), new Person("Jane", 3));
    static int x;
    public static void main(String[] args) {
        people.stream().reduce((e1, e2) -> {
            x = e1.id;
            if (e1.id > e2.id) {
                return e1;
            }
            x = e2.id;
            return e2;
        }).flatMap(e -> Optional.ofNullable(e.name)).map(y -> new Person(y, x)).ifPresent(System.out::println);
    }
}


class Person {
    String name;
    Integer id;
    Person(int i) {
        name = null;
        id = i;
    }

    Person(String n,int i) {
        name = n;
        id = i;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
