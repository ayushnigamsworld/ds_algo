package Coderbyte;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Predicate;

public class Agecounting {

    public static void main(String[] args) {
        InputStream ip = null;
        String s = new String();
        char[] aa = s.toCharArray();
    }



}

class StringsCollection {
    public List<String> stringsCollection = Collections.synchronizedList(new
            ArrayList<String>());

    void addString(String string) {
        this.stringsCollection.add(string);
    }

    List<String> getStringsCollection() {
        return stringsCollection;
    }
};

