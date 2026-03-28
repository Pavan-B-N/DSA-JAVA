package Heaps.Hard.DesignTwitter;
// https://takeuforward.org/practice/dsa/design-twitter?category=faqs&source=strivers-a2z-dsa-sheet&tab=submissions

import java.util.*;

// Time Complexity: O(K log K) for getNewsFeed where K = number of followees
// Space Complexity: O(users + tweets)
class Twitter {
    private Map<Integer, Set<Integer>> followings;
    private Map<Integer, List<int[]>> tweets;
    private int timeStamp = 0;

    public Twitter() {
        followings = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[] { timeStamp++, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        followings.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followee : followings.get(userId)) {
            List<int[]> userTweets = tweets.getOrDefault(followee, new ArrayList<>());

            for (int[] tweet : userTweets) {
                if (minHeap.size() < 10) {
                    minHeap.offer(tweet);
                } else if (minHeap.peek()[0] < tweet[0]) {
                    minHeap.poll();
                    minHeap.offer(tweet);
                }
            }
        }

        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll()[1]);
        }

        Collections.reverse(res);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followings.computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followings.containsKey(followerId)) {
            followings.get(followerId).remove(followeeId);
        }
    }
}

// Time Complexity: O(K log K) for getNewsFeed where K = number of followees
// Space Complexity: O(users + tweets)
public class DesignTwitter {
    public static void main(String[] args) {

    }
}
