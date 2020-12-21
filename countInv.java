import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class countInv {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("input3.txt")); //reading from the file
            while (sc.hasNextLine()) {
                String num[] = sc.nextLine().split(" ");
                for (String elem : num) {
                    list.add(Integer.parseInt(elem));
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        int array_size = arr.length;
        int countInversion = mergeSort(arr, 0, array_size - 1);
        System.out.println(" " + countInversion);
    }
    // method to count inversion and sort the array
    static int mergeSort(int arr[], int l, int r) {
        int mid;
        if (l < r) {
            mid = (r + l) / 2;
            int a = mergeSort(arr, l, mid); // Dividing array into left
            int b = mergeSort(arr, mid + 1, r); // Divinging array into right
            int c = merge(arr, l, mid, r); // Merging the two parts above left and right
            return a + b + c;
        }
        return 0;
    }

    static int merge(int arr[], int l, int mid, int r) {
        int temp[] = new int[r - l + 1]; // making temporary array to hold sorted values
        int i = l; // assigning pointer i
        int j = mid + 1; // assigning pointer j
        int k = 0; // k is sub array for temp
        int inverSplit = 0;
        while ((i <= mid) && (j <= r)) {
            if (arr[i] <= arr[j]) { // choose array from left and increment it
                temp[k++] = arr[i++];
            } else { // choosing array from right and incrementing it
                temp[k++] = arr[j++];
                inverSplit = inverSplit + (mid + 1 - i);
            }
        }
        while (i <= mid) // check if there are number remaining in array
            temp[k++] = arr[i++];
        while (j <= r) // check if there are number remaining in sub part of right array
            temp[k++] = arr[j++];
        for (int n = l; n <= r; n++) // copying temp arr into original function
            arr[n] = temp[n - l];
        return inverSplit;
    }
}