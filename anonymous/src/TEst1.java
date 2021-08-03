import java.math.BigInteger;
import java.util.*;

/**
 * [
 * {
 *  “page1”: [
 *    [“table”],
 *    [“key1”,”key2”],
 *    [“table”],
 *    [“value1”,”value2”],
 *    [“table”],
 *    [“value3”,”value4”],
 *    [“table”],
 *    [“value5”,”value6”]
 *  ]
 * }
 * ].
 simplify this to achieve this :
 {
 “page1”:[{
   “Key1”:”value1”,
   “Key2”:”value2”
  },
  {
    “Key1”:”value3”,
   “Key2”:”value4”
  },
 {
 “Key1”:”value5”,
 “Key2”:”value6”
 }
 ]
 }
 */
public class TEst1 {

    public static void main(String[] args) {
        int x = 0x000F & 0x2222;
        int y  = 3 | 5;
        char aaa = '0';

        List<String> ls = new ArrayList<>();
        ls.add("TOm");
        ls.add("Dick");

        String ssw = new String(new char[] {'c'});
        System.out.println(ssw.indexOf("0"));
        System.out.println(Integer.toBinaryString(3332));
        leftmostZeroBit(3332);
        System.out.println((int)'0');
        System.out.println(x);
        System.out.println(y);
        Properties p = System.getProperties();
        p.setProperty("pirate", "sc");
        String s = p.getProperty("arg") + " ";
        s+= p.getProperty("pirate");
        System.out.println(s);

        String ss = "232";
        new StringBuilder(ss).reverse().toString();
        BigInteger b= new BigInteger(ss);
        ss.contains("2");
    }


    private static void leftmostZeroBit(int a) {
        int mask = 1;
        // This loop finds the leftmost 1 bit
//

        // This loop starts from the leftmost 1 bit and searches for the first 0 going right
        while((a & mask) != 0)
            mask >>= 1;

        System.out.println(Math.log(mask) / Math.log(2) + 1);
    }


}
