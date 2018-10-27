/*
*  input file in.txt is
*  A E Q S U Y E I N O S T
* */
package main.com.learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Merge {
    private static int count;
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    //自顶向下，分治思想
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi <= lo){  return; }
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
            //count+=2;
        }
        for(int k = lo; k <= hi; k++){
            if(i > mid)     a[k] = aux[j++];
            else if(j > hi)     a[k] = aux[i++];
            else if(less(aux[j], aux[i])){
                a[k] = aux[j++];
                //count+=2;
            }
            else{
                a[k] = aux[i++];
                //count+=2;
            }
            //count+=2;
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    public static int visitarray(Comparable[] a){
        count = 0;
        sort(a);
        return count;
    }
    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + "  ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        try{
            FileInputStream input = new FileInputStream("src\\main\\com\\in.txt");
            System.setIn(input);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        Merge.show(a);
    }

}
