package tank.common;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tank.part.Tank;

public class KeyListener extends KeyAdapter {
	private Tank myTank;
	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;
	
	public KeyListener(Tank myTank) {
		super();
		this.myTank = myTank;
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
		case KeyEvent.VK_Z:
			myTank.fire();
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
			myTank.setMoving(false);
		} else {
			myTank.setMoving(true);
		}

		if (bL) {
			myTank.setDir(Dir.LEFT);
		}
		
		if (bU) {
			myTank.setDir(Dir.UP);
		}
		
		if (bR) {
			myTank.setDir(Dir.RIGHT);
		}
		
		if (bD) {
			myTank.setDir(Dir.DOWN);
		}
	}
}
