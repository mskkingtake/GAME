package tank;

public class TankMain {

	public static void main(String[] args) {
		TankFrame tankFrame = new TankFrame();

		while (true) {
			try {
				Thread.sleep(50);
				tankFrame.repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
