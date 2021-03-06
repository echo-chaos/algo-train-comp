package org.lql.week04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/23 14:27
 * @description: 355. 设计推特 https://leetcode-cn.com/problems/design-twitter/
 */
public class Twitter {

    /**
     * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
     * <p>
     * 实现 Twitter 类：
     * <p>
     * Twitter() 初始化简易版推特对象
     * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
     * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近 10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
     * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
     * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
     * 
     * <p>
     * 示例：
     * 输入
     * ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
     * [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
     * 输出
     * [null, null, [5], null, null, [6, 5], null, [5]]
     */
    private static final Logger logger = LoggerFactory.getLogger(Twitter.class);

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {

    }

    public List<Integer> getNewsFeed(int userId) {

        return new ArrayList<>();
    }

    public void follow(int followerId, int followeeId) {

    }

    public void unfollow(int followerId, int followeeId) {

    }
}
