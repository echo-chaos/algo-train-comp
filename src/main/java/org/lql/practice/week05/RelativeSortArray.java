package org.lql.practice.week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/2/13 21:20
 * @description: 1122. 数组的相对排序 <a href="https://leetcode-cn.com/problems/relative-sort-array/">...</a>
 */
public class RelativeSortArray {

    /**
     * 给你两个数组，arr1 和arr2，arr2中的元素各不相同，arr2 中的每个元素都出现在arr1中。
     * <p>
     * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。
     * 未在arr2中出现过的元素需要按照升序放在arr1的末尾。
     * <p>
     *
     * <p>
     * 1 <= arr1.length, arr2.length <= 1000
     * 0 <= arr1[i], arr2[i] <= 1000
     * arr2中的元素arr2[i]各不相同
     * arr2 中的每个元素arr2[i]都出现在arr1中
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 记录arr2中每个数字的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        // 将arr1包装成Integer数组
        Integer[] arr1Wrapper = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1Wrapper[i] = arr1[i];
        }
        // 排序
        Arrays.sort(arr1Wrapper, (x, y) -> {
            // 如果x在arr2中，则x的相对位置为map.get(x)，否则为arr2.length
            int xPos = map.containsKey(x) ? map.get(x) : arr2.length;
            int yPos = map.containsKey(y) ? map.get(y) : arr2.length;
            // 如果x和y的位置相同，则按照升序排序
            return xPos - yPos != 0 ? xPos - yPos : x - y;
        });
        // 将Integer数组转换成int数组
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1Wrapper[i];
        }
        return arr1;
    }

    /**
     * 计数法
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        // 统计每个数字出现的次数
        int[] count = new int[1001];
        for (int val : arr1) {
            count[val]++;
        }
        // 遍历arr2，将arr1中arr2中数字出现的次数添加到ans中
        List<Integer> ans = new ArrayList<>();
        for (int val : arr2) {
            while (count[val] > 0) {
                ans.add(val);
                count[val]--;
            }
        }
        // 遍历count，将arr1中arr2中数字以外的数字出现的次数添加到ans中
        for (int val = 0; val < count.length; val++) {
            while (count[val] > 0) {
                ans.add(val);
                count[val]--;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        System.out.println(Arrays.toString(relativeSortArray.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
        System.out.println(Arrays.toString(relativeSortArray.relativeSortArray1(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
