package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/24 21:25
 * @description: 239. 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {

    private Deque<HashMap<Integer, Integer>> q = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
//        List<Integer> an = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            HashMap<Integer,Integer> temp = new HashMap<>();
//            temp.put(nums[i],i);
//            q.addLast(temp);
//            if (i >= k -1){
//                while (q.getFirst().entrySet().iterator().next().getValue() <= i-k){
//                    q.pop();
//                }
//                an.add(q.getFirst().entrySet().iterator().next().getKey());
//            }
//        }
//        int[] ans = new int[an.size()];
//        for (int i = 0; i < an.size(); i++) {
//            ans[i] = an.get(i);
//        }
//        return ans;
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        int[] arr = new int[len - k + 1];
        int arr_index = 0;
        //我们需要维护一个单调递增的双向队列
        Deque<Integer> deque = new LinkedList<>();
        //先将第一个窗口的值按照规则入队
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
        }
        //存到数组里，队头元素
        arr[arr_index++] = deque.peekFirst();
        //移动窗口
        for (int j = k; j < len; j++) {
            //对应咱们的红色情况，则是窗口的前一个元素等于队头元素
            if (nums[j - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.offerLast(nums[j]);
            arr[arr_index++] = deque.peekFirst();
        }
        return arr;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
