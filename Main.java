import controller.TwitterController;

public class Main {
	public static void main(String[] args) {
		// controllerをインスタンス化してアプリを開始する
		TwitterController controller = new TwitterController();
		controller.start();
	}
}