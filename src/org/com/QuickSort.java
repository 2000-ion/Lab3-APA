package org.com;

public class QuickSort implements Sort {
    private int partition(int[] arr, int s, int e)
    {
        int pivot = arr[e];
        int pIndex = s;

        for(int i = s ;i < e; i++)
        {
            if(arr[i]<pivot)
            {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }

        int temp = arr[e];
        arr[e] = arr[pIndex];
        arr[pIndex] = temp;

        return pIndex;
    }

    private void quickSort(int []arr, int s, int e)
    {
        if(s<e)
        {
            int p = partition(arr,s, e);
            quickSort(arr, s, (p-1));
            quickSort(arr, (p+1), e);
        }
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
}
