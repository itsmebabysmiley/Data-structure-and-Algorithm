package Sorting;

/**
 * Bubble
 */
public class Bubble {

    /**
     * BigO is n**2
     * 
     * @param array
     */
    public void sort(int[] array) {
        System.out.print("Before: ");
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println("\n");
        for (int i = 1; i < array.length; i++) {
            System.out.println("Round:"+i);
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                // for (int k : array) {
                //     System.out.print(k + " ");
                // }System.out.println();
            }
            for (int k : array) {
                System.out.print(k + " ");
            }System.out.println();


        }
    }
}