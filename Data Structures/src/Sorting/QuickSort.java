/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author Rumesh
 */
public class QuickSort {

    public static void main(String[] args) throws Exception {
        int[] x = {8, 53, 42, 67, 99, 12};
        printArray(x);
        quick(x, 0, x.length - 1);;
        printArray(x);
    }

    static void quick(int[] x, int first, int last) throws Exception {
        if (first < last) {
            int pivotValue = x[first];
            partition(x, first, last);
            int pivotIndex = getIndex(x, pivotValue);
            quick(x, first, pivotIndex - 1);
            quick(x, pivotIndex + 1, last);
        }
    }

    static int partition(int[] x, int first, int last) throws Exception {
        int lbIndex = first;
        int a = x[lbIndex];
        int up = last;
        int down = first;

        //step 1
        boolean tt = true;
        asd:
        //while (tt) {
        while(up>down) {
            System.out.println("-");
            while (a >= x[down] && down <= last) {
                System.out.println("*");
                down++;
            }

            //step2

            while (a < x[up] && up >= first) {
                System.out.println("+");
                up--;
            }

            //step3

            System.out.println(up + "  " + down);
            if (up > down) {
                System.out.println("if");
                int t = x[up];
                x[up] = x[down];
                x[down] = t;

            } /*else {
                System.out.println("else");
                tt=false;
                return 0;*/
                
            }
        
        int t = x[up];
        x[up] = x[lbIndex];
        x[lbIndex] = t;
        return 0;
       }

        

    

    static void printArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + ", ");
        }
        System.out.println();
    }

    static int getIndex(int[] x, int value) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == value) {
                return i;
            }

        }
        return 0;
    }
}
