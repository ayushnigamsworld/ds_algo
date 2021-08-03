/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 * There are n flights that are labeled from 1 to n.

 You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.

 Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.



 Example 1:

 Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 Output: [10,55,45,25,25]
 Explanation:
 Flight labels:        1   2   3   4   5
 Booking 1 reserved:  10  10
 Booking 2 reserved:      20  20
 Booking 3 reserved:      25  25  25  25
 Total seats:         10  55  45  25  25
 Hence, answer = [10,55,45,25,25]
 */
public class FlightBookingPrefixDiff {

    public static void main(String[] args) {
        int[][] bookings = { {1, 2, 10}, {2, 3, 20}, {2, 5, 25} };
        int[] result = corpFlightBookings(bookings, 5);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n];
        int[] diff = new int[n+1];
        for (int []booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int seats = booking[2];
            diff[start-1] += seats;  // diff[start]   += seats.
            diff[end] -= seats;      // diff[end + 1] -= seats.
        }
        flights[0] = diff[0];
        for (int i=1; i<n; i++) {
            flights[i] = diff[i] + flights[i-1];
        }
        return flights;
    }
}
