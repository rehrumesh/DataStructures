/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author Rumesh
 */
public class Shell {

    public static void main(String[] args) {
        int[] x = {5, 13, 7, 6, 4, 9};

        int incr = x.length / 2;
        while (incr > 0) {
            for (int index1 = incr+1; index1 < x.length; index1++) {
                int index2=index1-incr;
                while(index2>0){
                    if(x[index2]>x[index2-incr]){
                        int t =x[index2];
                        x[index2]=x[index2-incr];
                        x[index2-incr] = t;
                        index2=index2-incr;
                    }else{
                        index2=0;
                        
                    }
                }
                
            }
            incr=incr/2;
        }
        
        print(x);
    }
//for (index1=incr+1;index1<Arraysize; ++index1
//Index2=index1-incr
//While index2>=0
//If (Element[index2] > Element[index2-incr]
//swap(Element(index2,Element[index2-incr])
//Index2=index2-incr
//else
//Index2=0
//Incr=incr/2

    static void print(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ,");
        }
        System.out.println("");
    }
}
