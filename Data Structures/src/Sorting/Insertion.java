/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author Rumesh
 */
public class Insertion {

    public static void main(String[] args) {
        int[] x = {5,13,7,6,4,9};
        insertion2(x);
    }

    
    static void insertion(int[] x){
        for (int i = 1; i < x.length; i++) {
            int j=i;
            while(j>0&&x[j]<x[j-1] ){
                int t = x[j-1];
                x[j-1]=x[j];
                x[j]=t;
                j--;
            }
            
        }
        
        print(x);
    }
    
    static void insertion2(int[] x){
        for (int i = 1; i < x.length; i++) {
            for (int j = i; j > 0; j--) {
                if(x[j]<x[j-1]){
                    int t=x[j];
                    x[j]=x[j-1];
                    x[j-1]=t;
                }else{
                    break;
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
