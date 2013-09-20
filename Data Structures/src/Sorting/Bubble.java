/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author Rumesh
 */
public class Bubble {
    
    public static void main(String[] args) {
        int[] x = {5,13,7,6,4,9};
        //bubbleBack(x);
        bubbleFront(x);
    }
    
    static void bubbleBack(int[] x){
        for (int i =0; i <x.length-1; i++) {
            for (int j = x.length-1; j > i; j--) {
                if(x[j-1]>x[j]){
                    int t = x[j];
                    x[j]=x[j-1];
                    x[j-1]=t;
                }
            }
            
        }
        print(x);
    }
    
    static void bubbleFront(int[] x){
        for (int i = 0; i < x.length-1; i++) {
            for (int j = i; j < x.length-1; j++) {
                if(x[j]>x[j+1]){
                    int t = x[j];
                    x[j]=x[j+1];
                    x[j+1]=t;
                }
            }
            
        }
        print(x);
    }
    
    static void print(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ,");
        }
        System.out.println("");
    }
    
}
