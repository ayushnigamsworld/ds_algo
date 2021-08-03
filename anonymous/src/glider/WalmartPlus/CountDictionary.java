package glider.WalmartPlus;

import java.util.List;

public class CountDictionary {

    public static void main(String[] args) {

    }


    public String sss(String str, List<String> dict) {
        int le = 0;
        for (String current : dict) {
            le += count(str, current) * current.length();
        }
        if (le == str.length()) {
            return "true";
        }
        return "false";
    }

    private static int count(String str, String word) {
        int lastIndex = 0;
        int count = 0;
        int w = word.length();
        while (lastIndex != -1) {
            lastIndex = str.indexOf(word, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += w;
            }
        }
        return count;
    }
}
