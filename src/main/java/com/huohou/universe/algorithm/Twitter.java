package com.huohou.universe.algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * <p>
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * <p>
 * 实例：
 * Twitter twitter = new Twitter();
 * <p>
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 * <p>
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 * <p>
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 * <p>
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author naikuoh
 * @DATE 2020/9/14 14:54
 */
public class Twitter {

    /**
     * 推特
     * <用户，推特>
     */
    private Map<Integer, List<Twit>> tweet = new HashMap<>();

    /**
     * 用户，关注人
     */
    private Map<Integer, List<Integer>> userMap = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        tweet = new HashMap<>();
        userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {

        if (tweet.containsKey(userId)) {
            tweet.get(userId).add(new Twit(tweetId, System.currentTimeMillis()));
        } else {
            List<Twit> temp = new ArrayList<>();
            temp.add(new Twit(tweetId, System.currentTimeMillis()));
            tweet.put(userId, temp);
        }

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> user = userMap.get(userId);

        List<Twit> all = new ArrayList<>();

        for (Integer integer : user) {
            all.addAll(tweet.get(integer));
        }
        all.addAll(tweet.get(userId));

        List<Integer> collect = all.stream().sorted((o1, o2) -> {
            if (o1.time > o2.time) {
                return 1;
            } else {
                return -1;
            }
        }).map(r -> r.id).collect(Collectors.toList());

        if (collect.size() > 10) {
            return collect.subList(0, 9);
        } else {
            return collect;
        }

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).add(followeeId);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(followeeId);
            userMap.put(followerId, list);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> integers = userMap.get(followeeId);
        integers.remove(Integer.valueOf(followeeId));
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

}

class Twit {

    public Integer id;
    public long time;

    public Twit(Integer id, long time) {
        this.id = id;
        this.time = time;
    }

}
