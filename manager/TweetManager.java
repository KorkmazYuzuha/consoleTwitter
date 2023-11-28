package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Tweet;

public class TweetManager {
	private List<Tweet> tweets;
	
	public TweetManager() {
		tweets = new ArrayList<>();
	}
	
	/*
	 * ツイートするためのメソッド
	 * 入力された値をツイートし、ユーザー名と一緒に保存する
	 * @param scanner
	 * @param username
	 */
	public void tweet(Scanner scanner, String username) {
		System.out.println("Tweet内容を入力してください。");
		String tweet = scanner.nextLine();
		
		// Tweetを作成する
		Tweet newTweet = new Tweet(tweet, username);
		tweets.add(newTweet);
		
		System.out.println("ツイートしました。");
	}
	
	/*
	 * ツイートを一覧表示する
	 */
	public void outputTweetList() {
		System.out.println("ツイート一覧");
		
		// インスタンス変数tweetsをループして一つずつ出力する
		for (Tweet tweet: tweets) {
			tweet.outputTweet();
		}
	}
}
