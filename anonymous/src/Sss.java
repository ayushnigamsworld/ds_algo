import java.util.List;

/**
 *
 * bb,aa,ab,bd
 * aa,ab,bb,bd
 * ac, bb, cd
 * 13, 22, 34
 * ac, cd, bb
 * 13, 34, 22
 *
 *
 *
 * aa ac ad aa ab ac
 *
 * 1. Find and extract/remove the duplicate elements.: [aa, ac]
 * 2. Original: aa  ab ac ad
 * 3. Form group and sort using original algorithm : [aa ab aa ac ad ac]
 * 4. Inject the duplicate element group to now sorted array: [aa, ac] as sorted by themselves.
 *
 *
 * aa ab ac ad
 *
 * aa ab
 *
 * aa ab aa ab ac
 *
 * aa ab ab
 * aa
 * aa ab aa ab
 *
 *
 * Original:
 * [aa ab aa ab bb ab bb]
 *
 *  aa -- ab
 *  ab  -- bb
 *  ab
 *  aa
 *  bb
 *
 *        aa
 *  aa
 *  bb
 *
 * 11,12,11,22,24 --O(n)
 *
 * 1. Finding the groups of pairs having anything common
 * 2. Sorting using radix sort.
 *
 *
 * 1. : Each pair : run through loop, list. --> sorted O(n2) boolean visited[] = true
 *    List<List> : bb, ab, bd: Radix Sort: () O(n): ab, bb, bd
 *    List<>: aa:
 *    .
 *    .
 *    .
 *    .
 *    O(n)
 *    O(n)
 *    Sorted Arrays: Merging the sorted arrays: O(n).
 *    O(n2) + O(n)
 *
 *
 * 2.
 */
public class Sss {

    public static void main(String[] args) {

    }

}
