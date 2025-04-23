import java.util.*;

class Twitter {

    private static int timeStamp = 0;

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> userFollowMap;
    private Map<Integer, List<Tweet>> userTweetMap;

    public Twitter() {
        userFollowMap = new HashMap<>();
        userTweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        
		userTweetMap.putIfAbsent(userId, new ArrayList<>());
        userTweetMap.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        
		Set<Integer> followedUsers = userFollowMap.getOrDefault(userId, new HashSet<>());
        followedUsers.add(userId);

        for (int followeeId : followedUsers) {
            List<Tweet> tweets = userTweetMap.getOrDefault(followeeId, new ArrayList<>());
            for (int i = tweets.size() - 1; i >= 0 && i >= tweets.size() - 10; i--) {
                maxHeap.offer(tweets.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        
		while (!maxHeap.isEmpty() && result.size() < 10) {
            result.add(maxHeap.poll().tweetId);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        
		if (followerId == followeeId) return;
        
		userFollowMap.putIfAbsent(followerId, new HashSet<>());
        userFollowMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followerId == followeeId) return;

        Set<Integer> follows = userFollowMap.get(followerId);

        if (follows != null) {
            follows.remove(followeeId);
        }
    }
}
