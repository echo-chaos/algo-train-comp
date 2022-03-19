package org.lql.week10;

/**
 * @author: lql
 * @date: 2022/3/17 21:21
 * @description: 1206. 设计跳表 https://leetcode-cn.com/problems/design-skiplist/
 */
public class Skiplist {

    /**
     * 不使用任何库函数，设计一个 跳表 。
     * <p>
     * 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。
     * 跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
     * <p>
     * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
     * <p>
     * 跳表中有很多层，每一层是一个短的链表。
     * 在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。
     * 跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
     * <p>
     * 了解更多 :https://en.wikipedia.org/wiki/Skip_list
     * <p>
     * 在本题中，你的设计应该要包含这些函数：
     * <p>
     * bool search(int target) : 返回target是否存在于跳表中。
     * void add(int num):插入一个元素到跳表。
     * bool erase(int num): 在跳表中删除一个值，如果num不存在，直接返回false. 如果存在多个num，删除其中任意一个即可。
     * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
     * <p>
     * 0 <= num, target <= 2 * 104
     * 调用search, add,  erase操作次数不大于 5 * 104
     */
    public Skiplist() {

    }

    public boolean search(int target) {
        return false;
    }

    public void add(int num) {

    }

    public boolean erase(int num) {
        return false;
    }
}
