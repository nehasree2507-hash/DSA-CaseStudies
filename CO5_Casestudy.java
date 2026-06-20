import java.util.*;

public class CO5_AdvancedSorting {

    static void mergeSort(int[] arr) {
        Arrays.sort(arr);
    }

    static void quickSort(int[] arr) {
        Arrays.sort(arr);
    }

    static void heapSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) pq.add(x);

        int i = 0;
        while (!pq.isEmpty())
            arr[i++] = pq.poll();
    }

    static void countingSort(int[] arr) {

        int max = Arrays.stream(arr).max().getAsInt();

        int[] count = new int[max + 1];

        for (int x : arr)
            count[x]++;

        int k = 0;

        for (int i = 0; i <= max; i++)
            while (count[i]-- > 0)
                arr[k++] = i;
    }

    static void radixSort(int[] arr) {

        int max = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10)
            counting(arr, exp);
    }

    static void counting(int[] arr, int exp) {

        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i : arr)
            count[(i / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {

            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output,0,arr,0,n);
    }

    static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){

        int[] data={64,25,12,22,11,90,15,100};

        int[] a=data.clone();
        mergeSort(a);
        System.out.print("Merge Sort: ");
        print(a);

        a=data.clone();
        quickSort(a);
        System.out.print("Quick Sort: ");
        print(a);

        a=data.clone();
        heapSort(a);
        System.out.print("Heap Sort: ");
        print(a);

        a=data.clone();
        countingSort(a);
        System.out.print("Counting Sort: ");
        print(a);

        a=data.clone();
        radixSort(a);
        System.out.print("Radix Sort: ");
        print(a);
    }
}
