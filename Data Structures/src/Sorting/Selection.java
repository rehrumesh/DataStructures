/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author Rumesh
 */
public class Selection {

    public static void main(String[] args) {
        int[] x = {5, 13, 7, 6, 4, 9};

        selection2(x, 0, x.length - 1);
        print(x);

    }

    static void print(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ,");
        }
        System.out.println("");
    }

    static void selection1(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            int min = i;
            for (int j = i; j < x.length; j++) {
                if (x[j] <= x[min]) {
                    min = j;
                }
            }
            int t = x[i];
            x[i] = x[min];
            x[min] = t;
        }

        print(x);
    }

    static void selection2(int[] x, int first, int last) {
        if (first < last) {
            int minIndex = first;
            for (int i = first; i <= last; i++) {
                if (x[i] < x[minIndex]) {
                    minIndex = i;
                }
            }
            int i = x[first];
            x[first] = x[minIndex];
            x[minIndex] = i;
            selection2(x, first + 1, last);
        }
    }
}
