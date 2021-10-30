package glider.Yoh;

public class DecimalToRoman {

    public static void main(String[] args) {
        printRoman(2113);
    }

    static int sdigit(char num1, char num2, int i, char[] c) {
        c[i++] = num1;
        c[i++] = num2;
        return i;
    }

    // To add symbol 'ch' n times after index i in c[]
    static int dgit(char ch, int n, int i, char[] c) {
        for (int j = 0; j < n; j++) {
            c[i++] = ch;
        }
        return i;
    }

    // Function to convert decimal to Roman Numerals
    static void printRoman(int n) {
        char ch[] = new char[10001];
        int i = 0;

        // If number entered is not valid
        if (n <= 0) {
            System.out.printf("Invalid number");
            return;
        }

        // TO convert decimal number to roman numerals
        while (n != 0) {
            // If base value of number is greater than 1000
            if (n >= 1000) {
                // Add 'M' number/1000 times after index i
                i = dgit('M', n / 1000, i, ch);
                n = n % 1000;
            } // If base value of number is greater than or
            // equal to 500
            else if (n >= 500) {
                // To add base symbol to the character array
                if (n < 900) {
                    // Add 'D' number/1000 times after index i
                    i = dgit('D', n / 500, i, ch);
                    n = n % 500;
                } // To handle subtractive notation in case of number
                // having dgit as 9 and adding corresponding base
                // symbol
                else {
                    // Add C and M after index i/.
                    i = sdigit('C', 'M', i, ch);
                    n = n % 100;
                }
            } // If base value of number is greater than or equal to 100
            else if (n >= 100) {
                // To add base symbol to the character array
                if (n < 400) {
                    i = dgit('C', n / 100, i, ch);
                    n = n % 100;
                } // To handle subtractive notation in case of number
                // having dgit as 4 and adding corresponding base
                // symbol
                else {
                    i = sdigit('C', 'D', i, ch);
                    n = n % 100;
                }
            } // If base value of number is greater than or equal to 50
            else if (n >= 50) {
                // To add base symbol to the character array
                if (n < 90) {
                    i = dgit('L', n / 50, i, ch);
                    n = n % 50;
                } // To handle subtractive notation in case of number
                // having dgit as 9 and adding corresponding base
                // symbol
                else {
                    i = sdigit('X', 'C', i, ch);
                    n = n % 10;
                }
            } // If base value of number is greater than or equal to 10
            else if (n >= 10) {
                // To add base symbol to the character array
                if (n < 40) {
                    i = dgit('X', n / 10, i, ch);
                    n = n % 10;
                } // To handle subtractive notation in case of
                // number having dgit as 4 and adding
                // corresponding base symbol
                else {
                    i = sdigit('X', 'L', i, ch);
                    n = n % 10;
                }
            } // If base value of number is greater than or equal to 5
            else if (n >= 5) {
                if (n < 9) {
                    i = dgit('V', n / 5, i, ch);
                    n = n % 5;
                } // To handle subtractive notation in case of number
                // having dgit as 9 and adding corresponding base
                // symbol
                else {
                    i = sdigit('I', 'X', i, ch);
                    n = 0;
                }
            } // If base value of number is greater than or equal to 1
            else if (n >= 1) {
                if (n < 4) {
                    i = dgit('I', n, i, ch);
                    n = 0;
                } // To handle subtractive notation in case of
                // number having dgit as 4 and adding corresponding
                // base symbol
                else {
                    i = sdigit('I', 'V', i, ch);
                    n = 0;
                }
            }
        }

        String sss = new String(ch);
        System.out.println(sss);

        // Printing equivalent Roman Numeral
        System.out.printf("Roman numeral is: ");
        for (int j = 0; j < i; j++) {
            System.out.printf("%c", ch[j]);
        }
    }
}
