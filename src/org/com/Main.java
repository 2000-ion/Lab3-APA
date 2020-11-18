package org.com;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int [] test1 = {1 , 901, 77, 810, 10, 901, 44, 223, 467, 900, 345, 221, 9023};

        Sort sort = null;
        int n = 1;

        long start = 0l, finish = 0l;

        while(n != 4){
            System.out.println(
                    "Introdu 1 pentru quicksort, 2 pentru megesort  3 pentru radixsort si 4 sau alt caracter"+
                            " pentru iesire din program: ");
            n = new Scanner(System.in).nextInt();

            switch(n){
                case 1:
                    sort = new QuickSort();
                    break;
                case 2:
                    sort = new MergeSort();
                    break;
                case 3:
                    sort = new RadixSort();
                    break;
                default:
                    System.exit(0);
            }

            start = System.nanoTime();
            sort.sort(test1);
            finish = System.nanoTime();


            for(int a: test1){
                System.out.print(String.format("%d ", a));
            }

            System.out.println(String.format("\nTimpul de executie: %d milisecunde", (finish-start)/1000  ));

        }






    }
}
