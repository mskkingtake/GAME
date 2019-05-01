package snake.common;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowListener extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("欢迎下次再来");
		System.exit(0);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		super.windowActivated(e);
		System.out.println("欢迎光临");
	}
}
