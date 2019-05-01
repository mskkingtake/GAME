package tank.part;

import java.awt.Graphics;
import java.util.Random;

import tank.common.CommonUtil;
import tank.common.Dir;

public class Tank {
	private int x;
	private int y;
	private boolean moving = true;
	private Dir dir = Dir.DOWN;
	
	Random random = new Random();
	
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}
	
	
	
	
	

	public void paint(Graphics g) {
		move();
		
		g.fillRect(x, y, 50, 50);
	}
	
	/**
	 * 坦克的移动
	 */
	private void move() {
		if(!moving) {
			return ;
		}
		
		switch (dir) {
		case LEFT:
			x -= CommonUtil.TANK_SPEED;
			break;
		case UP:
			y -= CommonUtil.TANK_SPEED;;
			break;
		case RIGHT:
			x += CommonUtil.TANK_SPEED;;
			break;
		case DOWN:
			y += CommonUtil.TANK_SPEED;;
			break;
		}
		
		if(random.nextInt(10) > 8) {
			System.out.println("aaa");
//			this.fire();
		}
	}

	
	

	
}
