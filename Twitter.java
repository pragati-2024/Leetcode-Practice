import java.util.*;

public class Twitter {
    private static int timeStamp = 0;

    // userId → User object
    private Map<Integer, User> userMap;

    // Tweet class
    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    // User class
    public class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // user follows itself
            tweet_head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        // post tweet (add at head)
        public void post(int tweetId) {
            Tweet t = new Tweet(tweetId);
            t.next = tweet_head;
            tweet_head = t;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if (!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // add all heads
        for (int user : users) {
            Tweet t = userMap.get(user).tweet_head;
            if (t != null) {
                pq.add(t);
            }
        }

        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            count++;

            if (t.next != null) {
                pq.add(t.next);
            }
        }

        return res;
    }

    /** Follow a user */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Unfollow a user */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }

    // Optional Main Method (Testing)
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // [5]

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);

        System.out.println(twitter.getNewsFeed(1)); // [6, 5]

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // [5]
    }
}