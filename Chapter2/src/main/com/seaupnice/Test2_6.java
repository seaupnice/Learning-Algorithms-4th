/*
* 这道题目没有输入文件
* 简单测试即可
* */

package main.com.seaupnice;

import main.com.learn.Merge;
import main.com.learn.MergeBU;
import main.com.learn.StdDraw;
import main.com.learn.StdRandom;

public class Test2_6 {
    public static void main(String[] args){
        int N = 512;
        StdDraw.setXscale(0, N+20);
        StdDraw.setYscale(0, N*N+50);
        StdDraw.setPenRadius(.01);
        for(int i = 1; i <= N; i++){
            Comparable[] a = new Comparable[i];

            for(int j = 0; j < i; j++){
                a[j] = StdRandom.uniform(50);
            }

            int ans1 = MergeBU.visitarray(a);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, ans1);

            int ans2 = Merge.visitarray(a);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(i, ans2);

            double ans3 = (6 * i * (Math.log10(i) / Math.log10(2)));
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(i, ans3);
        }
    }
}
