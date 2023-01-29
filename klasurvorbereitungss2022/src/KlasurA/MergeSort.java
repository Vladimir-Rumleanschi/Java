package KlasurA;
import java.util.ArrayList;
public class MergeSort {

    public static <T extends Comparable <T>> ArrayList<T> mergeSort(ArrayList<T> list){

        ArrayList<T> left = new ArrayList<>(list.subList(0, (int)list.size() / 2));
        ArrayList<T> right = new ArrayList<>(list.subList((int)list.size() / 2, list.size()));
        /* Sort List */
        if(list.size() == 1) {
            return list;
        } else {
            // Sort the left and right side of the ArrayList
            left = mergeSort(left);
            right = mergeSort(right);
            // Merge the results back together
            merge(left, right, list);
        }
        return list;
    }

    private static <T extends Comparable<T>> void merge(ArrayList<T> left, ArrayList<T> right, ArrayList<T> list ) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;
        /* As long as netiher the left nor the right ArrayList has been used up,
         * keep taking the smaller of left.get(leftIndex) or right.get(rightIndex)
         * and addingit at both.get(bothIndex).
         */
        while(leftIndex < left.size() && rightIndex < right.size()) {
            if(left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                list.set(listIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                list.set(listIndex, right.get(rightIndex));
                rightIndex++;
            }
            listIndex++;
        }
        /* Copy rest of list */
        ArrayList<T> restList = new ArrayList<>();
        int restIndex = 0;
        if(leftIndex >= left.size()) { // The left ArrayList has been used up...
            restList = right;
            restIndex = rightIndex;
        } else { // The right ArrayList has been used up...
            restList = left;
            restIndex = leftIndex;
        }
        // Copy the rest of whichever ArrayList (left or right) was not used
        for(int i = restIndex; i < restList.size(); i++) {
            list.set(listIndex, restList.get(i));
            listIndex++;
        }
    }

}
