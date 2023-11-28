package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.User;

public class UserManager {
	/*
	 * すでに登録されているユーザーを保持する
	 */
	private List<User> userList;
	
	/*
	 * コンストラクタでは空のArrayListを設定する
	 */
	public UserManager() {
		userList = new ArrayList<>();
	}

	/**
     * ユーザー登録を行うメソッド
     * @param scanner
     */
    public void userRegister(Scanner scanner) {

        // ユーザー名とパスワードの入力を受け付ける
        System.out.println("ユーザー登録を行います。");
        System.out.println("ユーザー名を入力してください。");
        String userName = scanner.nextLine();

        System.out.println("パスワードを入力してください");
        String password = scanner.nextLine();

        // 入力値を元にUserクラスを作成する
        User newUser = new User(userName, password);

        // 入力されたユーザー名が既に登録されている場合、処理を終了する
        if (userList.contains(newUser)) {
            System.out.println("ユーザーはすでに登録されています。");
            System.out.println();
            return;
        }

        // ユーザーリストにユーザーを追加する
        userList.add(newUser);

        System.out.println();

        // ユーザー一覧を表示する
        System.out.println("ユーザー一覧");
        for (User user:userList) {
            System.out.println(user.toString());
        }
        System.out.println();
    }

    /**
     * ログイン認証を行う
     * @param scanner
     * @return 成功時：ユーザー名、失敗時：null
     */
    public String login(Scanner scanner) {
        System.out.println("ログインを行います。");
        System.out.println("ユーザー名を入力してください。");
        String userName = scanner.nextLine();

        System.out.println("パスワードを入力してください");
        String password = scanner.nextLine();

        // 入力されたユーザー名とパスワードでUserクラスをインスタンス化
        User loginUser = new User(userName, password);

        // ログインユーザーが存在しているか確認する
        int index = userList.indexOf(loginUser);

        // ログインユーザーが存在する
        if (index >= 0) {
            // ユーザー名が一致しているユーザーを取得
            User user = userList.get(index);

            // パスワードが一致しているか確認する
            boolean loginCheck = user.checkPassword(password);

            if (loginCheck) {
                System.out.println("ログイン成功！");
                // ログインに成功したユーザー名を返却する
                return userName;
            } else {
                System.out.println("ユーザー名もしくはパスワードが間違っています。");
            }
        } else {
            System.out.println("ユーザー名もしくはパスワードが間違っています。");
        }

        return null;
    }
}
