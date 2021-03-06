/*
 *  代码是两道题的代码
 *  test2_1和test2_2
 *  注释已经标明
 *
 *  test2_1 input file in.txt is
 *  A E Q S U Y E I N O S T
 *
 *  test2_2 input file in.txt is
 *  E A S Y Q U E S T I O N
 * */

package main.com.seaupnice;

import main.com.learn.StdIn;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test2_1 {
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
    //自顶向下，分治思想
    private static void sort(Comparable[] a, int lo, int hi){
        // 只有一个元素时，序列有序，作为递归出口
        if(hi <= lo){  return; }
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);

        ///  test2_2的题解
        System.out.print("|merge(a, "+lo+", "+mid+", "+hi+")     |");
        show(a);
        ///  test2_2的题解 end
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        Comparable[] aux = new Comparable[a.length];
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++){  aux[k] = a[k]; }
        for(int k = lo; k <= hi; k++){
            if(i > mid)     a[k] = aux[j++];
            else if(j > hi)     a[k] = aux[i++];
            else if(less(aux[j], aux[i]))      a[k] = aux[j++];
            else        a[k] = aux[i++];
            // test1_1的题解
            //show(a, k);
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + "  ");
        }
        System.out.println(" |");
    }
    private static void show(Comparable[] a, int k){
        System.out.print("| ");
        for(int i = 0; i <= k; i++){
            System.out.print(a[i] + "  ");
        }
        System.out.println(" |");
    }
    public static void main(String[] args){
        try{
            FileInputStream input = new FileInputStream("src\\main\\com\\in.txt");
            System.setIn(input);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String[] a = StdIn.readAllStrings();

        // test2_1的题解
        //Test2_1.merge(a, 0, (a.length-1)/2, a.length-1);


        // test2_2的题解
        Test2_1.sort(a);
    }
}
