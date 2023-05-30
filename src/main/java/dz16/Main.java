package dz16;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {4,3,7,1,8,5,2,9,10,6};

        //quickSort(array,0,array.length-1);
        shakerSort(array);

        for(int i:array){
            System.out.println(i);
        }
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = array[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;
                    swap(array, i, j);
                }
            }

            swap(array, i + 1, high);
            int pivotIndex = i+1;

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static void shakerSort(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array,i,i+1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = array.length - 2; i >= 0; i--) {
                if (array[i] > array[i + 1]) {
                    swap(array,i,i+1);
                    swapped = true;
                }
            }
        } while (swapped);
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
