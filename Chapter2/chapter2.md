## Chapter 2 ##

### Section 2.1 ###

[TOC]

#### 2.1.1
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

code[ Test1_1.java ](https://github.com/younghz/Markdown "Markdown")


#### 2.1.2
Q: 在选择排序中，一个元素最多可能被交换多少次？(一个元素)平均可能会被交换多少次？

A：最多被交换n次。平均每个元素被交换一次。
最多交换次数可以构造一个序列（max, a1,.....an），这样可以使当前元素与每个元素进行交换。


#### 2.1.3
Q: 构造一个含有N个元素的数组，使选择排序运行过程中` a[j] < a[min] `(由此min会不断更新)成功的次数最大。

A: 序列是逆序(即`a1 > a2 > ....... > an`)。


#### 2.1.4
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

code[ Test1_4.java ](https://github.com/younghz/Markdown "Markdown")


#### 2.1.5
Q: 构造一个含有N个元素的数组，使插入排序运行过程中内循环(`for`)的两个判断结果总是`false`；

A: 插入排序是：当前元素左边的序列是有序的，将当前元素插入到左边的序列，使包括当前元素的左边的序列有序。故只要保证序列是**逆序**的，即可保证每个内循环中当前元素在其左侧是最小的，故内循环的每个判断是`false`。
书上命题C给出了说明：插入排序需要的交换操作和数组中倒置的数量相同，需要的比较次数大于等于倒置的数量，小于等于倒置的数量加数组的大小减一。


#### 2.1.6
Q: 在所有的主键都相同时，选择排序和插入排序谁更快？

A: 插入排序更快。
==插入排序(最好的情况)：0次交换、N次比较==。
==选择排序：N次交换、$x^2$次比较==。
（代码实验：1000个1，插入排序0s, 选择排序0.033s。）


#### 2.1.7
Q: 对于逆序数组，选择排序和插入排序谁更快？

A: 选择排序更快。
==插入排序(最坏的情况)：~ $x^2/2$次交换、~ $x^2/2$次比较==。
==选择排序：N次交换、$x^2$次比较==。


#### 2.1.8
Q: 假设元素只可能有三种值，使用插入排序处理这样一个随机数组的运行时间是线性的还是平方级别的？或是介于两者之间。

A:


#### 2.1.9
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

















