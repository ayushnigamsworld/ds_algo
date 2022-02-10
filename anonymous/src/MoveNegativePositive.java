public class MoveNegativePositive {

    public static void main(String[] args) {

    }

    /**
     *
     * [-2, 1, 4, -5, 7, -6]
     *
     * [-2, 1, -5, 4, 7, -6]
     *
     * [-2, 1, -5, 4, -6, 7]
     *
     * [-2, -5, 4, 1, 7, -6]
     *
     * [-2, -5, 1, 4, 7, -6]
     *
     * [-2, -5, -6, 4, 7, 1]
     *
     * [-2, -5, -6, 1, 4, 7, 8, 9, -2]
     *
     *
     * firstPtr = pointing at first >0 no.
     * while  (current < 0) {
     *     firstPtr = current;
     * }
     *
     * currentPtr = representing current element
     * Next possible <0
     *
     * while (current < arr.length) {
     *     if (arr[current] < 0 ) {
     *         swap (arr[firstPtr], arr[current]) // it will bring -ve left side and keep order of -ive intact
     *         firstPtr ++;
     *     }
     *     stabilizePositive(firstPtr, currentPtr);
     * }
     *
     */
    private void move(int[] arr) {

    }
}
