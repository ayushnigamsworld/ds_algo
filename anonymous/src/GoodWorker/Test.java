package GoodWorker;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * -------------------------------------------
 2 - 6
 10 - 12
 5 - 6
 3 - 4
 Min number of meeting rooms
 2

 2-6
 3-4
 5-6
 10-12

-> sort on basis of starting time
-> maxEndingTime
-> compare current and current + 1
   maxEndingTime in current and current + 1
   if start(current + 1 ) < end(current) || endTime(firstOne) > endTime(second)
      count ++




 "abbccpqqpa"
 "appa"
 "aa"
 ""
 "aba"
 "aba"
 "aaab"
 "b"

 a


 *
 */

public class Test {


    public String removeNonRepeating(String str) {
        if (str.length() < 2) {
            //
        }
        int comparedWith = 0;
        List<Character> result = new ArrayList<>();
        int resultIndex = 0;
        char current = str.charAt(0);
        for (int i=0; i<str.length(); i++) {

            comparedWith = i + 1;
            char compareElement = str.charAt(comparedWith);
            if (current != compareElement) {
                result.add(current);
                resultIndex ++;
            } else {
                result.remove(result.size()-1);
            }
        }
        return "";
    }
}
