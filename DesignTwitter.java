import java.util.*;

class Twitter {

	class Tweet {
		public int tweetID, time;

		Tweet() {
		}

		Tweet(int id, int time) {
			this.tweetID = id;
			this.time = time;
		}
	}

	private int time = 0;

	public Twitter() {

	}

	public void postTweet(int userId, int tweetId) {

	}

	public List<Integer> getNewsFeed(int userId) {

	}

	public void follow(int followerId, int followeeId) {

		

	}

	public void unfollow(int followerId, int followeeId) {

	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */