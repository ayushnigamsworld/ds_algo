package slowFastPointer;

/**
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

 Example 1:

 Input: 23
 Output: true (23 is a happy number)
 Explanations: Here are the steps to find out that 23 is a happy number:
 2^2 + 3 ^22
 ​2
 ​​ +3
 ​2
 ​​  = 4 + 9 = 13
 1^2 + 3^21
 ​2
 ​​ +3
 ​2
 ​​  = 1 + 9 = 10
 1^2 + 0^21
 ​2
 ​​ +0
 ​2
 ​​  = 1 + 0 = 1
 *
 */
public class HappyBeautifulNumber {

    public static void main(String[] args) {
        HappyBeautifulNumber happyBeautifulNumber = new HappyBeautifulNumber();
//        System.out.println(happyBeautifulNumber.isHappyNumber(23));
        System.out.println(happyBeautifulNumber.isHappyNumber(12));
    }

    public boolean isHappyNumber(int n) {
        int slow = n, fast = n;
        do {
            slow = findSquaredSum(slow);
            fast = findSquaredSum(findSquaredSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int findSquaredSum(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n = n / 10;
        }
        return sum;
    }
}
