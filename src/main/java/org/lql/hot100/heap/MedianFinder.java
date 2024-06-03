package org.lql.hot100.heap;

import java.util.PriorityQueue;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 20:45
 * @description: 295. 数据流的中位数 <a href="https://leetcode.cn/problems/find-median-from-data-stream/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MedianFinder {

    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<>((a, b) -> b - a);
        queMax = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 放入小堆
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            // 大堆容量小于小堆容量
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
