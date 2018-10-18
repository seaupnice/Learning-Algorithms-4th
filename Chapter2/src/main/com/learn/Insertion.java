package main.com.learn;
import java.io.*;

public class Insertion {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 1; i < N; i++){
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
                exch(a, j, j-1);
            }
        }
    }
    // v < w ?
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
            FileInputStream input = new FileInputStream("src\\main\\com\\in.txt");
            System.setIn(input);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        String[] a = StdIn.readAllStrings();

        Stopwatch timer = new Stopwatch();
        Insertion.sort(a);
        double time = timer.elapsedTime();
        System.out.println("sort spend  " + time + "  seconds.");

        assert isSorted(a);
        //show(a);
    }
}
