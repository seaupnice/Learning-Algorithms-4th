package main.com.seaupnice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import main.com.learn.StdIn;

public class Test1_1 {
    public static void sort(Comparable[] a){
        int N = a.length;
        show(a);
        for(int i = 0; i < N; i++){
            int min = i;
            for(int j = i+1; j < N; j++){
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
            System.out.print("| "+ i + " |"+min + " |"); show(a);
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }
    public static void main(String[] args){
        try{
            FileInputStream input = new FileInputStream("src\\main\\com\\1_1.txt");
            System.setIn(input);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
