# Chapter 2 #

***

## Section 2.1  初级排序算法##



## Contents
* [2-1-1](#2-1-1)
* [2-1-2](#2-1-2)
* [2-1-3](#2-1-3)
* [2-1-4](#2-1-4)
* [2-1-5](#2-1-5)
* [2-1-6](#2-1-6)
* [2-1-7](#2-1-7)
* [2-1-8](#2-1-8)
* [2-1-9](#2-1-9)
* [2-1-10](#2-1-10)
* [2-1-11](#2-1-11)
* [2-1-12](#2-1-12)
* [2-1-13](#2-1-13)
* [2-1-14](#2-1-14)
* [2-1-15](#2-1-15)
* [2-1-16](#2-1-16)
* [2-1-17](#2-1-17)
* [2-1-18](#2-1-18)
* [2-1-19](#2-1-19)



### 2-1-1
-----------
Q: 按照算法2.1所示轨迹的格式给出选择排序是如何将数组`E A S Y Q U E S T I O N`排序的。

A:

|i      |min    |              a[]             |
|:-----:|-----:|--------------------------------|
|   |    |E A S Y Q U E S T I O N |
| 0 |1   |A E S Y Q U E S T I O N |
| 1 |1   |A E S Y Q U E S T I O N |
| 2 |6   |A E E Y Q U S S T I O N |
| 3 |9   |A E E I Q U S S T Y O N |
| 4 |11  |A E E I N U S S T Y O Q |
| 5 |10  |A E E I N O S S T Y U Q |
| 6 |11  |A E E I N O Q S T Y U S |
| 7 |7   |A E E I N O Q S T Y U S |
| 8 |11  |A E E I N O Q S S Y U T |
| 9 |11  |A E E I N O Q S S T U Y |
| 10 |10 |A E E I N O Q S S T U Y |
| 11 |11 |A E E I N O Q S S T U Y |
|    |   |A E E I N O Q S S T U Y |

code[ Test1_1.java ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/seaupnice/Test1_1.java "Markdown")


2-1-2
------
Q: 在选择排序中，一个元素最多可能被交换多少次？(一个元素)平均可能会被交换多少次？

A：最多被交换n次。平均每个元素被交换一次。
最多交换次数可以构造一个序列（max, a1,.....an），这样可以使当前元素与每个元素进行交换。


2-1-3
------
Q: 构造一个含有N个元素的数组，使选择排序运行过程中` a[j] < a[min] `(由此min会不断更新)成功的次数最大。

A: 序列是逆序(即`a1 > a2 > ....... > an`)。


2-1-4
------
Q: 按照算法2.2所示轨迹的格式给出插入排序是如何将数组`E A S Y Q U E S T I O N`排序的。

A:

|i      |min    |              a[]             |
|:-----:|-----:|--------------------------------|
|    |  |E A S Y Q U E S T I O N |
| 0  |0 |E A S Y Q U E S T I O N |
| 1  |0 |A E S Y Q U E S T I O N |
| 2  |2 |A E S Y Q U E S T I O N |
| 3  |3 |A E S Y Q U E S T I O N |
| 4  |2 |A E Q S Y U E S T I O N |
| 5  |4 |A E Q S U Y E S T I O N |
| 6  |2 |A E E Q S U Y S T I O N |
| 7  |5 |A E E Q S S U Y T I O N |
| 8  |6 |A E E Q S S T U Y I O N |
| 9  |3 |A E E I Q S S T U Y O N |
| 10 |4 |A E E I O Q S S T U Y N |
| 11 |4 |A E E I N O Q S S T U Y |
|    |  |A E E I N O Q S S T U Y |

code[ Test1_4.java ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/seaupnice/Test1_4.java "Markdown")


2-1-5
------
Q: 构造一个含有N个元素的数组，使插入排序运行过程中内循环(`for`)的两个判断结果总是`false`；

A: 插入排序是：当前元素左边的序列是有序的，将当前元素插入到左边的序列，使包括当前元素的左边的序列有序。故只要保证序列是**逆序**的，即可保证每个内循环中当前元素在其左侧是最小的，故内循环的每个判断是`false`。
书上命题C给出了说明：插入排序需要的交换操作和数组中倒置的数量相同，需要的比较次数大于等于倒置的数量，小于等于倒置的数量加数组的大小减一。


2-1-6
------
Q: 在所有的主键都相同时，选择排序和插入排序谁更快？

A: 插入排序更快。
==插入排序(最好的情况)：0次交换、N次比较==。
==选择排序：N次交换、$x^2$次比较==。
（代码实验：1000个1，插入排序0s, 选择排序0.033s。）


2-1-7
------
Q: 对于逆序数组，选择排序和插入排序谁更快？

A: 选择排序更快。
==插入排序(最坏的情况)：~ $x^2/2$次交换、~ $x^2/2$次比较==。
==选择排序：N次交换、$x^2$次比较==。


2-1-8
------
Q: 假设元素只可能有三种值，使用插入排序处理这样一个随机数组的运行时间是线性的还是平方级别的？或是介于两者之间。

A:


2-1-9
------
Q: 按照算法2.3所示的轨迹的格式给出希尔排序是如何将数组`E A S Y S H E L L S O R T Q U E S T I O N`排序的。

A:

|i      |min    |              a[]             |
|:-----:|-----:|--------------------------------|
|    |   |E A S Y S H E L L S O R T Q U E S T I O N |
| 13 |13 |E A S Y S H E L L S O R T Q U E S T I O N |
| 14 |14 |E A S Y S H E L L S O R T Q U E S T I O N |
| 15 |2  |E A E Y S H E L L S O R T Q U S S T I O N |
| 16 |3  |E A E S S H E L L S O R T Q U S Y T I O N |
| 17 |17 |E A E S S H E L L S O R T Q U S Y T I O N |
| 18 |18 |E A E S S H E L L S O R T Q U S Y T I O N |
| 19 |19 |E A E S S H E L L S O R T Q U S Y T I O N |
| 20 |20 |E A E S S H E L L S O R T Q U S Y T I O N |
|    |   |E A E S S H E L L S O R T Q U S Y T I O N |
| 4  |4  |E A E S S H E L L S O R T Q U S Y T I O N |
| 5  |5  |E A E S S H E L L S O R T Q U S Y T I O N |
| 6  |6  |E A E S S H E L L S O R T Q U S Y T I O N |
| 7  |3  |E A E L S H E S L S O R T Q U S Y T I O N |
| 8  |4  |E A E L L H E S S S O R T Q U S Y T I O N |
| 9  |9  |E A E L L H E S S S O R T Q U S Y T I O N |
| 10 |10 |E A E L L H E S S S O R T Q U S Y T I O N |
| 11 |7  |E A E L L H E R S S O S T Q U S Y T I O N |
| 12 |12 |E A E L L H E R S S O S T Q U S Y T I O N |
| 13 |9  |E A E L L H E R S Q O S T S U S Y T I O N |
| 14 |14 |E A E L L H E R S Q O S T S U S Y T I O N |
| 15 |15 |E A E L L H E R S Q O S T S U S Y T I O N |
| 16 |16 |E A E L L H E R S Q O S T S U S Y T I O N |
| 17 |17 |E A E L L H E R S Q O S T S U S Y T I O N |
| 18 |10 |E A E L L H E R S Q I S T S O S Y T U O N |
| 19 |7  |E A E L L H E O S Q I R T S O S Y T U S N |
| 20 |8  |E A E L L H E O N Q I R S S O S T T U S Y |
|    |   |E A E L L H E O N Q I R S S O S T T U S Y |
| 1  |0  |A E E L L H E O N Q I R S S O S T T U S Y |
| 2  |2  |A E E L L H E O N Q I R S S O S T T U S Y |
| 3  |3  |A E E L L H E O N Q I R S S O S T T U S Y |
| 4  |4  |A E E L L H E O N Q I R S S O S T T U S Y |
| 5  |3  |A E E H L L E O N Q I R S S O S T T U S Y |
| 6  |3  |A E E E H L L O N Q I R S S O S T T U S Y |
| 7  |7  |A E E E H L L O N Q I R S S O S T T U S Y |
| 8  |7  |A E E E H L L N O Q I R S S O S T T U S Y |
| 9  |9  |A E E E H L L N O Q I R S S O S T T U S Y |
| 10 |5  |A E E E H I L L N O Q R S S O S T T U S Y |
| 11 |11 |A E E E H I L L N O Q R S S O S T T U S Y |
| 12 |12 |A E E E H I L L N O Q R S S O S T T U S Y |
| 13 |13 |A E E E H I L L N O Q R S S O S T T U S Y |
| 14 |10 |A E E E H I L L N O O Q R S S S T T U S Y |
| 15 |15 |A E E E H I L L N O O Q R S S S T T U S Y |
| 16 |16 |A E E E H I L L N O O Q R S S S T T U S Y |
| 17 |17 |A E E E H I L L N O O Q R S S S T T U S Y |
| 18 |18 |A E E E H I L L N O O Q R S S S T T U S Y |
| 19 |16 |A E E E H I L L N O O Q R S S S S T T U Y |
| 20 |20 |A E E E H I L L N O O Q R S S S S T T U Y |
|    |   |A E E E H I L L N O O Q R S S S S T T U Y |
|    |   |A E E E H I L L N O O Q R S S S S T T U Y |

code[ Test1_9.java ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/seaupnice/Test1_9.java "Markdown")


2-1-10
------
Q: 在希尔排序中为什么在实现h有序时不使用选择排序。

A: 希尔排序高效的原因是它权衡了子数组的规模和有序性：排序之初，各个子数组都很短，排序之后子数组都是部分有序的，这两种情况都很适合插入排序。

2-1-11
------
Q: 将希尔排序中实时计算递增序列改为预先计算并存储在一个数组中。

A: 了解希尔排序的递增序列。这里放出主函数。

```java
    public static void sort(Comparable[] a){
        int N = a.length;

        /*******************/
        //求h数组
        //h[]数组的个数  由h=3*h+1得
        int num_n = (int)Math.ceil( Math.log(N) / Math.log(3) );
        // +1防止越界
        int[] h = new int[num_n+1];
        h[0] = 1;
        for(int i = 1; i < num_n; i++){
            h[i] = h[i-1]*3 + 1;
        }
        /*******************/

        for(int i = num_n-1; i >= 0; i--){
            //将数组变为h[i]有序
            for(int j = h[i]; j < N; j++){
                //将a[j]插入a[j-h[i]], a[j-2*h[i]]......
                for(int k = j; k >= h[i] && less(a[k], a[k-h[i]]); k-=h[i]){
                    exch(a, k, k-h[i]);
                }
            }
        }
    }
```

code[ Test1_11.java ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/seaupnice/Test1_11.java "Markdown")


2-1-12
------
Q: 令希尔排序打印出递增序列的每个元素所带来的比较次数和数组大小的比值。编写一个测试用例对随机 Double 数组进行希尔排序，验证该值是一个小常数，数组大小按照 10 的幂次递增，不小于 100。

A: 验证性实验，目的可能是向证明希尔排序**不同增量**思想的优秀吧(手动滑稽)。
这里用到了java计数的技巧`Integer count = mp.get(h);` `mp.put(h, count == null ? 1 : count+1);`

```java
    public static void sort(Comparable[] a){
        int N = a.length;
        Map<Comparable, Integer> mp = new HashMap<>(100);
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        while(h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
                    /****************************/
                    // the function is count number.
                    Integer count = mp.get(h);
                    mp.put(h, count == null ? 1 : count+1);
                    /*****************************/
                    Test1_12.exch(a, j, j - h);
                }
            }
            h = h / 3;
        }

        assert Test1_12.isSorted(a);
        ///show answer
        for(Map.Entry<Comparable, Integer> entry : mp.entrySet()){
            System.out.println("h =  "+entry.getKey()+ "      比值 =  " + entry.getValue()*1.0/N);
        }
    }
```

code[ Test1_12.java ](https://github.com/seaupnice/Learning-Algorithms-4th/blob/master/Chapter2/src/main/com/seaupnice/Test1_12.java "Markdown")


***
提高题
----
***


2-1-13
------
Q: **纸牌排序** 说说你会如何将一副扑克牌按花色排序（花色排序是黑桃、红桃、梅花和方片），限制条件是所有牌都是** 背面朝上排成++一列++ **，而你一次只能翻看两张牌或者交换两张牌（保持背面朝上）。

A: 明显的排序问题，问题需要对相邻的两个元素排序。自然想到了插入排序，但是插入排序是当前元素之前的部分需要有序，然后将当前元素插入到之前的序列，故与此问题不符。
故需要对插入排序稍作改动，每次将最大的数插入到有序端，然后保证未排序的序列的数一定小于有序序列的数，这样可以保证与当前元素交换的元素的位置是已知的(这个位置是与有序序列相连的未排序序列的元素)。说了这么多其实就是**冒泡排序**。
由此题可以对比插入排序和冒泡排序，感觉二者有着很迷的关系：插入排序将当前元素(未排序)移动到有序序列，冒泡排序将(未排序)最大元素移动到有序序列。
```
举个例子： 3 7 2 1 4 5 (随便举得)
2 1 4 5 7 3 --> 1 4 5 7 3 2 -->1 5 7 3 2 4 --> 1 7 3 2 4 5 --> 1 3 2 4 5 7
上面是第一轮排序，将最大值移动到最右端，下面在交换牌的时候，将最大值移动到倒数第二位。
.........
```

```java
//冒泡排序
for i(0) : a.length - 1
	for j(0) : a.length - 1 - i
		if(a[j] > a[j+1])
			swap(a[j], a[j+1])
```
因为题目限制条件和水平有限，未能想到更优算法，如果有聚聚有更好想法，欢迎随意Issues。


2-1-14
------
Q: **出列排序** 说说你会如何将一副扑克牌排序，限制条件是只能查看最上面的两张牌，交换最上面的两张牌，或是将最上面的一张牌放到这摞牌的最下面。

A: 与上题相似，冒泡排序，比较最上面的两张牌，小的放到最下面，这样的规则下，每轮进行`n-1`次后首部序列会有序，然后再将序列循环左移一位
```
举个例子： 3 7 2 1 4 5 (随便举得)
7 2 1 4 5 3 --> 7 1 4 5 3 2 --> 7 4 5 3 2 1 --> 7 5 3 2 1 4 --> 7 3 2 1 4 5
--> 3 2 1 4 5 7
3 1 4 5 7 2 --> 3 4 5 7 2 1 --> 4 5 7 2 1 3 --> 5 7 2 1 3 4 --> 7 2 1 3 4 5
--> 2 1 3 4 5 7
........
```

```
//实现用链表要优秀一些
for i : a.length - 1
	for j : a.length - 1
		if node_front >= node[1]
			link(node_front , node[2])  //node[2] = node_front ->next
			link(node_rear , node[1])   // node[1] = rear
		else
			swap(node_front , node[2])
			link(node_front , node[2])
			link(node_rear , node[1])
```











