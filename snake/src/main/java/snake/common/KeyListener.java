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
			if(mySnake.getDir() == Dir.RIGHT) {
				bR = true;
			} else {
				bL = true;
			}
			break;
		case KeyEvent.VK_UP:
			if(mySnake.getDir() == Dir.DOWN) {
				bD = true;
			} else {
				bU = true;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(mySnake.getDir() == Dir.LEFT) {
				bL = true;
			} else {
				bR = true;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(mySnake.getDir() == Dir.UP) {
				bU = true;
			} else {
				bD = true;
			}
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
			if(mySnake.getDir() == Dir.RIGHT) {
				bR = false;
			} else {
				bL = false;
			}
			break;
		case KeyEvent.VK_UP:
			if(mySnake.getDir() == Dir.DOWN) {
				bD = false;
			} else {
				bU = false;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(mySnake.getDir() == Dir.LEFT) {
				bL = false;
			} else {
				bR = false;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(mySnake.getDir() == Dir.UP) {
				bU = false;
			} else {
				bD = false;
			}
			break;
		case KeyEvent.VK_ENTER:
			if(mySnake.isLiving()) {
				return;
			}
			
			int x;
			int y;
			ResourceMgr.SNAKE_LIST.clear();
			ResourceMgr.SNAKE_PART_LIST.clear();
			
			mySnake.setX(200);
			mySnake.setY(200);
			mySnake.setDir(Dir.LEFT);
			mySnake.setLiving(true);
			
			// 设置贪吃蛇头部
			ResourceMgr.SNAKE_LIST.add(mySnake);
			
			// 初始化碎块
			for(int i = 0; i < ResourceMgr.SNAKE_PART_COUNT; i++) {
				x = CommonUtil.getRandomInt(55) * 10 + 50;
				y = CommonUtil.getRandomInt(70) * 10 + 50;
				ResourceMgr.SNAKE_PART_LIST.add(new Snake(x,y, Dir.LEFT, true));
			}
			
			// 初始化贪吃蛇
			for(int i = 1; i < ResourceMgr.SNAKE_INIT_COUNT; i++) {
				x = mySnake.getX() + ResourceMgr.SNAKE_WIDTH * i;
				y = mySnake.getY();
				ResourceMgr.SNAKE_LIST.add(new Snake(x,y, Dir.LEFT, true));
			}

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
