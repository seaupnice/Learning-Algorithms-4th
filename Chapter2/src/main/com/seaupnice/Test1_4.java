package main.com.seaupnice;

import main.com.learn.StdIn;
import main.com.learn.Stopwatch;

import java.io.*;

public class Test1_4 {
    public static void sort(Comparable[] a){
        int N = a.length;
        show(a);
        for(int i = 0, j; i < N; i++){
            for(j = i; j > 0 && less(a[j], a[j-1]); j--){
                exch(a, j, j-1);
            }
            System.out.print("| "+ i + " |"+ j + " |" ); show(a);
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i]; a[i] = a[j]; a[j] = tmp;
    }
    private static boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        try{
            FileInputStream input = new FileInputStream("src\\main\\com\\1_4.txt");
            System.setIn(input);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        String[] a = StdIn.readAllStrings();
        sort(a);
        //Stopwatch timer = new Stopwatch();
        //sort(a);
        //double time = timer.elapsedTime();
        //System.out.println("sort spend  " + time + "  seconds.");

        assert isSorted(a);
        show(a);
    }
}
