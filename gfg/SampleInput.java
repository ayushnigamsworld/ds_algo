import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SampleInput {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- >0) {
            int n = Integer.parseInt(read.readLine());
            int[] a = new int[n];
            int ans = -1;
            String st[] = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st[i]);
        }
    }
}
