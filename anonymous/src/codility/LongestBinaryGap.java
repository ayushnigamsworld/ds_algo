package codility;

public class LongestBinaryGap {

    public static void main(String[] args) {
        solution(1548);
    }

    public static int solution(int N) {
        // write your code in Java SE 8

        String input = Integer.toBinaryString(N);
        int maxGap = 0;
        boolean start = false;
        int cnt = 0;
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '1' && !start) {
                start = true;
                cnt = 0;
            } else if (input.charAt(i) == '1' && start) {
                maxGap = Math.max(maxGap, cnt);
                cnt = 0;
            }
            if (input.charAt(i) == '0' && start) {
                cnt++;
            }
        }
        return maxGap;
    }
}
