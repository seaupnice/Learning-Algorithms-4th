# Chapter 2.2 归并排序 #

***




## Contents
* [2-2-1](#2-2-1)
* [2-2-2](#2-2-2)
* [2-2-3](#2-2-3)
* [2-2-4](#2-2-4)
* [2-2-5](#2-2-5)
* [2-2-6](#2-2-6)
* [2-2-7](#2-2-7)
* [2-2-8](#2-2-8)
* [2-2-9](#2-2-9)
* [2-2-10](#2-2-10)
* [2-2-11](#2-2-11)
* [2-2-12](#2-2-12)
* [2-2-13](#2-2-13)
* [2-2-14](#2-2-14)
* [2-2-15](#2-2-15)
* [2-2-16](#2-2-16)
* [2-2-17](#2-2-17)
* [2-2-18](#2-2-18)
* [2-2-19](#2-2-19)


***



### 2-2-1
-----------
Q: 按照本书开头所示轨迹的格式给出原地归并的抽象 merge() 方法是如何将数组 `A E Q S U Y E I N O S T `排序的。

A: 理解归并思想。

|   k    |              a[]                 |
|:------:|:--------------------------------:|
|0       |A   |
|1       |A  E   |
|2       |A  E  E   |
|3       |A  E  E  I   |
|4       |A  E  E  I  N   |
|5       |A  E  E  I  N  O   |
|6       |A  E  E  I  N  O  Q   |
|7       |A  E  E  I  N  O  Q  S   |
|8       |A  E  E  I  N  O  Q  S  S   |
|9       |A  E  E  I  N  O  Q  S  S  T   |
|10      |A  E  E  I  N  O  Q  S  S  T  U   |
|11      |A  E  E  I  N  O  Q  S  S  T  U  Y   |

code[ Test2_1.java ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/seaupnice/Test2_1.java "Markdown")



2-2-2
------
Q: 按照算法 2.4 所示轨迹的格式给出自顶向下的归并排序是如何将数组 `E A S Y Q U E S T I O N `排序的。

A: 通过运行这道题的code,可以理解归并排序是按照**后根遍历**的方式。

|                      |              a[]                    |
|:--------------------:|:-----------------------------------:|
|merge(a, 0, 0, 1)     |A  E  S  Y  Q  U  E  S  T  I  O  N   |
|merge(a, 0, 1, 2)     |A  E  S  Y  Q  U  E  S  T  I  O  N   |
|merge(a, 3, 3, 4)     |A  E  S  Q  Y  U  E  S  T  I  O  N   |
|merge(a, 3, 4, 5)     |A  E  S  Q  U  Y  E  S  T  I  O  N   |
|merge(a, 0, 2, 5)     |A  E  Q  S  U  Y  E  S  T  I  O  N   |
|merge(a, 6, 6, 7)     |A  E  Q  S  U  Y  E  S  T  I  O  N   |
|merge(a, 6, 7, 8)     |A  E  Q  S  U  Y  E  S  T  I  O  N   |
|merge(a, 9, 9, 10)    |A  E  Q  S  U  Y  E  S  T  I  O  N   |
|merge(a, 9, 10, 11)   |A  E  Q  S  U  Y  E  S  T  I  N  O   |
|merge(a, 6, 8, 11)    |A  E  Q  S  U  Y  E  I  N  O  S  T   |
|merge(a, 0, 5, 11)    |A  E  E  I  N  O  Q  S  S  T  U  Y   |

code[ Test2_1.java ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/seaupnice/Test2_1.java "Markdown")



2-2-3
------
Q: 用自底向上的归并排序解答练习 2.2.2。

A:

| sz |                      |              a[]                    |
|:--:|:--------------------:|:-----------------------------------:|
| 1  |merge(a, 0, 0, 1)     |A  E  S  Y  Q  U  E  S  T  I  O  N   |
| 1  |merge(a, 2, 2, 3)     |A  E  S  Y  Q  U  E  S  T  I  O  N   |
| 1  |merge(a, 4, 4, 5)     |A  E  S  Y  Q  U  E  S  T  I  O  N   |
| 1  |merge(a, 6, 6, 7)     |A  E  S  Y  Q  U  E  S  T  I  O  N   |
| 1  |merge(a, 8, 8, 9)     |A  E  S  Y  Q  U  E  S  I  T  O  N   |
| 1  |merge(a, 10, 10, 11)  |A  E  S  Y  Q  U  E  S  I  T  N  O   |
| 2  |merge(a, 0, 1, 3)     |A  E  S  Y  Q  U  E  S  I  T  N  O   |
| 2  |merge(a, 4, 5, 7)     |A  E  S  Y  E  Q  S  U  I  T  N  O   |
| 2  |merge(a, 8, 9, 11)    |A  E  S  Y  E  Q  S  U  I  N  O  T   |
| 4  |merge(a, 0, 3, 7)     |A  E  E  Q  S  S  U  Y  I  N  O  T   |
| 8  |merge(a, 0, 7, 11)    |A  E  E  I  N  O  Q  S  S  T  U  Y   |

code[ Test2_3 ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/learn/MergeBU.java "Markdown")




2-2-4
------
Q: 是否当且仅当两个输入的子数组都有序时原地归并的抽象方法才能得到正确的结果？证明你的结论，或者给出一个反例。

A: 是。 反例比较好给。
证明则需要说明a,b两数组归并到c时，若a中存在一个逆序对，则a无序，然后说明这个逆序对在c数组中依然存在即可。




2-2-5
------
Q: 当输入数组的大小 N=39 时，给出自顶向下和自底向上的归并排序中各次归并子数组的大小及顺序。

A:
自顶向下，画出二叉树后根遍历，只输出结点大小`>=2`的结点。
	2, 3, 2, 5,    2, 3, 2, 5,    10,
	2, 3, 2, 5,    2, 3, 2, 5,    10,    20,
	2, 3, 2, 5,    2, 3, 2, 5,    10,
	2, 3, 2, 5,    2, 2, 4, 9,           19,     39

自底向上，除2计数
39/2=19个2, 19/4=9个4,3, 8,8,8,8,7, 16,16, 32, 39



2-2-6
------
Q: 编写一个程序来计算自顶向下和自底向上的归并排序访问数组的准确次数。使用这个程序将 N=1 至 512 的结果绘成曲线图，并将其和上限 6NlgN 相比较。

A: [话说这样的验证性实验要独立完成还是蛮难的，但是既然有了官方的StdRandom和StdDraw，那么就拿来主义了。]

![avatar](..//picture/1.PNG)

上图中:
1. 红色是MergeBU
2. 蓝色是Merge
3. 黑色是上限`6NlgN`

结论: 对于长度为N的任意数组，自顶向下的归并排序最多需要访问数组`6NlgN`次。每次归并最多访问数组 6N 次( 2N 次用来复制，2N次用来将排序好的元素移动回去，最多比较2N次)
自顶向上.......

code[ Test2_6.java ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/seaupnice/Test2_6.java "Markdown")




2-2-7
------
Q: 证明归并排序的比较次数是单调递增的（即对于 N>0，C(N+1)>C(N)）。

A: 这里证明` C(N+1)>C(N) `，其实就是证明比较次数C(N)，看到这个式子就想到了老师讲的两种方法:1. **Indection(归纳)**, 2. 普通证明。这里温习一下归纳。
```
- Base case: N = 1.
- Inductive hypothesis: C(N) = NlgN.
- Goal: show that C(N+1) = (N+1)lg(N+1)

C(N+1) = 2C((N+1)/2) + N+1                        given
       = 2 [ (N+1)/2 ]lg[ (N+1)/2 ] + N+1         inductive hypothesis
	   = (N+1)[lg(N+1) - 1] + N+1                 algebra
	   = (N+1)lg(N+1)                             QED

```
然后再证明大于就好了。



2-2-8
------
Q: 假设将算法 2.4 修改为：只要 a[mid] <= a[mid+1] 就不调用 merge() 方法，请证明用归并排序处理一个已经有序的数组所需的比较次数是线性级别的。

A: 只要理解了 ` C(N) = 2C( N/2 ) + N ` 就不难得出这种思路实质是一种**剪枝**，得 ` C(N) = 2C( N/2 ) + 1 `且 ` C(1) = 0 `。
下面简单解这个式子:
```
C(N) = 2C( N/2 ) + 1
C(N) = N*C(1) + 1 + 2 + 4......
C(N) = 0 + 1 + 2 + 4......
C(N) = (1 - 2^(lgN))/(1 - 2) = N
```



2-2-9
------
Q: 在库函数中使用 aux[] 这样的静态数组时不妥当的，因为可能会有多个程序同时使用这个类。实现一个不用静态数组的 Merge 类，但也不要将 aux[] 变为 merge() 的局部变量（请见本书的答疑部分）。
提示：可以将辅助数组作为参数传递给递归的 sort() 方法。

A:
```
防止创建新数组成为运行时间的主要部分。
```

code[ Test2_9 ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/learn/Merge.java "Markdown")




***
提高题
---
***



2-2-10
------
Q: 快速归并。实现一个 merge() 方法，按降序将 a[] 的后半部分复制到 aux[]，然后将其归并回 a[] 中。这样就可以去掉内循环中检测某半边是否用尽的代码。注意：这样的排序产生的结果是不稳定的（请见 2.5.1.8 节）。

A: 这里说明下为什么会不稳定：若后半部分有两个元素相等，降序复制会导致不稳定。

```java
private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= mid; i++)
            aux[i] = a[i];

        for (int j = mid + 1; j <= hi; j++)
            aux[j] = a[hi - j + mid + 1];

        int i = lo, j = hi;
        for (int k = lo; k <= hi; k++)
            if (less(aux[j], aux[i])) a[k] = aux[j--];
            else a[k] = aux[i++];
    }
```


2-2-11
------
Q: **改进**。实现 2.2.2 节所述的对归并排序的三项改进：加快小数组的排序速度，检测数组是否已经有序以及通过在递归中交换参数来避免复制。

A:
code[ Test2_11 ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/learn/MergeX.java "Markdown")



2-2-12
------
Q: **次线性的额外空间**。用大小 M 将数组分为 N/M 块（简单起见，设 M 是 N 的约数）。实现一个归并方法，使之所需的额外空间减少到 `max(M, N/M)`：
1. 可以先将一个块看作一个元素，将块的第一个元素作为块的主键，用选择排序将块排序；
2. 遍历数组，将第一块和第二块归并，完成后将第二块和第三块归并，等等。

A:
















