package snake.common;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import snake.part.Snake;

public class KeyListener extends KeyAdapter {
	private Snake mySnake;
	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;
	
	public KeyListener(Snake mySnake) {
		super();
		this.mySnake = mySnake;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		case KeyEvent.VK_UP:
			bU = true;
			break;
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
			break;
		default:
			break;
		}
		
		setMainTankDir();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		case KeyEvent.VK_ENTER:

			break;
		default:
			break;
		}
		
		setMainTankDir();
	}
	
	/**
	 * 设置坦克方向
	 */
	private void setMainTankDir() {
		if (!bL && !bU && !bR && !bD) {
			mySnake.setMoving(false);
		} else {
			mySnake.setMoving(true);
		}

		if (bL) {
			mySnake.setDir(Dir.LEFT);
		}
		
		if (bU) {
			mySnake.setDir(Dir.UP);
		}
		
		if (bR) {
			mySnake.setDir(Dir.RIGHT);
		}
		
		if (bD) {
			mySnake.setDir(Dir.DOWN);
		}
	}
}
