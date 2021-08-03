package codility.toptal;

public class Task2 {
    public static void main(String[] args) {
        String s1 = "555372654tot";
        //           0123456
        // case 3: totalLength % 3 == 0
        String result = "";
        if (s1.length() % 3 == 1) {
            int start = 0;
            int end = start + 2;
            int fourthLast = s1.length()-4;
            while (end < fourthLast) {
                result += s1.substring(start, end+1);
                result += '-';
                start = end+1;
                end = start + 2;
            }
            result += s1.substring(fourthLast, fourthLast+2);
            result += '-';
            result += s1.substring(fourthLast + 2, fourthLast + 4);
        }

        if (s1.length() % 3 == 2) {
            int start = 0;
            int end = start + 2;
            int secondLast = s1.length()-2;
            while (end < secondLast) {
                result += s1.substring(start, end+1);
                result += '-';
                start = end+1;
                end = start + 2;
            }
            result += s1.substring(secondLast, secondLast+2);
        }



        if (s1.length() % 3 == 0) {
            int start=0;
            int end = start+2;
            while (end < s1.length()) {
                result += s1.substring(start, end+1);
                result += '-';
                start = end+1;
                end = start + 2;
            }
            result = result.substring(0, result.length()-1);
        }
        System.out.println(result);
    }
}
