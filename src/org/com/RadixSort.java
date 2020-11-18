package org.com;

public class RadixSort implements Sort {

    private int getMax(int[] arr, int size)
    {
        int max = arr[0];
        for (int i = 1; i < size; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    private void countingSort(int[] arr, int size, int div)
    {
        int[] output = new int[size];
        int [] count = new int[10];
        count[0] = 0;

        for (int i = 0; i < size; i++)
            count[ (arr[i]/div)%10 ]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = size - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/div)%10 ] - 1] = arr[i];
            count[ (arr[i]/div)%10 ]--;
        }

        for (int i = 0; i < size; i++)
            arr[i] = output[i];
    }


    private void radixSort(int[] arr, int size)
    {
        int m = getMax(arr, size);
        for (int div = 1; m/div > 0; div *= 10)
            countingSort(arr, size, div);
    }

    @Override
    public void sort(int[] arr) {
        radixSort(arr, arr.length);
    }
}
