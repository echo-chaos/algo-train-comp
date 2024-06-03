package org.lql.hot100.binarySearch;

/**
 * @author: liangqinglong
 * @date: 2024-05-31 17:15
 * @description:
 **/
public class Template {

    public int template(int n, int[] array, int target) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                // find the target!
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分模版：1.1-后继型
     * 查找lower_bound（第一个 >= target 的数），不存在返回n
     * 改为 array[mid] > target upper_bound
     */
    public int template_1_1(int n, int[] array, int target) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (array[mid] >= target) // condition satisfied, should be included
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }

    /**
     * 二分模版：1.2-前驱型
     * 查找最后一个 <= target 的数，不存在返回-1
     */
    public int template_1_2(int n, int[] array, int target) {
        int left = -1, right = n - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (array[mid] <= target) // condition satisfied, should be included
                left = mid;
            else
                right = mid - 1;
        }
        return right;
    }

    /**
     * 二分模版：2
     */
    public int template_2(int n, int[] array, int target) {
        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] <= target) {
                // update ans using mid
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 二分模版：3
     * 答案：要么是left、要么是right，要么不存在
     * 需要检查left和right，返回一个合适的结果
     */
    public int template_3(int n, int[] array, int target) {
        int left = 0, right = n - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (array[mid] <= target)
                left = mid;
            else
                right = mid;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3};
        int target = 2;
        int n = array.length;
        System.out.println(new Template().template(n, array, target));
        System.out.println(new Template().template_1_1(n, array, target));
        System.out.println(new Template().template_1_2(n, array, target));
        System.out.println(new Template().template_2(n, array, target));
        System.out.println(new Template().template_3(n, array, target));
    }
}
