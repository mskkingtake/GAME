package snake;

public class SnakeMain {

	public static void main(String[] args) {
		SnakeFrame tankFrame = new SnakeFrame();

		while (true) {
			try {
				Thread.sleep(100);
				tankFrame.repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
