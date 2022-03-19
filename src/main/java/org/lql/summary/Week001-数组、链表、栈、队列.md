## 1、 数组原理及实战应用

### 1.1 概述

```markdown
# 属性
1. 基本特点： 支持随机访问
2. 数组关键： 索引与寻址
3. 数组在内存中的空间时连续的
```

### 1.2 时间复杂度

| 操作类型            | 时间复杂度 |
| ------------------- | ---------- |
| LookUp              | O(1)       |
| Insert              | O(n)       |
| Delete              | O(n)       |
| Append(push back)   | O(1)       |
| Prepend(push front) | O(n)       |

### 1.3 对应习题

1、[88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

2、[26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

3、[283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

## 2、 设计变长数组

### 2.1 概述

```markdown
# 需要具有的功能
1、 支持索引与随机访问
2、 需要的连续空间大小
3、 空间不足
4、 空间冗余

# 需要提供的操作接口
1、 new
2、 get(i) 边界检查
3、 set(i,val) 边界检查
4、 push_back(val)
5、 pop_back

# 分析
· 初始：空数组、分配常数空间、size、capacity
· push_back: 空间不足，重新申请2倍大小连续空间，拷贝到新空间，释放旧空间
· pop_back：若空间利用率(size/capacity) < 0.25 释放一半空间

· 均摊O(1)
· 空数组连续插入n个元素，总插入/拷贝次数 n + n/2 + n/4 + ... < 2n
· 一次扩容到下一次释放，至少需要删除 n - 2n*0.25 = 0.25n

# java -> Arrayist
```

## 3、 链表原理及实战应用

### 3.1 概述

```markdown
# 边界保护
1. head结点
2. tail结点
```

### 3.2 时间复杂度

| 操作                | 时间复杂度 |
| ------------------- | ---------- |
| LookUp              | O(n)       |
| Insert              | O(1)       |
| Delete              | O(1)       |
| Append(push back)   | O(1)       |
| Prepend(push front) | O(1)       |



## 4、 链表实战应用

### 4.1 实战题目

[206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

[25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

[邻值查找](https://www.acwing.com/problem/content/description/138/)

[141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

[142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

### 4.2 链表操作技巧

```markdown
1. 快慢指针-判断链表是否成环
2. 保护结点-确定链表的访问入口
3. null-链表的边界，操作时需注意
```



## 5、 栈、队列与常见变形及实战应用

### 5.1 概述

```markdown
# 栈-Stack
1. Last In First Out / First In Last Out

# 队列-Queue
1. Last In Last Out / First In First Out

# 双端队列-Deque

# 优先队列-Priority Queue

# source code
1. Stack
2. Queue Dequq
3. PriorityQueue
```

### 5.2 时间复杂度

| 操作           | 栈-Stack | 队列-Queue | 双端队列-Deque | 优先队列-Priority Queue |
| -------------- | -------- | ---------- | -------------- | ----------------------- |
| Push           | O(1)     | O(1)       |                |                         |
| Pop            | O(1)     | O(1)       |                |                         |
| Assess         | O(1)     | O(1)       | O(1)           | O(1)                    |
| Push-Head      |          |            | O(1)           |                         |
| Push-Back      |          |            | O(1)           |                         |
| Pop-Head       |          |            | O(1)           |                         |
| Pop-Back       |          |            | O(1)           |                         |
| Priority -Push |          |            |                | O(logn)                 |
| Priority -Pop  |          |            |                | O(logn)                 |



## 6、 表达式求值系列问题

### 6.1 概述

```markdown
# op - 运算符
# A B 另外的表达式
1. 前缀表达式
· op A B 
· * 3 +1 2
· 波兰式

2. 后缀表达式
· A B op
· 1 2 + 3 *
· 逆波兰式

3. 中缀表达式
· 3 * (1 + 2)

· 中缀式转后缀式求解
```



## 7、 单调栈及实战应用

```markdown
for每个元素
	while(栈顶与新元素不满足单调性){
		出栈
		更新答案
		累加宽度
	}
	入栈
```



## 8、 单调队列及实战应用



