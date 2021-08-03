package mettle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SiblingTreeArr {

    public static void main(String[] args) {
        int input2[] = {1, 2, 3, 4, 5, 6};
        int input1 = input2.length;
        int input3 = 5;
        int parent = -1;
        for (int i=0; i<input2.length; i++) {
            int leftChild = 2*i + 1;
            int rightChild = 2*i + 2;
            if (leftChild< input1 && input2[leftChild] == input3) {
                parent = i;
                break;
            }
            if (rightChild < input1 && input2[rightChild] == input3) {
                parent = i;
                break;
            }
        }
        if (parent == -1) {
            System.out.println(-1);
            return;
        }

        List<Integer> result = new ArrayList<>();
        int lowerBound = input1;
        int upperBound = input1;
        for (int level=0; level<input1; level++) {
            lowerBound = (int)Math.pow(2, level) - 1;
            upperBound = lowerBound;
            if (level >= 1) {
                upperBound = (int)Math.pow(2, level) + (int)Math.pow(2, level-1) - 1;
            }
            if (parent >= lowerBound && parent <= upperBound) {
                break;
            }
        }
        for (int i=lowerBound; i<= upperBound; i++) {
            int leftChild = 2*i + 1;
            int rightChild = 2*i + 2;
            if (leftChild < input1 && input2[leftChild] != input3) {
                result.add(input2[leftChild]);
            }
            if (rightChild < input1 && input2[rightChild] != input3) {
                result.add(input2[rightChild]);
            }
        }

        if (result.size() == 0) {
            System.out.println(-1);
            return;
        }
        Collections.sort(result);
        int output[] = new int[result.size()];
        for (int i=0; i<output.length; i++) {
            output[i] = result.get(i);
        }
        for (int i=0; i<output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static int[] findSiblings(int input1, int[] input2, int input3) {
        int[] result = new int[] {-1};
        if (input2[0] == input3) {
            return result;
        }

        int siblingFindIndex = -1;
        for(int i=0;i<input2.length;i++){
            if(input2[i]==input3) { //If element at i position is search element
                siblingFindIndex = i;
                break; // end loop
            }
        }
        if(siblingFindIndex>-1){ //index was found in integer array
            result = new int[]{input2[siblingFindIndex-1],input2[siblingFindIndex+1]}; // add found index+1 as upper sibling and found Index -1 as lower sibling
            //to do -> check if both elements exists so there can be no array out of bounds
        }

        return result;

    }
}
