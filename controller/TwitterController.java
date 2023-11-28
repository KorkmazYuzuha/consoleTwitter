package controller;

import java.util.Scanner;

import manager.TweetManager;
import manager.UserManager;

public class TwitterController {
	private UserManager userManager;
	private TweetManager tweetManager;
	private String loginUsername;
	
	/*
	 * コンストラクタでUserManagerクラスとTweetManagerクラスを初期化してフィールドで保持する
	 */
	public TwitterController() {
		this.userManager = new UserManager();
		this.tweetManager = new TweetManager();
	}
	
	/*
	 * コンソールアプリのメインとなる処理
	 * ユーザーから操作の番号（1~6）を受け取り対象の操作を実行する
	 */
	public void start() {
		System.out.println("Twitter(Java Console版)へようこそ！");
		Scanner scanner = new Scanner(System.in);
		
		// ユーザーから6が入力されるまで、処理を繰り返す
		while(true) {
			System.out.println("実行する操作を選択してください。");
			System.out.println("1:ユーザー登録");
			System.out.println("2:ログインする");
			System.out.println("3:ログアウトする");
			System.out.println("4:ツイートする");
			System.out.println("5:ツイートの一覧表示をする");
			System.out.println("6:Twitterを終了する");
			
			// ユーザーが選択した処理番号をnextActionとして格納
			String nextAction = scanner.nextLine();
			
			// ユーザーの入力が6だった場合、処理を終了する
			if ("6".equals(nextAction)) {
				break;
			}
			
			// ユーザーの入力に応じて処理を分ける
			switch (nextAction) {
				case "1":
					// インスタンス変数のuserManagerを使って、ユーザーの登録処理を行う
					userManager.userRegister(scanner);
					break;
				case "2":
					// インスタンス変数のuserManagerを使って、ログイン処理を行う
					// 戻り値にはログインしたユーザー名が返ってくる
					this.loginUsername = userManager.login(scanner);
					break;
				case "3":
					// ログインユーザー名をnullに設定して、ログアウトする
					this.loginUsername = null;
					break;
				case "4":
					// ログインしているかチェックする
					if (this.loginUsername == null) {
						System.out.println("ログインしてください。");
						break;
					}
					// ログインしていた場合、インスタンス変数のtweetManagerを使って、ツイートを行う
					tweetManager.tweet(scanner, this.loginUsername);
					break;
				case "5":
					// インスタンス変数のtweetManagerを使って、ツイートを一覧表示する
					tweetManager.outputTweetList();
					break;
			}
		}
		scanner.close();
	}
}
