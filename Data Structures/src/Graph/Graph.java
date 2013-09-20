package Graph;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rumesh
 */
public class Graph {

    static void DFT(Vertex st) {
        if (st != null) {

            if (!st.traveld) {
                System.out.println(st.val);
                st.traveld = true;

                if (st.cons.size() > 0) {
                    for (int i = 0; i < st.cons.size(); i++) {
                        //System.out.println("size"+ st.cons.size());
                        //System.out.println("loop :"+ st.val+" : "+i);
                        DFT(st.cons.get(i));

                    }
                }
            }
        } else {
            System.out.println("End of Traversal");
            return;
        }

    }

//    static void BFT(Vertex st) {
//        if (st != null) {
//            if (!st.traveld) {
//                System.out.println(st.val);
//                st.traveld = true;
//
//                for (int i = 0; i < st.cons.size(); i++) {
//                    Vertex tmp = st.cons.get(i);
//                    if (!tmp.traveld) {
//                        System.out.println(tmp.val);
//                        tmp.traveld = true;
//                    }
//
//                }
//
//                for (int i = 0; i < st.cons.size(); i++) {
//                    BFT(st.cons.get(i));
//
//                }
//            } else {
//            }
//            BFT(st.next);
//        } else {
//            //return;
//        }
//    }
    static void BFT(Vertex st) {
        if (st != null) {

            if (!isComplete()) {
                if (!st.traveld) {
                    st.traveld = true;
                    System.out.println(st.val);
                }
                for (int i = 0; i < st.cons.size(); i++) {
                    Vertex t = st.cons.get(i);
                    if (!t.traveld) {
                        t.traveld = true;
                        System.out.println(t.val);
                    }

                }

                for (int i = 0; i < st.cons.size(); i++) {
                    Vertex t = st.cons.get(i);
                    if (!t.traveld) {
                        System.out.println(t.val);
                        t.traveld = true;
                    }
                    for (int j = 0; j < t.cons.size(); j++) {
                        Vertex tp = t.cons.get(j);
                        if (!tp.traveld) {
                            System.out.println(tp.val);
                            tp.traveld = true;
                        }

                    }

                }


                BFT(st.next);

            }
        } else {
        }
    }

    static void makeUnvisit(Vertex starting) {
        if (starting != null) {
            starting.traveld = false;
            makeUnvisit(starting.next);
        }

    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Vertex v6 = new Vertex("6");

        v0.cons.add(v1);
        v0.cons.add(v3);
        v0.next = v1;

        v1.cons.add(v0);
        v1.cons.add(v2);
        v1.next = v2;

        v2.cons.add(v1);
        v2.cons.add(v3);
        v2.cons.add(v4);
        v2.cons.add(v5);
        v2.next = v3;

        v3.cons.add(v0);
        v3.cons.add(v2);
        v3.cons.add(v6);
        v3.next = v4;

        v4.cons.add(v2);
        v4.cons.add(v5);
        v4.next = v5;

        v5.cons.add(v2);
        v5.cons.add(v4);
        v5.next = v6;

        v6.cons.add(v3);

//        System.out.println("DFT :Start Travelling from 0");
//        DFT(v0);

        makeUnvisit(v0);
        System.out.println("Start Travelling from 0");
        BFT(v0);

    }

    private static boolean isComplete(Vertex s) {
        boolean b = true;
        while (s != null) {            
            b &= s.traveld;
            s=s.next;
        }
        
        return b;
    }
    
    static boolean isComplete(){
        return false;
    }
}

class Vertex {

    ArrayList<Vertex> cons;
    Vertex next;
    boolean traveld;
    String val;

    Vertex() {
        traveld = false;
        next = null;
        cons = new ArrayList<Vertex>();
        val = "";
    }

    Vertex(String value) {
        traveld = false;
        next = null;
        cons = new ArrayList<Vertex>();
        val = value;
    }
}