package org.com;

public class MergeSort implements Sort {


    private void merge(int []arr, int l, int m, int r, int size)
    {
        int i = l;
        int j = m + 1;
        int k = l;


        int []temp = new int[size];

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            }
            else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i <= m) {
            temp[k] = arr[i];
            i++;
            k++;
        }


        while (j <= r) {
            temp[k] = arr[j];
            j++;
            k++;
        }


        for (int p = l; p <= r; p++) {
            arr[p] = temp[p];
        }
    }


    private void mergeSort(int[] arr, int l, int r, int size)
    {
        if (l < r) {

            int m = (l + r) / 2;


            mergeSort(arr, l, m, size);
            mergeSort(arr, m + 1, r, size);


            merge(arr, l, m, r, size);
        }
    }


    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0,arr.length-1, arr.length);
    }
}
