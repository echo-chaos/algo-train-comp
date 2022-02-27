package org.lql.practice.week09;

import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/28 2:33 AM
 * @description: 127. 单词接龙 https://leetcode-cn.com/problems/word-ladder/
 */
public class LadderLength {

    /**
     * 字典wordList 中从单词 beginWord和 endWord 的 转换序列
     * 是一个按下述规格形成的序列beginWord -> s1-> s2-> ... -> sk：
     * <p>
     * 每一对相邻的单词只差一个字母。
     * 对于1 <= i <= k时，每个si都在wordList中。注意， beginWord不需要在wordList中。
     * sk== endWord
     * 给你两个单词 beginWord和 endWord 和一个字典 wordList ，
     * 返回 从beginWord 到endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
     * <p>
     * 1 <= beginWord.length <= 10
     * endWord.length == beginWord.length
     * 1 <= wordList.length <= 5000
     * wordList[i].length == beginWord.length
     * beginWord、endWord 和 wordList[i] 由小写英文字母组成
     * beginWord != endWord
     * wordList 中的所有字符串 互不相同
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }
}
